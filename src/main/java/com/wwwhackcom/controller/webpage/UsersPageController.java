package com.wwwhackcom.controller.webpage;

import java.util.*;
import com.wwwhackcom.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.UsersService;
import javax.annotation.Generated;
import com.wwwhackcom.common.Page;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping(value = "/p/Users")
public class UsersPageController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		if (null != pageNo && pageNo != 1){
			mav.addObject("rows", usersService.page(pageNo, 10).getResult());
		}else{
			mav.addObject("rows", usersService.list());
		}
		mav.setViewName("/UsersList");
		return mav;
	}

	@RequestMapping(value = "/detail/{ID}", method= RequestMethod.GET)
	public ModelAndView detail(@PathVariable Integer ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", usersService.getByID(ID));
		mav.setViewName("/UsersDetail");
		return mav;
	}

	@RequestMapping(value = "/create", method= RequestMethod.GET)
		public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/UsersCreate");
		return mav;
	}

}
