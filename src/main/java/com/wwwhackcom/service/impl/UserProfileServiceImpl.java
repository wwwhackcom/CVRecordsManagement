package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.UserProfileMapper;
import com.wwwhackcom.model.UserProfile;
import com.wwwhackcom.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class UserProfileServiceImpl implements UserProfileService{

	Logger logger = LoggerFactory.getLogger(UserProfileService.class);

	@Autowired
	private UserProfileMapper userProfileMapper;

	public Integer save(UserProfile userProfile){
		return userProfileMapper.save(userProfile);
	}

	@Override
	public UserProfile getByID(Integer ID){
		return userProfileMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		userProfileMapper.deleteByID(ID);
	}
	@Override
	public void update(UserProfile userProfile){
		userProfileMapper.update(userProfile);
	}

	@Override
	public Integer count(){
	    return userProfileMapper.count();
	}

	@Override
	public List<UserProfile> list(){
		return userProfileMapper.list();
	}

	@Override
	public Page<UserProfile> page(int pageNo, int pageSize) {
		Page<UserProfile> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(userProfileMapper.page(start,pageSize));
        page.setTotalCount(userProfileMapper.count());
        return page;
	}
	
}