package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.UsersService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute Users users) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute Users users) {
		usersService.save(users);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		usersService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public Users  view(@PathVariable Integer ID) {
		return usersService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Users users) {
		usersService.update(users);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return usersService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Users> list() {
		return usersService.list();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<Users> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return usersService.page(pageNo, pageSize);
	}

}