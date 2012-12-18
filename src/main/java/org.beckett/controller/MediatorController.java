package org.beckett.controller;

/**
 * User: Edward
 * Date: 12/16/12
 * Time: 8:04 AM
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/" )
public class MediatorController {

	@RequestMapping
	public String getHomePage() {
		return "redirect:/users";
	}
}