package com.hireartists.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author prayag
 * 
 * @param <PK>
 */
@MappedSuperclass
public abstract class AbstractEntity<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = 8453654076725018243L;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;

	@Version
	@Column
	private int version;

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	@PrePersist
	protected void onCreate() {
		this.created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastModified = new Date();
	}

}
