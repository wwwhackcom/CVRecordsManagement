package com.wwwhackcom.controller.webpage;

import java.util.*;
import com.wwwhackcom.model.ApplyRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wwwhackcom.service.ApplyRecordsService;
import javax.annotation.Generated;
import com.wwwhackcom.common.Page;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping(value = "/p/ApplyRecords")
public class ApplyRecordsPageController {

	@Autowired
	private ApplyRecordsService applyRecordsService;

	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list(@RequestParam(value = "p", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		if (null != pageNo && pageNo != 1){
			mav.addObject("rows", applyRecordsService.page(pageNo, 10).getResult());
		}else{
			mav.addObject("rows", applyRecordsService.list());
		}
		mav.setViewName("/ApplyRecordsList");
		return mav;
	}

	@RequestMapping(value = "/detail/{ID}", method= RequestMethod.GET)
	public ModelAndView detail(@PathVariable Integer ID) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", applyRecordsService.getByID(ID));
		mav.setViewName("/ApplyRecordsDetail");
		return mav;
	}

	@RequestMapping(value = "/create", method= RequestMethod.GET)
		public ModelAndView create() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ApplyRecordsCreate");
		return mav;
	}

}
