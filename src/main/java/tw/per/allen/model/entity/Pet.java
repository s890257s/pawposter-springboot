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
public class Pet  extends AbstractAuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private Integer memberId;
	private String petName;
	private String petType;
	private Date petBirthDate;
	private byte[] petPhoto;
	private Date updated;

}
