package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.UserProfileService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/userProfile")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute UserProfile userProfile) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute UserProfile userProfile) {
		userProfileService.save(userProfile);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		userProfileService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public UserProfile  view(@PathVariable Integer ID) {
		return userProfileService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute UserProfile userProfile) {
		userProfileService.update(userProfile);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return userProfileService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<UserProfile> list() {
		return userProfileService.list();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<UserProfile> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return userProfileService.page(pageNo, pageSize);
	}

}