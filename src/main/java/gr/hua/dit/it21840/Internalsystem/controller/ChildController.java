package gr.hua.dit.it21840.Internalsystem.controller;

import gr.hua.dit.it21840.Internalsystem.entity.Child;
import gr.hua.dit.it21840.Internalsystem.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//@RestController
public class ChildController {

    @Autowired
    private ChildRepository childRepository;

  //  @GetMapping("/children")
    public List<Child> retrieveAllChildren(){

        return (List<Child>) childRepository.findAll();

    }

  //  @PostMapping("/children")
    public ResponseEntity<Object> createStudent(@RequestBody Child child) {
        Child savedChild = childRepository.save(child);
        System.out.println("student id " + savedChild.getId());


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedChild.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

  //  @GetMapping("/children/{id}")
    public Child retrieveStudent(@PathVariable int id) {
        Optional<Child> student = childRepository.findById(id);

        if (!student.isPresent())
            throw new ChildNotFounedExeption("id-" + id);

        return student.get();
    }

 //   @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        childRepository.deleteById(id);
    }

}
