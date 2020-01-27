package by.salon.entity;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long colorId;
    @Column
    private String name;

    public long getColorId() {
        return colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (colorId != color.colorId) return false;
        return name != null ? name.equals(color.name) : color.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (colorId ^ (colorId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
