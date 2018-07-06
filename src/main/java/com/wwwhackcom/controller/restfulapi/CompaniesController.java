package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.Companies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.CompaniesService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/companies")
public class CompaniesController {

	@Autowired
	private CompaniesService companiesService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute Companies companies) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute Companies companies) {
		companiesService.save(companies);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		companiesService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public Companies  view(@PathVariable Integer ID) {
		return companiesService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Companies companies) {
		companiesService.update(companies);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return companiesService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Companies> list() {
		return companiesService.list();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<Companies> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return companiesService.page(pageNo, pageSize);
	}

}