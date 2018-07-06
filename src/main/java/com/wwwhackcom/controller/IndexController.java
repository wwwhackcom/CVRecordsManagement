package com.wwwhackcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Generated;

@Controller
@ApiIgnore
public class IndexController {

	@RequestMapping(value={"/","/index"},method=RequestMethod.GET)
	public String index() {
//		return "Congratulations. Your Application Is Available, <a href='/apis-docs.html'>Apis</a>";
		return "index";
	}

}
