package tw.per.allen.model;

import java.util.Date;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass // 映射超類別，此標註不會真的產生或指向 Table
@EntityListeners(AbstractAuditEntityListener.class)
@Setter
@Getter
public abstract class AbstractAuditEntity {

	private Date updated;

}
