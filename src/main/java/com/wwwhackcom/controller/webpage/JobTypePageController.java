package com.wwwhackcom.controller.webpage;

import java.util.*;
import com.wwwhackcom.model.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.JobTypeService;
import javax.annotation.Generated;
import com.wwwhackcom.common.Page;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping(value = "/p/JobType")
public class JobTypePageController {

	@Autowired
	private JobTypeService jobTypeService;

	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		if (null != pageNo && pageNo != 1){
			mav.addObject("rows", jobTypeService.page(pageNo, 10).getResult());
		}else{
			mav.addObject("rows", jobTypeService.list());
		}
		mav.setViewName("/JobTypeList");
		return mav;
	}

	@RequestMapping(value = "/detail/{ID}", method= RequestMethod.GET)
	public ModelAndView detail(@PathVariable Integer ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", jobTypeService.getByID(ID));
		mav.setViewName("/JobTypeDetail");
		return mav;
	}

	@RequestMapping(value = "/create", method= RequestMethod.GET)
		public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/JobTypeCreate");
		return mav;
	}

}
