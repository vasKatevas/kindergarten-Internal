package gr.hua.dit.it21840.Internalsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User{
	
	@Id
	@Column(name= "username")
	private String username;

	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private int enabled;
	
	public User(){}
	public User(String username,String password,int enabled){
		this.username=username;
		this.password=password;
		this.enabled=enabled;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public int isEnabled(){
		return enabled;
	}
	public void setEnabled(int enabled){
		this.enabled=enabled;
	}
}