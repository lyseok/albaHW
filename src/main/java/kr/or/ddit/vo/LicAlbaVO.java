package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of= {"alId", "licCode"})
public class LicAlbaVO implements Serializable{
	
	@NotBlank
	private String alId;
	@NotBlank
	private String licCode;
	@NotBlank
	private String licDate;
	private byte[] licImg;
	
	private LicenseVO license;
	
	private MultipartFile licImage;
	
	public String getLicImgBase64() {
		if(licImg == null) return null;
		return Base64.getEncoder().encodeToString(licImg);
	}
}
