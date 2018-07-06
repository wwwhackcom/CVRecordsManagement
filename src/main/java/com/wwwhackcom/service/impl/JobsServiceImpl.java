package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.JobsMapper;
import com.wwwhackcom.model.Jobs;
import com.wwwhackcom.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class JobsServiceImpl implements JobsService{

	Logger logger = LoggerFactory.getLogger(JobsService.class);

	@Autowired
	private JobsMapper jobsMapper;

	public Integer save(Jobs jobs){
		return jobsMapper.save(jobs);
	}

	@Override
	public Jobs getByID(Integer ID){
		return jobsMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		jobsMapper.deleteByID(ID);
	}
	@Override
	public void update(Jobs jobs){
		jobsMapper.update(jobs);
	}

	@Override
	public Integer count(){
	    return jobsMapper.count();
	}

	@Override
	public List<Jobs> list(){
		return jobsMapper.list();
	}

	@Override
	public Page<Jobs> page(int pageNo, int pageSize) {
		Page<Jobs> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(jobsMapper.page(start,pageSize));
        page.setTotalCount(jobsMapper.count());
        return page;
	}
	
}