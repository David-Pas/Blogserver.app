package blogserver.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Posts {
    @Id
    public ObjectId _id;
    public ObjectId author_id;
    public String author;
    public String post;

    // Constructors
    public Posts() {}

    public Posts(ObjectId _id, ObjectId author_id, String author, String post) {
        this._id = _id;
        this.author_id = author_id;
        this.author = author;
        this.post = post;
    }

    // Getters and Setters for each Posts's field (most of them are unused for now)
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getAuthor_id() { return author_id.toHexString(); }
    public void setAuthor_id(ObjectId author_id) { this.author_id = author_id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPost() { return post; }
    public void setPost(String post) { this.post = post; }
}