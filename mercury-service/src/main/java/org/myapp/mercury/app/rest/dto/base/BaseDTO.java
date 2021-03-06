package org.myapp.mercury.app.rest.dto.base;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;

/**
 * Base class for all DTO classes
 * 
 * @author todosuk
 *
 */
public abstract class BaseDTO<T extends AbstractEntity> {
	/**
	 * Unique entity identifier
	 */
	private long id;

	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic domain model -> DTO is needed. Overridden methods should call
	 * super.transform()
	 */
	public void transform(T t) {
		id = t.getId();
	}

	/**
	 * Should be overridden in the derived classes if additional transformation
	 * logic DTO -> domain model is needed
	 */
	public T untransform(T t) {
		t.setId(getId());
		return t;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
