package kr.or.ddit.alba.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.GradeVO;
import kr.or.ddit.vo.LicenseVO;

public interface AlbaService {
	public void createAlba(AlbaVO alba);
	public List<AlbaVO> readAlbaList();
	public List<AlbaVO>	readAlbaListBySearch(Map<String, Object> params);
	public AlbaVO readAlba(String id);
	
	public void modifyAlba(AlbaVO alba);
	public void removeLicAlba(String id);
	public void removeAlba(String id);
	
	public List<LicenseVO> readLicenseList();
	public List<GradeVO> readGradeList();
}
