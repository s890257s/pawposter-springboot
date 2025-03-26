package tw.per.allen.model.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.per.allen.model.entity.Member;
import tw.per.allen.utils.DateUtil;

@Setter
@Getter
@ToString
public class MemberDto {

	public MemberDto(Member entity) {
		BeanUtils.copyProperties(entity, this);
	}

	private Integer memberId;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private Date memberBirthDate;
	private Integer age;
	private String memberStatus;
	private byte[] memberPhoto;
	private Date updated;

	public void setMemberBirthDate(Date memberBirthDate) {
		this.memberBirthDate = memberBirthDate;
		this.age = DateUtil.calculateAge(memberBirthDate);
	}

	public Member toEntity() {
		Member entity = new Member();
		BeanUtils.copyProperties(this, entity);
		return entity;
	}

}
