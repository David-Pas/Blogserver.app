package blogserver.RestController;

import blogserver.repositories.PostsRepository;
import org.springframework.web.bind.annotation.*;
import blogserver.models.Posts;
import blogserver.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsRepository repository;

    @Autowired
    private UsersRepository usrepository;


    // Functionality to view blog posts
    @GetMapping
    public List<Posts> getPost(@Valid @RequestBody Posts posts, @RequestParam("type")String reqType) {
        if (reqType.equals("show_all")) {
            return repository.findAll();
        }
        if (reqType.equals("post_by_id")) {
            return Arrays.asList(repository.findBy_id(posts._id));
        }
        if (reqType.equals("show_by_author")) {
            return repository.findByAuthor(posts.author);
        }
        else {
            return null;
        }
    }

    // Functionality to edit blog posts for each user separately
    @PutMapping
    public String modifyPost(@Valid @RequestBody Posts posts) {
        if (posts.author_id.equals(repository.findBy_id(posts._id).author_id)) {
            posts.author = usrepository.findBy_id(posts.author_id).name;
            repository.save(posts);
            return "Selected post has been successfully updated";
        }
        else {
            return "Access denied!";
        }
    }

    // Functionality to create blog posts
    @PostMapping
    public String createPost(@Valid @RequestBody Posts posts) {
        if ((usrepository.findBy_id(posts.author_id)!= null &&
                posts.author_id.equals(usrepository.findBy_id(posts.author_id)._id))) {
            posts.set_id(ObjectId.get());
            posts.author = usrepository.findBy_id(posts.author_id).name;
            repository.save(posts);
            return "Your message has been successfully posted";
        }
        else {
            return "Access denied!";
        }
    }

    // Functionality to delete blog posts for each user separately
    @DeleteMapping
    public String deletePost(@Valid @RequestBody Posts posts) {
        if (posts.author.equals(repository.findBy_id(posts._id).author)) {
            repository.delete(repository.findBy_id(posts._id));
            return "Selected post has been deleted!";
        }
        else {
            return "Access denied!";
        }
    }
}