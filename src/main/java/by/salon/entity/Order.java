package by.salon.entity;

import javax.persistence.*;

@Entity
@Table(name = "weeding_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long orderId;
    @Column
    private Integer productId;
    @Column
    private Integer masterId;
    @Column
    private Integer clientId;
    @Column
    private Integer quantity;

    public long getOrderId() {
        return orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (productId != null ? !productId.equals(order.productId) : order.productId != null) return false;
        if (masterId != null ? !masterId.equals(order.masterId) : order.masterId != null) return false;
        if (clientId != null ? !clientId.equals(order.clientId) : order.clientId != null) return false;
        return quantity != null ? quantity.equals(order.quantity) : order.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (masterId != null ? masterId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
