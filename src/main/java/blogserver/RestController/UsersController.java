package blogserver.RestController;

import blogserver.models.Users;
import org.springframework.web.bind.annotation.*;
import blogserver.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<Users> getUsers(@Valid @RequestBody Users users, @RequestParam("type")String reqType) {
        if (reqType.equals("show_all")) {
            return repository.findAll();
        }
        if (reqType.equals("by_id")) {
            return Arrays.asList(repository.findBy_id(users._id));
        }
        else {
            return null;
        }
    }

    @PutMapping
    public void modifyUserById(@Valid @RequestBody Users users) {
        users.set_id(users._id);
        repository.save(users);
    }

    @PostMapping
    public Users createUser(@Valid @RequestBody Users users) {
        users.set_id(ObjectId.get());
        repository.save(users);
        return users;
    }

    @DeleteMapping
    public void deleteUser(@Valid @RequestBody Users users) {
        repository.delete(repository.findBy_id(users._id));
    }
}