package gr.hua.dit.it21840.Internalsystem.entity;
import javax.persistence.*;

@Entity
@Table(name="application")
public class Application{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="parent_first_name")
    private String parentFirstName;

    @Column(name="parent_last_name")
    private String parentLastName;

    @Column(name="income")
    private int income;

    @Column(name="child_first_name")
    private String childFirstName;

    @Column(name="child_last_name")
    private String childLastName;

    @Column(name="age")
    private int age;

    public Application(){}
    public Application(String username, String parentFirstName, String parentLastName, int income,
                       String childFirstName, String childLastName, int age){
        this.username=username;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.income=income;
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.age=age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getParentFirstName(){
        return parentFirstName;
    }
    public void setParentFirstName(String parent_first_name){
        this.parentFirstName =parent_first_name;
    }
    public String getParentLastName(){
        return parentLastName;
    }
    public void setParentLastName(String parent_last_name){
        this.parentLastName =parent_last_name;
    }
    public int getIncome(){
        return income;
    }
    public void setIncome(int income){
        this.income=income;
    }
    public String getChildFirstName(){
        return childFirstName;
    }
    public void setChildFirstName(String child_first_name){
        this.childFirstName =child_first_name;
    }
    public String getChildLastName(){
        return childLastName;
    }
    public void setChildLastName(String child_last_name){
        this.childLastName =child_last_name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    @Override
    public String toString(){
        return "Application{"+"id="+id+
                ", username='"+username+'\''+
                ", parent_first_name='"+ parentFirstName +'\''+
                ", parent_last_name='"+ parentLastName +'\''+
                ", income="+income+
                ", child_first_name='"+ childFirstName +'\''+
                ", child_last_name='"+ childLastName +'\''+
                ", age="+age+'}';
    }
}