package tw.per.allen.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tw.per.allen.model.AbstractAuditEntity;

@Entity
@Table
@Getter
@Setter
public class Member extends AbstractAuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private Date memberBirthDate;
	private String memberStatus;
	private byte[] memberPhoto;
	private Date updated;
}
