package by.salon.entity;

import javax.persistence.*;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long providerId;
    @Column
    private String name;
    @Column
    private String address;

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider provider = (Provider) o;

        if (providerId != provider.providerId) return false;
        if (name != null ? !name.equals(provider.name) : provider.name != null) return false;
        return address != null ? address.equals(provider.address) : provider.address == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (providerId ^ (providerId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
