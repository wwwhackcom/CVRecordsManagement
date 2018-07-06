package com.wwwhackcom.controller.restfulapi;

import java.util.*;
import com.wwwhackcom.model.ApplyRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.ApplyRecordsService;
import com.wwwhackcom.common.Page;
import javax.annotation.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.Generated;

@RestController
@EnableSwagger2
@RequestMapping(value = "/applyRecords")
public class ApplyRecordsController {

	@Autowired
	private ApplyRecordsService applyRecordsService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute ApplyRecords applyRecords) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute ApplyRecords applyRecords) {
		applyRecordsService.save(applyRecords);
	}

	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer ID) {
		applyRecordsService.deleteByID(ID);
	}

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public ApplyRecords  view(@PathVariable Integer ID) {
		return applyRecordsService.getByID(ID);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute ApplyRecords applyRecords) {
		applyRecordsService.update(applyRecords);
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer  count() {
		return applyRecordsService.count();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ApplyRecords> list() {
		return applyRecordsService.list();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<ApplyRecords> page(@RequestParam int pageNo, @RequestParam int pageSize) {
		return applyRecordsService.page(pageNo, pageSize);
	}

}