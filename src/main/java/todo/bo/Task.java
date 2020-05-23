package todo.bo;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "done")
    private boolean done;

    @ManyToMany
    @JoinTable(
            name = "TaskCategory",
            joinColumns = {@JoinColumn(name = "taskId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId", referencedColumnName = "id")}
            )
    private List<Category> categories;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Task() {
    }

    public Task(String name, String description, Date date, boolean done, User user, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.done = done;
        this.categories = new ArrayList<>();
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
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

    public String categoryIds(List<Category> categories) {
        String res = "[";
        for (Category category : categories) {
            res+=String.valueOf(category.getId())+", ";
        }
        return res + "]";
    }
}
