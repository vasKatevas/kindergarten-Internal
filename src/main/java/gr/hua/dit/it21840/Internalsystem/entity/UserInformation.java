package gr.hua.dit.it21840.Internalsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_information")
public class UserInformation {

	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String LastName;

	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="username")
	private User user;
	
	
	public UserInformation(String username, String firstName, String lastName) {
		super();
		this.username = username;
		this.firstName = firstName;
		LastName = lastName;
	}

	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	
	
	
}
