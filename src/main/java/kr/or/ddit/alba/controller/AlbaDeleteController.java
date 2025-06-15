package kr.or.ddit.alba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.alba.service.AlbaService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alba/albaDelete.do")
public class AlbaDeleteController {
	
	private final AlbaService albaService;
	
	@GetMapping
	public String deleteAlba(@RequestParam(name = "alId") String who) {
		albaService.removeLicAlba(who);
		albaService.removeAlba(who);
		
		return "redirect:/alba/albaList.do";
	}
}
