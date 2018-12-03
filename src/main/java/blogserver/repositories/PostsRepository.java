package blogserver.repositories;

import blogserver.models.Posts;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostsRepository extends MongoRepository<Posts, String> {
    Posts findBy_id(ObjectId _id);
    List<Posts> findByAuthor(String author);
}