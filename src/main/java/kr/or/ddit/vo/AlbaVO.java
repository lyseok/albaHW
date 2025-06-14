package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.validate.constraints.MimeTypeCheck;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="alId")
@ToString
public class AlbaVO implements Serializable{
	@NotBlank(groups = UpdateGroup.class)
	private String alId;
	@NotBlank
	private String alName;
	@NotBlank
	private Integer alAge;
	@NotBlank
	private String alZip;
	@NotBlank
	private String alAdd1;
	@NotBlank
	private String alAdd2;
	@NotBlank
	private String alHp;
	@NotBlank
	private String alGen;
	@NotBlank
	private String alMail;
	private String alCareer;
	private String alSpec;
	private String alDesc;
	private String alImg;
	@MimeTypeCheck(mainType = "image/")
	private MultipartFile alImage;
	@NotBlank
	private String grCode;
	
	private GradeVO grade;
	private List<LicAlbaVO> licAlbaList;
}
