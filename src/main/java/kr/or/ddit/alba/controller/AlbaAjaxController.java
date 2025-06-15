package kr.or.ddit.alba.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.vo.GradeVO;
import kr.or.ddit.vo.LicenseVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ajax")
@RequiredArgsConstructor
public class AlbaAjaxController {
	private final AlbaService albaService;
	
	@GetMapping("/grade")
	public List<GradeVO> gradeList(){
		List<GradeVO> gradeList = albaService.readGradeList();
		return gradeList;
	}
	
	@GetMapping("/license")
	public List<LicenseVO> licenseList(){
		List<LicenseVO> licenseList = albaService.readLicenseList();
		return licenseList;
	}
}
