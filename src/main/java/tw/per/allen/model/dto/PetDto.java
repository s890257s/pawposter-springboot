package tw.per.allen.model.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tw.per.allen.model.entity.Pet;
import tw.per.allen.model.enums.VoteState;

@Setter
@Getter
@ToString
public class PetDto {

	public PetDto(Pet entity) {
		BeanUtils.copyProperties(entity, this);
	}

	private Integer petId;
	private Integer memberId;
	private String memberName;
	private String petName;
	private String petType;
	private Date petBirthDate;
	private byte[] petPhoto;
	private Date updated;
	private VoteState voteState = VoteState.NOT_VOTE;

	public Pet toEntity() {
		Pet entity = new Pet();
		BeanUtils.copyProperties(this, entity);
		return entity;
	}
}
