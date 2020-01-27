package by.salon.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long productId;
    @Column
    private Integer productTypeId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Integer colorId;
    @Column
    private Integer providerId;
    @Column
    private Double cost;
    @Column
    @Lob
    private byte[] image;

    public long getProductId() {
        return productId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
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

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (productTypeId != null ? !productTypeId.equals(product.productTypeId) : product.productTypeId != null)
            return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (colorId != null ? !colorId.equals(product.colorId) : product.colorId != null) return false;
        if (providerId != null ? !providerId.equals(product.providerId) : product.providerId != null) return false;
        if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
        return Arrays.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        int result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
