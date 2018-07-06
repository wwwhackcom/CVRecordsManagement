package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.Jobs;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface JobsService{

	Integer save(Jobs jobs);

	Integer count();

	Jobs getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(Jobs jobs);

	List<Jobs> list();

	Page<Jobs> page(int pageNo, int pageSize);

}