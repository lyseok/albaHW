package kr.or.ddit.alba.service;

import java.util.List;

public interface AlbaService {
	public void createAlba( alba);
	public List<AlbaVO> readAlbaList();
	public List<AlbaVO> readDetailAlbaList(AlbaVO alba);
	public AlbaVO readAlba(String id);
	
	public void modifyAlba(AlbaVO alba);
	public void removeAlba(String id);
	
	public List<LicenseVO> readLicenseList();
}
