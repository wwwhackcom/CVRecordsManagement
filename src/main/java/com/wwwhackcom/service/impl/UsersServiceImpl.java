package com.wwwhackcom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.wwwhackcom.mapper.UsersMapper;
import com.wwwhackcom.model.Users;
import com.wwwhackcom.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

@Service
public  class UsersServiceImpl implements UsersService{

	Logger logger = LoggerFactory.getLogger(UsersService.class);

	@Autowired
	private UsersMapper usersMapper;

	public Integer save(Users users){
		return usersMapper.save(users);
	}

	@Override
	public Users getByID(Integer ID){
		return usersMapper.getByID(ID);
	}
	@Override
	public void deleteByID(Integer ID){
		usersMapper.deleteByID(ID);
	}
	@Override
	public void update(Users users){
		usersMapper.update(users);
	}

	@Override
	public Integer count(){
	    return usersMapper.count();
	}

	@Override
	public List<Users> list(){
		return usersMapper.list();
	}

	@Override
	public Page<Users> page(int pageNo, int pageSize) {
		Page<Users> page = new Page<>();
        int start = (pageNo-1)*pageSize;
        page.setPageSize(pageSize);
        page.setStart(start);
        page.setResult(usersMapper.page(start,pageSize));
        page.setTotalCount(usersMapper.count());
        return page;
	}
	
}