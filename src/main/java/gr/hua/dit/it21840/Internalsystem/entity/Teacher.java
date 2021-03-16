package gr.hua.dit.it21840.Internalsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="class")
	private int classN;

	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="username")
	private User TeacherUser;
	
	
	public Teacher(String username, int classN) {
		this.username = username;
		this.classN = classN;
	}

	public Teacher() {}
	
	
	
	public User getTeacherUser() {
		return TeacherUser;
	}

	public void setTeacherUser(User teacherUser) {
		TeacherUser = teacherUser;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public int getClassN() {
		return classN;
	}
	
	public void setClassN(int classN) {
		this.classN = classN;
	}
	
	
	

	

}
