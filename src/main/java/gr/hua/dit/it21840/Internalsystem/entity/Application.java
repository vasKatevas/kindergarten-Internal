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
    private String parent_first_name;

    @Column(name="parent_last_name")
    private String parent_last_name;

    @Column(name="income")
    private int income;

    @Column(name="child_first_name")
    private String child_first_name;

    @Column(name="child_last_name")
    private String child_last_name;

    @Column(name="age")
    private int age;

    public Application(){}
    public Application(String username,String parent_first_name,String parent_last_name,int income,
                       String child_first_name,String child_last_name,int age){
        this.username=username;
        this.parent_first_name=parent_first_name;
        this.parent_last_name=parent_last_name;
        this.income=income;
        this.child_first_name=child_first_name;
        this.child_last_name=child_last_name;
        this.age=age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getParent_first_name(){
        return parent_first_name;
    }
    public void setParent_first_name(String parent_first_name){
        this.parent_first_name=parent_first_name;
    }
    public String getParent_last_name(){
        return parent_last_name;
    }
    public void setParent_last_name(String parent_last_name){
        this.parent_last_name=parent_last_name;
    }
    public int getIncome(){
        return income;
    }
    public void setIncome(int income){
        this.income=income;
    }
    public String getChild_first_name(){
        return child_first_name;
    }
    public void setChild_first_name(String child_first_name){
        this.child_first_name=child_first_name;
    }
    public String getChild_last_name(){
        return child_last_name;
    }
    public void setChild_last_name(String child_last_name){
        this.child_last_name=child_last_name;
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
                ", parent_first_name='"+parent_first_name+'\''+
                ", parent_last_name='"+parent_last_name+'\''+
                ", income="+income+
                ", child_first_name='"+child_first_name+'\''+
                ", child_last_name='"+child_last_name+'\''+
                ", age="+age+'}';
    }
}