package kr.or.ddit.vo;

import java.io.Serializable;

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
}
