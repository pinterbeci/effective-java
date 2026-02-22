package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order;

//represents a domain service
public class OrderService {

    //represents a domain repository
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        // complex business logic
        return orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        // complex business logic
        orderRepository.deleteById(orderId);
    }
}