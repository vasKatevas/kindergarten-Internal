package gr.hua.dit.it21840.Internalsystem.entity;
import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authorities{
	@Id
	@Column(name="username")
	private String username;

	@Column(name="authority")
	private String authority;
    
	
	public Authorities(){}
	public Authorities(String username,String authority){
		this.username=username;
		this.authority=authority;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getAuthority(){
		return authority;
	}
	public void setAuthority(String authority){
		this.authority=authority;
	}
	@Override
	public String toString(){
		return "Authorities [username="+username+", authority="+authority+"]";
	}
}