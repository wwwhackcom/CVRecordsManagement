package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.JobsService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/jobs")
public class JobsController {

	@Autowired
	private JobsService jobsService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute Jobs jobs) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute Jobs jobs) {
		jobsService.save(jobs);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		jobsService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public Jobs  view(@PathVariable Integer ID) {
		return jobsService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Jobs jobs) {
		jobsService.update(jobs);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return jobsService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Jobs> list() {
		return jobsService.list();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<Jobs> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return jobsService.page(pageNo, pageSize);
	}

}