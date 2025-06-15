package kr.or.ddit.licalba.service;

import java.util.List;

import kr.or.ddit.vo.LicAlbaVO;

public interface LicAlbaService {
	public List<LicAlbaVO> readLicAlbaList(String alId);
	public LicAlbaVO readLicAlba(LicAlbaVO licAlba);
	public void createLicAlba(LicAlbaVO licAlba);
	public void modifyLicAlba(LicAlbaVO licAlba);
	public void removeLicAlba(LicAlbaVO licAlba);
}
