package tw.per.allen.model.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.Setter;
import tw.per.allen.model.entity.Pet;

@Setter
@Getter
public class PetDto {

	public PetDto(Pet entity) {
		BeanUtils.copyProperties(entity, this);
	}

	private Integer petId;
	private Integer memberId;
	private String petName;
	private String petType;
	private Date petBirthDate;
	private byte[] petPhoto;
	private Date updated;

	public Pet toEntity() {
		Pet entity = new Pet();
		BeanUtils.copyProperties(this, entity);
		return entity;
	}
}
