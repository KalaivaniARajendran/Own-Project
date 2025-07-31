package com.example.Springboot_1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springboot_1.Model.College;
import com.example.Springboot_1.repository.college_repository;

@CrossOrigin(origins="http://localhost:8080" )
@RestController
@RequestMapping("/api")

public class college_controller {
	
@Autowired 
college_repository collegerepository;

@GetMapping("/college")

public ResponseEntity<List<College>> getcollege()
{
    try {
        List<College> c = collegerepository.findAll();

        if (c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(c, HttpStatus.OK);        }
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
    }
}

@GetMapping("/college/status")
public ResponseEntity<List<College>> findbystatus() {
  try {
    List<College> c = collegerepository.findByStatus(true);
    if (c.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(c,HttpStatus.OK);
    
  } catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}


@PostMapping("/college")
public ResponseEntity<College> createCollege(@RequestBody College college) 
{
   try 
   {
        College _college = collegerepository.save(
            new College(college.getName(), college.getDept(), college.isStatus()));
        return new ResponseEntity<>(_college, HttpStatus.CREATED); 
    } 
  catch (Exception e) 
   {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}


 @PutMapping("/college/{id}")
 public ResponseEntity<College> updatecollege
 (@PathVariable long id, @RequestBody College college)
 {
  Optional<College> putdata = collegerepository.findById(id);
	if (putdata.isPresent())
	{
	 College _putdata = putdata.get(); 		    
	 _putdata.setName(college.getName());
	 _putdata.setDept(college.getDept());
	 _putdata.setStatus(college.isStatus());
	  return new ResponseEntity<>(collegerepository.save(_putdata), HttpStatus.OK);
	} 
	else 
	{
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
 
 @DeleteMapping("/college/{id}")
 public ResponseEntity<HttpStatus> deletecollege(@PathVariable long id,@RequestBody College college)
 {
   try 
   {
     collegerepository.deleteById(id);
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   } 
   catch (Exception e) 
   {
     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
 }

 @DeleteMapping("/college")
 public ResponseEntity<HttpStatus> deleteAllTutorials()
 {
   try 
   {
     collegerepository.deleteAll();
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   catch (Exception e) 
   {
     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
 }


}










