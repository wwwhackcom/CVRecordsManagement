package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.JobTypeService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/jobType")
public class JobTypeController {

	@Autowired
	private JobTypeService jobTypeService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute JobType jobType) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute JobType jobType) {
		jobTypeService.save(jobType);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		jobTypeService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public JobType  view(@PathVariable Integer ID) {
		return jobTypeService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute JobType jobType) {
		jobTypeService.update(jobType);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return jobTypeService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<JobType> list() {
		List<JobType> ret = jobTypeService.list();
		return ret;
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<JobType> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return jobTypeService.page(pageNo, pageSize);
	}

}