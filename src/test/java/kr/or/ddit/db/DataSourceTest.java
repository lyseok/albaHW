package kr.or.ddit.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DataSourceTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	void test() {
		log.info("dataSource : {}", dataSource);
	}
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	void testSqlSessionFactory() {
		log.info("sqlSessionFactory : {}", sqlSessionFactory);
		log.info("sqlSession : {}", sqlSession);
	}

}
