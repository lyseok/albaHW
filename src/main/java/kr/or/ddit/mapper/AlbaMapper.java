package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.GradeVO;
import kr.or.ddit.vo.LicenseVO;

@Mapper
public interface AlbaMapper {
	
	public List<AlbaVO> selectAlbaList();
	public List<AlbaVO> selectAlbaListBySearch(AlbaVO alba);
	public AlbaVO selectAlba(String alId);
	public int insertAlba(AlbaVO alba);
	public int updateAlba(AlbaVO alba);
	public int deleteLicAlba(String alId);
	public int deleteAlba(String alId);
	
	public List<GradeVO> selectGradeList();
	public List<LicenseVO> selectLicenseList();
}
