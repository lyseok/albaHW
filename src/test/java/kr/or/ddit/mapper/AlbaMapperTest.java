package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.ddit.vo.AlbaVO;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AlbaMapperTest {
	
	@Autowired
	AlbaMapper mapper;

	@Test
	void testSelectAlbaList() {
		mapper.selectAlbaList().forEach(alba->{
			log.info("{}", alba);
			alba.getLicAlbaList().forEach(lic->
				log.info("lic : {}", lic)
			);
			log.info("{}", alba.getGrade().getGrCode());
			log.info("{}", alba.getGrade().getGrName());
		});
	}

	@Test
	void testSelectAlbaListBySearch() {
		Map<String, Object> params = 
				Map.of("grCode", "G003"
						, "licCode"	, "L002"
						, "alGen" , "M"
						, "alAdd1", "1te"
						, "alCareer", ""
				);
		mapper.selectAlbaListBySearch(params).forEach(al ->
			log.info("{}", al)
		);
	}

	@Test
	void testSelectAlba() {
		
		log.info("{}", mapper.selectAlba("A0000001"));
	}

	@Test
	void testInsertAlba() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAlba() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAlba() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectGradeList() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectLicenseList() {
		fail("Not yet implemented");
	}

}
