package gr.hua.dit.it21840.Internalsystem.controller;

import gr.hua.dit.it21840.Internalsystem.entity.*;
import gr.hua.dit.it21840.Internalsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class Home {


    @Autowired
    private UserRepository user;
    @Autowired
    private AuthorityRepository author;
    @Autowired
    private TeacherRepository teacherr;
    @Autowired
    private TeacherRepository teacherRepo;
    @Autowired
    private UserInformationRepository userInformationn;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private ChildRepository child;


    @GetMapping("/")
    public String home(Model model, Principal principal){
        List<Authorities> users=author.findAll();
        Teacher teacher=teacherr.getTeacherByUsername(principal.getName());
        List<Child> childList=null;
        try {
            childList=child.getChildByClassN(teacher.getClassN());
        }catch(Exception ignored) {}
        model.addAttribute("teacher",teacher);
        model.addAttribute("child",childList);
        model.addAttribute("users",users);
        model.addAttribute("username",principal.getName());
        return "index";

    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request){
        User check=user.getUserByUsername(request.getParameter("deleteUsername"));
        if(check!=null)
            user.deleteByUsername(request.getParameter("deleteUsername"));
        return "index";
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping("/register")
    public String register(HttpServletRequest request){


        User check=user.getUserByUsername(request.getParameter("username"));

        if(check==null){
            String musername=request.getParameter("username");
            String mpassword=request.getParameter("password");
            String role=request.getParameter("role");
            String newRole="ROLE_"+role.toUpperCase();
            System.out.print(newRole+"\n");


            User a=new User(musername,passwordEncoder.encode(mpassword),1);
            Authorities b=new Authorities(musername,newRole);
            user.save(a);
            author.save(b);

            if (role.contains("teacher")) {

                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String classN = request.getParameter("class");

                Teacher teacher = new Teacher(musername,Integer.parseInt(classN));
                teacherr.save(teacher);

                UserInformation userInformation = new UserInformation(musername,firstname,lastname);
                userInformationn.save(userInformation);

            }else if(role.contains("manager")){
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");


                UserInformation userInformation = new UserInformation(musername,firstname,lastname);
                userInformationn.save(userInformation);
            }

        }
        return "index";
    }

}
