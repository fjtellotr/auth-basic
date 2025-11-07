package pe.idat.security.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.idat.security.model.Instructor;
import pe.idat.security.service.InstructorService;


@RestController
@RequestMapping
public class InstructorRestController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/listar_public")
    public ResponseEntity<?> listarPUBLIC() 	{
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }

    @GetMapping("/listar_admin")
    public ResponseEntity<?> listarADMIN() {
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }

    @GetMapping("/listar_user")
    public ResponseEntity<?> listarUSER() {
        Collection<Instructor> itemsInstructor=instructorService.findAll();

        if(itemsInstructor.isEmpty()) {
            return new ResponseEntity<>(itemsInstructor,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
    }

}
