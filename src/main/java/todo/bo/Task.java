package todo.bo;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "DONE")
    private boolean done;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<Category> categories;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Task() {
    }

    public Task(String name, String description, Date date, boolean done, User user, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
        this.categories = new HashSet<>();
        this.categories = categories;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", done=" + done +
                ", categories=" + categoryIds(categories) +
                ", user=" + String.valueOf(user.getId()) +
                '}';
    }

    public String categoryIds(Set<Category> categories) {
        String res = "[";
        for (Category category : categories) {
            res+=String.valueOf(category.getId())+", ";
        }
        return res + "]";
    }
}
