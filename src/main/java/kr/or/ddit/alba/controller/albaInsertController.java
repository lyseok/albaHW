package kr.or.ddit.alba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.service.AlbaServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.AlbaVO;

@Controller
@RequestMapping
public class albaInsertController {
	
	@Autowired
	AlbaServiceImpl service;

	private static final String MODELNAME ="alba";
	
	@GetMapping("/alba/albaInsert.do")
	public String Insert() {
		return "alba/albaInsert";
	}
	
	@PostMapping("/alba/albaInsert.do")
	public String albaInsert(	
@Validated(InsertGroup.class) @ModelAttribute(MODELNAME)AlbaVO alba
, BindingResult errors
, RedirectAttributes redirectAttributes
			){
	
		return "redirect:/";
	}
	
}
