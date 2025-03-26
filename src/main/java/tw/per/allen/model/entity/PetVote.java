package tw.per.allen.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.per.allen.model.AbstractAuditEntity;

@Entity
@Table
@Getter
@Setter
@ToString
public class PetVote extends AbstractAuditEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voteId;
	private Integer petId;
	private Integer memberId;
	private Integer voteType;
	private Date voteDate;
}
