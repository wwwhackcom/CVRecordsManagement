package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.CompaniesMapper;
import com.wwwhackcom.model.Companies;
import com.wwwhackcom.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class CompaniesServiceImpl implements CompaniesService{

	Logger logger = LoggerFactory.getLogger(CompaniesService.class);

	@Autowired
	private CompaniesMapper companiesMapper;

	public Integer save(Companies companies){
		return companiesMapper.save(companies);
	}

	@Override
	public Companies getByID(Integer ID){
		return companiesMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		companiesMapper.deleteByID(ID);
	}
	@Override
	public void update(Companies companies){
		companiesMapper.update(companies);
	}

	@Override
	public Integer count(){
	    return companiesMapper.count();
	}

	@Override
	public List<Companies> list(){
		return companiesMapper.list();
	}

	@Override
	public Page<Companies> page(int pageNo, int pageSize) {
		Page<Companies> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(companiesMapper.page(start,pageSize));
        page.setTotalCount(companiesMapper.count());
        return page;
	}
	
}