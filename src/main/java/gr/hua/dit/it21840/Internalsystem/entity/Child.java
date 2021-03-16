package gr.hua.dit.it21840.Internalsystem.entity;
import javax.persistence.*;

@Entity
@Table(name="child")
public class Child{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="classroom")
    private int classN;

    public Child(String firstname,String lastname,int classN){
        this.firstname=firstname;
        this.lastname=lastname;
        this.classN=classN;
    }
    public Child(){}
    public int getClassN(){
        return classN;
    }
    public void setClassN(int classN){
        this.classN=classN;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    @Override
    public String toString(){
        return "Child{"+"id="+id+", firstname='"+firstname+'\''+", lastname='"+lastname+'\''+", class="+classN+'}';
    }
}