package coding.dsa;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/v1")
public class UserController {


    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(){
        User user = new User("test",1, "test email");

        return ResponseEntity.ok(user);
    }
}
