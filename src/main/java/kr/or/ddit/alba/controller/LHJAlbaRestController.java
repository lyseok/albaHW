package kr.or.ddit.alba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({"/rest/alba", "/ajax/alba"})
@RequiredArgsConstructor
public class LHJAlbaRestController {
	private final AlbaService service;

   @GetMapping
   @ResponseBody
   public List<AlbaVO> getAlbaList() {
      return service.readAlbaList();
   }
   
   @GetMapping("/{alba}")
   public AlbaVO getAlba(@PathVariable String alba) {  //경로의존변수 받아서 거기로 이동시 이거 타게
      return service.readAlba(alba);
   }

   // 등록 - PRG 패턴
   @PostMapping
   public Map<String, Object> createAlba(@RequestBody  AlbaVO alba) {  //body 있으므로 어노테이션 필수
      service.createAlba(alba);
      return Map.of("ok", true);
   }
   
   // 수정
   @PutMapping("/{albaId}")
   public Map<String, Object> editAlba(
      @PathVariable String albaId
      , @RequestBody AlbaVO alba
   ) {
      alba.setAlId(albaId);
      service.modifyAlba(alba);
      return Map.of("ok", true);   //json 응답으로 { "ok": true } 나감
   }
   
   @DeleteMapping("/{albaId}")
   public Map<String, Object> deleteAlba(@PathVariable String albaId) {
      service.removeAlba(albaId);
      return Map.of("ok", true);
   }
   
   @GetMapping("/{albaId}/licenseImage")
   public List<LicenseVO> getAlbalicense() {
      return service.readLicenseList();
   }

}
