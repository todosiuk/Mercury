package org.myapp.mercury.app.model.entity.base;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.myapp.mercury.app.model.entity.person.Account;

/**
 * Base class for all business entities
 * 
 * @author todosuk
 *
 */
@MappedSuperclass
public abstract class AbstractEntity {
	/**
	 * Unique entity identifier
	 */
	private long id;
	/**
	 * Timestamp of entity creation
	 */
	private LocalDateTime firstCreated;
	/**
	 * Timestamp of entity last modification
	 */
	private LocalDateTime LastModified;
	/**
	 * Person who created specific entity
	 */
	private Account createdBy;
	/**
	 * Last person who modified entity
	 */
	private Account modifiedBy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FIRST_CREATED", nullable = false, updatable = false)
	public LocalDateTime getFirstCreated() {
		return firstCreated;
	}

	public void setFirstCreated(LocalDateTime firstCreated) {
		this.firstCreated = firstCreated;
	}

	@Column(name = "LAST_MODIFIED", insertable = false)
	public LocalDateTime getLastModified() {
		return LastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		LastModified = lastModified;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	@JoinColumn(name = "CREATED_BY", updatable = false)
	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	@JoinColumn(name = "MODIFIED_BY", insertable = false)
	public Account getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Account modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LastModified == null) ? 0 : LastModified.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((firstCreated == null) ? 0 : firstCreated.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (LastModified == null) {
			if (other.LastModified != null)
				return false;
		} else if (!LastModified.equals(other.LastModified))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (firstCreated == null) {
			if (other.firstCreated != null)
				return false;
		} else if (!firstCreated.equals(other.firstCreated))
			return false;
		if (id != other.id)
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + ", firstCreated=" + firstCreated + ", LastModified=" + LastModified
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}
