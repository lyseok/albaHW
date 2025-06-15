package kr.or.ddit.alba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.licalba.service.LicAlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import lombok.RequiredArgsConstructor;

/**
 * REST API를 이용한 Alba & License 관리
 * React 클라이언트와 JSON 통신
 * base URL: /rest/alba
 */

@RestController  //@ResponseBody는 얘랑 중복됨
@CrossOrigin(origins = "http://localhost:5173") // security 안 쓰고, 필터 지정 없을 시 어노테이션 통해 등록 필수.
@RequestMapping("/rest/alba")
@RequiredArgsConstructor
public class LHJAlbaRestController {
	private final AlbaService albaService;
	private final LicAlbaService licAlbaService;

	@GetMapping
	public List<AlbaVO> getAlbaList() {
		return albaService.readAlbaList();
	}

	@GetMapping("/{alba}")
	public AlbaVO getAlba(@PathVariable String alba) { // 경로의존변수 받아서 거기로 이동시 이거 타게
		return albaService.readAlba(alba);
	}

	// 등록 - PRG 패턴
	@PostMapping
	public Map<String, Object> createAlba(@RequestBody AlbaVO alba) { // body 있으므로 어노테이션 필수
		albaService.createAlba(alba);
		return Map.of("ok", true);
	}

	// 수정
	@PutMapping("/{albaId}")
	public Map<String, Object> editAlba(@PathVariable String albaId, @RequestBody AlbaVO alba) {
		alba.setAlId(albaId);
		albaService.modifyAlba(alba);
		return Map.of("ok", true); // json 응답으로 { "ok": true } 나감
	}

	@DeleteMapping("/{albaId}")
	public Map<String, Object> deleteAlba(@PathVariable String albaId) {
		albaService.removeAlba(albaId);
		return Map.of("ok", true);
	}

	@GetMapping("/{albaId}/licenseImage")
	public List<LicAlbaVO> getAlbalicense(@PathVariable String albaId) {
		return licAlbaService.readLicAlbaList(albaId);
	}

}
