package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AlbaMapperTest {
	
	@Autowired
	AlbaMapper mapper;

	@Test
	void testSelectAlbaList() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectAlbaListBySearch() {
		fail("Not yet implemented");
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
