package org.myapp.mercury.app.model.entity.person;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.myapp.mercury.app.model.entity.base.AbstractEntity;

/**
 * Entity that encapsulates user of the application
 * 
 * @author todosuk
 *
 */
@Table(name = "ACCOUNT")
@Entity
public class Account extends AbstractEntity {

}
