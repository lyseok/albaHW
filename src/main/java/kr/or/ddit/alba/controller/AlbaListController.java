package kr.or.ddit.alba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.validate.utils.ErrorsUtils;
import kr.or.ddit.vo.AlbaVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alba")
public class AlbaListController {

    private final ErrorsUtils errorsUtils;
	
	private final AlbaService albaService;

	
	@GetMapping("/albaList.do")
	public String albaList(Model model) {
		List<AlbaVO> albaList = albaService.readAlbaList();
		model.addAttribute("albaList", albaList);
		return "alba/albaList";
	}
	
	@GetMapping("/searchAlba.do")
	public String searchAlba(
		@RequestParam(name = "grCode", required = false) String grCode
		, @RequestParam(name = "licCode", required = false) String licCode
		, @RequestParam(name = "alGen", required = false) String alGen
		, @RequestParam(name = "alName", required = false) String alName
		, @RequestParam(name = "alAdd1", required = false) String alAdd1
		, @RequestParam(name = "alCareer", required = false) String alCareer
		, Model model
	) {
		Map<String, Object> searchMap = new HashMap<>();
		
		if(grCode != null && !grCode.isEmpty()) {
			searchMap.put("grCode", grCode);
		}
		if(licCode != null && !licCode.isEmpty()) {
			searchMap.put("licCode", licCode);
		}
		if(alGen != null && !alGen.isEmpty()) {
			searchMap.put("alGen", alGen);
		}
		if(alName != null && !alName.isEmpty()) {
			searchMap.put("alName", alName);
		}
		if(alAdd1 != null && !alAdd1.isEmpty()) {
			searchMap.put("alAdd1", alAdd1);
		}
		if(alCareer != null && !alCareer.isEmpty()) {
			searchMap.put("alCareer", alCareer);
		}
		
		System.out.println("Search Map: " + searchMap);
		List<AlbaVO> albaList = albaService.readAlbaListBySearch(searchMap);
		
		model.addAttribute("albaList", albaList);
		
		return "alba/albaList";
}
	
}