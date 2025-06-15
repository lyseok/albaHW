package kr.or.ddit.alba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // React 개발 서버 주소 
@RequestMapping("/rest/alba")
@RequiredArgsConstructor
public class LYS97RestController {
	private final AlbaService service;
	
	@GetMapping
	public List<AlbaVO> getAlbaList() {
		return service.readAlbaList();
	}
	
	@GetMapping("/{alba}")
	public AlbaVO getAlba(@PathVariable String alba) {
		return service.readAlba(alba);
	}

	// 등록 - PRG 패턴
	@PostMapping
	public Map<String, Object> createAlba(@RequestBody  AlbaVO alba) {
		service.createAlba(alba);
	    return Map.of("ok", true);
	}
	
	// 수정
	@PutMapping("/{albaId}")
	public Map<String, Object> editAlba(
		@PathVariable String albaId
		,  @RequestBody AlbaVO alba
	) {
		alba.setAlId(albaId);
	    service.modifyAlba(alba);
	    return Map.of("ok", true);	// 수정 후 사용자 편의 위한 Detail 이동
	}
	
	@DeleteMapping("/{albaId}")
	public Map<String, Object> deleteAlba(@PathVariable String albaId) {
		service.removeAlba(albaId);
		return Map.of("ok", true);
	}
	
	@GetMapping("/licenseImage")
	public List<LicenseVO> getAlbalicense() {
		return service.readLicenseList();
	}
	
}
