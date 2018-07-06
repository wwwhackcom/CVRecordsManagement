package com.wwwhackcom.controller.webpage;

import java.util.*;
import com.wwwhackcom.model.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.JobsService;
import javax.annotation.Generated;
import com.wwwhackcom.common.Page;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping(value = "/p/Jobs")
public class JobsPageController {

	@Autowired
	private JobsService jobsService;

	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		if (null != pageNo && pageNo != 1){
			mav.addObject("rows", jobsService.page(pageNo, 10).getResult());
		}else{
			mav.addObject("rows", jobsService.list());
		}
		mav.setViewName("/JobsList");
		return mav;
	}

	@RequestMapping(value = "/detail/{ID}", method= RequestMethod.GET)
	public ModelAndView detail(@PathVariable Integer ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", jobsService.getByID(ID));
		mav.setViewName("/JobsDetail");
		return mav;
	}

	@RequestMapping(value = "/create", method= RequestMethod.GET)
		public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/JobsCreate");
		return mav;
	}

}
