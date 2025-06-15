package kr.or.ddit.alba.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mapper.AlbaMapper;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbaServiceImpl implements AlbaService{
	
	private final AlbaMapper mapper;
	
	@Value("${imagesFolder}")
	private File imagesFolder;
	


	@Override
	public void createAlba(AlbaVO alba) {
		//albaImgae(alba);
		mapper.insertAlba(alba);
	}

	@Override
	public List<AlbaVO> readAlbaList() {
		return mapper.selectAlbaList();
	}
	
	@Override
	public List<AlbaVO> readSearchAlbaList(AlbaVO alba) {
		return mapper.selectAlbaListBySearch(alba);
	}

	@Override
	public AlbaVO readAlba(String id) {
		return mapper.selectAlba(id);
	}

	@Override
	public void modifyAlba(AlbaVO alba) {
		//albaImgae(alba);
		mapper.updateAlba(alba);
	}

	@Override
	public void removeAlba(String id) {
		mapper.deleteAlba(id);
	}
	
	
	@Override
	public List<LicenseVO> readLicenseList() {
		return mapper.selectLicenseList();
	}
	
	
	
	

	
	private void albaImage(AlbaVO alba) {
		MultipartFile albaImage = alba.getAlImg();
		if(albaImage!=null && !albaImage.isEmpty()) {
			
			String saveName = UUID.randomUUID().toString();
			alba.setAlbaImg(saveName);
			File saveFile = new File(imagesFolder, saveName);
			try {
				albaImage.transferTo(saveFile);
			}catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	
//	
//	private void licenseImage(LicAlbaVO licAlba) {
//		try {
//			MultipartFile licenseImage = licAlba.getLicImg();
//			if(licenseImage==null || licenseImage.isEmpty()) return;
//			
//			byte[] licenseImg = licenseImage.getBytes();
//			licaAlba.setLicImg(licenseImg);
//		}catch(IOException e) {
//			throw new RuntimeException();
//		}
//	}
//	

}
