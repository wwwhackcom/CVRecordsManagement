package com.wwwhackcom.service;

import com.wwwhackcom.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Generated;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@Service
public class UserProfileServiceTest {

	@Autowired
	UserProfileService userProfileService;

	//@Test
	public void testGetByID(){
		String expId = "1";
		Integer iD = new Integer(expId);
		String resultId = userProfileService.getByID(iD).getID()+"";
		Assert.assertEquals(expId, resultId);
	}

}