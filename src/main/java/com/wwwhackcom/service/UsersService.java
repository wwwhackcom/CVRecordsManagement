package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.Users;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface UsersService{

	Integer save(Users users);

	Integer count();

	Users getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(Users users);

	List<Users> list();

	Page<Users> page(int pageNo, int pageSize);

}