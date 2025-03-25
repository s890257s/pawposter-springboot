package tw.per.allen.model.dto;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import tw.per.allen.model.entity.Member;
import tw.per.allen.utils.JwtUtil;

@Getter
@Setter
public class AuthDto {

	public AuthDto(Member m) {
		BeanUtils.copyProperties(m, this);
		this.jwtToken = JwtUtil.generateToken(m.getMemberId().toString());
	}

	private String jwtToken;
	private String memberName;
	private String memberAccount;
	private String memberStatus;
	private String memberPhoto;

}
