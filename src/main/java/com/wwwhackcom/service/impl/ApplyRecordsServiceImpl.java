package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.ApplyRecordsMapper;
import com.wwwhackcom.model.ApplyRecords;
import com.wwwhackcom.service.ApplyRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class ApplyRecordsServiceImpl implements ApplyRecordsService{

	Logger logger = LoggerFactory.getLogger(ApplyRecordsService.class);

	@Autowired
	private ApplyRecordsMapper applyRecordsMapper;

	public Integer save(ApplyRecords applyRecords){
		return applyRecordsMapper.save(applyRecords);
	}

	@Override
	public ApplyRecords getByID(Integer ID){
		return applyRecordsMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		applyRecordsMapper.deleteByID(ID);
	}
	@Override
	public void update(ApplyRecords applyRecords){
		applyRecordsMapper.update(applyRecords);
	}

	@Override
	public Integer count(){
	    return applyRecordsMapper.count();
	}

	@Override
	public List<ApplyRecords> list(){
		return applyRecordsMapper.list();
	}

	@Override
	public Page<ApplyRecords> page(int pageNo, int pageSize) {
		Page<ApplyRecords> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(applyRecordsMapper.page(start,pageSize));
        page.setTotalCount(applyRecordsMapper.count());
        return page;
	}
	
}