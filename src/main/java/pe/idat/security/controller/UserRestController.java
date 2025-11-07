package pe.idat.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.idat.security.model.User;
import pe.idat.security.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        Optional<User> user = userService.findById(id);
        return user.map( value -> new ResponseEntity<>(value, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<?> createUser(User user){
        if(userService.findByUsername( user.getUsername() ).isPresent()){
            return new ResponseEntity<>("Username ya existe", HttpStatus.BAD_REQUEST);
        }
        User saveUser = userService.save(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        Optional<User> idExists = userService.findById(id);
        if( idExists.isEmpty()){
            return  new ResponseEntity<>("El ID no existe en la base de datos",HttpStatus.NOT_FOUND);
        }

        if(!idExists.get().getUsername().equals(user.getUsername())
            && userService.existsByUsername(user.getUsername())){
            return new ResponseEntity<>("El username ya existe", HttpStatus.BAD_REQUEST);
        }
        user.setId(id);
        User updateUser = userService.save(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Optional<User> idExists = userService.findById(id);
        if( idExists.isEmpty()){
            return new ResponseEntity<>("El ID no existe", HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
