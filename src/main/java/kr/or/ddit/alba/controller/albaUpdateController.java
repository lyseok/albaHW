package kr.or.ddit.alba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AlbaVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/alba/albaUpdate.do")
public class albaUpdateController{

	private final AlbaService service ;
	
	static final String MODELNAME ="alba";
	
	@ModelAttribute(MODELNAME)
	public AlbaVO alba() {
		return new AlbaVO();
	}
	
	@GetMapping
//	public String Update(
//			@RequestParam(name="what") String what,
//			@Validated(UpdateGroup.class) 
//			@ModelAttribute(MODELNAME)AlbaVO alba
//			, BindingResult errors
//			, RedirectAttributes redirectAttributes		
//			) {
//		if(alba!= null) {
//			alba = service.readAlba(what);
//		}
//		log.info("what : {}",what);
//		log.info("alba : {}", alba);
//		return "alba/albaUpdate";
//	}
	
	public String Update(
		String what
		, Model model
			) {
		if(model.containsAttribute(MODELNAME)) {
			AlbaVO alba = service.readAlba(what);
			model.addAttribute(MODELNAME, alba);
		}
		
		return "alba/albaUpdate";
	}
	
	
	@PostMapping
	public String UpdateAlba(
			 @Validated(UpdateGroup.class) @ModelAttribute(MODELNAME)AlbaVO alba	
			, BindingResult errors
			, RedirectAttributes redirectAttributes
			){

		service.modifyAlba(alba);
		return "/alba/albaView";
	}
}
