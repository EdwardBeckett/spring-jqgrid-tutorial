package org.beckett.domain;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity( name = "user" ) @NamedQuery( query = "select u from user u where u.username = ?1", name = User.FIND_BY_USERNAME )
public class User {

	public static final String FIND_BY_USERNAME = "User.findByUsername";

	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;

	private String firstName;
	private String lastName;

	@Column( unique = true )
	private String username;

	@JsonIgnore
	private String password;

	@OneToOne( cascade =  CascadeType.ALL, mappedBy = "user" )
	private Role role;


	protected User() {

	}

	public User( String username, String password, String firstName, String lastName, Role role ) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public User( String username, String firstName, String lastName, Role role ) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	public User( String username ) {

		this.username = username;

	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole( Role role ) {
		this.role = role;
	}
}
