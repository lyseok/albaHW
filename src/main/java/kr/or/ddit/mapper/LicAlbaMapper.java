package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LicAlbaVO;

@Mapper
public interface LicAlbaMapper {
	public List<LicAlbaVO> getLicAlbaList(String alId);
	public LicAlbaVO getLicAlba(LicAlbaVO licAlba);
	public int insertLicAlba(LicAlbaVO licAlba);
	public int updateLicAlba(LicAlbaVO licAlba);
	public int deleteLicAlba(LicAlbaVO licAlba);
}
