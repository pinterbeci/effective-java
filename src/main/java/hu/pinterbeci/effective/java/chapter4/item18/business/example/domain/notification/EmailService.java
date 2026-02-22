package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.notification;

import hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order.Order;

public class EmailService {
    public void sendOrderConfirmation(Order placed) {
        //domain logic here
    }

    public void sendCancellationEmail(Long orderId) {
        //domain logic
    }
}
