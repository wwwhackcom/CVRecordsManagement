package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.ApplyRecords;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface ApplyRecordsService{

	Integer save(ApplyRecords applyRecords);

	Integer count();

	ApplyRecords getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(ApplyRecords applyRecords);

	List<ApplyRecords> list();

	Page<ApplyRecords> page(int pageNo, int pageSize);

}