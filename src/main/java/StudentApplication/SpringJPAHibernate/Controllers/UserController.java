package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){
        System.out.println(userObj);
        User userResponse = userRepoObj.save(userObj);

        return userResponse;
    };
//    DELETE AND FINDALL(return type list)
//    @DeleteMapping("/{id}")
//    public void deleteUser(User id){
//        userRepoObj.delete(id);
//    }
    @DeleteMapping("/deleterow")
    public void deleteUser(@RequestBody User userObj)  {
        userRepoObj.delete(userObj);
    }
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepoObj.findAll();
    }

}

