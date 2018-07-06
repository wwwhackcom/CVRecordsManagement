package com.wwwhackcom.service;
import java.util.*;
import com.wwwhackcom.model.UserProfile;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;

public interface UserProfileService{

	Integer save(UserProfile userProfile);

	Integer count();

	UserProfile getByID(Integer ID);

	void deleteByID(Integer ID);

	void update(UserProfile userProfile);

	List<UserProfile> list();

	Page<UserProfile> page(int pageNo, int pageSize);

}