package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.Companies;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface CompaniesService{

	Integer save(Companies companies);

	Integer count();

	Companies getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(Companies companies);

	List<Companies> list();

	Page<Companies> page(int pageNo, int pageSize);

}