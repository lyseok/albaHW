package kr.or.ddit.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="licCode")
public class LicenseVO implements Serializable{
	
	@NotBlank
	private String licCode;
	@NotBlank
	private String licName;
}
