package payLoads;

import java.util.List;

public class CreateOrderBody {
    private List<OrderDetailsPojo> orders;

    public List<OrderDetailsPojo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetailsPojo> orders) {
        this.orders = orders;
    }
}
