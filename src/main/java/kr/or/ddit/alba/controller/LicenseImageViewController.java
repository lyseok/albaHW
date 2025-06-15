package kr.or.ddit.alba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.licalba.service.LicAlbaService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alba/licenseImage.do")
public class LicenseImageViewController {
	
	private final LicAlbaService service;
	
	@GetMapping
	public String licensImageView() {
		return "alba/licenseImageView";
	}

}
