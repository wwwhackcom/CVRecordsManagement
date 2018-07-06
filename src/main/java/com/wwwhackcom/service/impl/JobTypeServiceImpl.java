package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.JobTypeMapper;
import com.wwwhackcom.model.JobType;
import com.wwwhackcom.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class JobTypeServiceImpl implements JobTypeService{

	Logger logger = LoggerFactory.getLogger(JobTypeService.class);

	@Autowired
	private JobTypeMapper jobTypeMapper;

	public Integer save(JobType jobType){
		return jobTypeMapper.save(jobType);
	}

	@Override
	public JobType getByID(Integer ID){
		return jobTypeMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		jobTypeMapper.deleteByID(ID);
	}
	@Override
	public void update(JobType jobType){
		jobTypeMapper.update(jobType);
	}

	@Override
	public Integer count(){
	    return jobTypeMapper.count();
	}

	@Override
	public List<JobType> list() {
		return jobTypeMapper.list();
	}

	@Override
	public Page<JobType> page(int pageNo, int pageSize) {
		Page<JobType> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(jobTypeMapper.page(start,pageSize));
        page.setTotalCount(jobTypeMapper.count());
        return page;
	}
	
}