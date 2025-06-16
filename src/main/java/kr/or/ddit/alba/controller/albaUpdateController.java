package kr.or.ddit.alba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alba/albaUpdate.do")
public class albaUpdateController{

	@GetMapping
	public String Update() {
		return "alba/albaUpdate";
	}
}
