package kr.or.ddit.alba.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.licalba.service.LicAlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import kr.or.ddit.vo.LicenseVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alba/albaView.do")
public class AlbaViewController {
	private final AlbaService albaService;
	private final LicAlbaService alcService;
	
	
	@GetMapping
	public String albaView(Model model) {
		
		String albaId = "A0000001";
		AlbaVO alba = albaService.readAlba(albaId);
		List<LicAlbaVO> licList = alcService.readLicAlbaList(albaId);
		model.addAttribute("alba", alba);
		model.addAttribute("licAlba", licList);
		return "alba/albaView";
	}
}
