package tw.per.allen.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Component
public class AbstractAuditEntityListener {

	@PrePersist
	public void beforeCreate(AbstractAuditEntity entity) {
	}

	@PreUpdate
	public void beforeUpdate(AbstractAuditEntity entity) {
		entity.setUpdated(new Date());
	}

}
