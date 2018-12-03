package blogserver.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
    @Id
    public ObjectId _id;
    public String name;
    public String password;

    // Constructors
    public Users() {}

    public Users(ObjectId _id, String name, String password) {
        this._id = _id;
        this.name = name;
        this.password = password;
    }

    // Getters and Setters for each Posts's field. Most of them are unused for now.
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}