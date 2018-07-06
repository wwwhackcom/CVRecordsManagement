package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.JobType;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface JobTypeService{

	Integer save(JobType jobType);

	Integer count();

	JobType getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(JobType jobType);

	List<JobType> list();

	Page<JobType> page(int pageNo, int pageSize);

}