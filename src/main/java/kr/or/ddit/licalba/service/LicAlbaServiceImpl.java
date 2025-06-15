package kr.or.ddit.licalba.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mapper.LicAlbaMapper;
import kr.or.ddit.vo.LicAlbaVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicAlbaServiceImpl implements LicAlbaService {
	private final LicAlbaMapper mapper;
	
	@Override
	public List<LicAlbaVO> readLicAlbaList(String alId) {
		return mapper.getLicAlbaList(alId);
	}

	@Override
	public LicAlbaVO readLicAlba(LicAlbaVO licAlba) {
		return mapper.getLicAlba(licAlba);
	}

	@Override
	public void createLicAlba(LicAlbaVO licAlba) {
		processImage(licAlba);
		mapper.insertLicAlba(licAlba);
	}

	@Override
	public void modifyLicAlba(LicAlbaVO licAlba) {
		processImage(licAlba);
		mapper.updateLicAlba(licAlba);
	}

	@Override
	public void removeLicAlba(LicAlbaVO licAlba) {
		mapper.deleteLicAlba(licAlba);
	}
	
	private void processImage(LicAlbaVO licAlba) {
		MultipartFile licAlbaImage = licAlba.getLicImage();
		try {
			if(licAlbaImage == null || licAlbaImage.isEmpty()) return;
			byte[] licAlbaImg = licAlbaImage.getBytes();
			licAlba.setLicImg(licAlbaImg);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
