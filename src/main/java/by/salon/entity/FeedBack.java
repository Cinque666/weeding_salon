package by.salon.entity;

import javax.persistence.*;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long colorId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String description;

    public long getColorId() {
        return colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
