package kr.or.ddit.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="grCode")
public class GradeVO implements Serializable{
	@NotBlank
	private String grCode;
	@NotBlank
	private String grName;
}
