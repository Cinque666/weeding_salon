package by.salon.entity;

import javax.persistence.*;

@Entity
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long sizeId;
    @Column
    private String name;

    public long getSizeId() {
        return sizeId;
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

        Size size = (Size) o;

        if (sizeId != size.sizeId) return false;
        return name != null ? name.equals(size.name) : size.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (sizeId ^ (sizeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
