package org.beckett.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * User: Edward
 * Date: 12/16/12
 * Time: 5:59 AM
 */

@Entity( name = "role" )
public class Role {

	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private long id;

	@OneToOne
	private User user;
	private Integer role;

	public Role() {
	}

	public Role( Integer role ) {

		this.role = role;

	}

	public long getId() {
		return id;
	}

	public void setId( long id ) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole( Integer role ) {
		this.role = role;
	}

}