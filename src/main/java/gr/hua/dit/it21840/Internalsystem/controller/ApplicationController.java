package gr.hua.dit.it21840.Internalsystem.controller;
import gr.hua.dit.it21840.Internalsystem.entity.Application;
import gr.hua.dit.it21840.Internalsystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.function.Consumer;

@RestController
public class ApplicationController{

    @Autowired
    private ApplicationRepository applicationRepo;

    @Secured("ROLE_MANAGER")
    @GetMapping("/applications/{lastname}")
    public List<Application> getApplicationsByLastName(@PathVariable String lastname){
        return applicationRepo.getApplicationByParentLastName(lastname);
    }
    @Secured("ROLE_MANAGER")
    @GetMapping("/applications")
    public List<Application> getApplications(){
        List<Application> applicationList = new ArrayList<>();
        applicationRepo.findAll().forEach(new Consumer<Application>() {
            @Override
            public void accept(Application application) {
                applicationList.add(application);
            }
        });
        return applicationList;

    }

  //  https://stackoverflow.com/questions/33796218/content-type-application-x-www-form-urlencodedcharset-utf-8-not-supported-for
  // https://stackoverflow.com/questions/31935819/issue-with-restcontroller-and-application-x-www-form-urlencodedcharset-utf-8-me


  //  @Secured("ROLE_EXTERNAL")
    @RequestMapping(value = "/applications", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> addApplication( @RequestParam MultiValueMap<String,String> paramMap) throws Exception{
       // applicationRepo.save(application);

        Application application = new Application(paramMap.getFirst("username"),
                paramMap.getFirst("parentFirstName"),
                paramMap.getFirst("parentLastName"),
                Integer.parseInt(Objects.requireNonNull(paramMap.getFirst("income"))),
                paramMap.getFirst("childFirstName"),
                paramMap.getFirst("childLastName"),
                Integer.parseInt(Objects.requireNonNull(paramMap.getFirst("age"))));
        applicationRepo.save(application);
        return new ResponseEntity<String>(paramMap.getFirst("parentFirstName"), HttpStatus.OK);
    }

    @Secured("ROLE_MANAGER")
    @DeleteMapping("/applications/{applicationId}")
    public String deleteCustomer(@PathVariable int applicationId){
        applicationRepo.deleteById(applicationId);
        return applicationId+"";
    }
}