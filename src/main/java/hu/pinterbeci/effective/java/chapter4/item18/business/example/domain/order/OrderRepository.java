package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order;

public interface OrderRepository {
    Order save(Order order);

    void deleteById(Long orderId);
}
