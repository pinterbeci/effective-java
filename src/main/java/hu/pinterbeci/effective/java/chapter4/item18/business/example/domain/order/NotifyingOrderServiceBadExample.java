package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order;

import hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.notification.EmailService;

/*
OrderService
    └── NotifyingOrderService
            └── SmsOrderService
                    └── KafkaOrderService

                    and so on and so on
 */
public class NotifyingOrderServiceBadExample extends OrderService {

    private final EmailService emailService;

    public NotifyingOrderServiceBadExample(OrderRepository orderRepository, EmailService emailService) {
        super(orderRepository);
        this.emailService = emailService;
    }

    @Override
    public Order placeOrder(Order order) {
        Order placed = super.placeOrder(order);
        emailService.sendOrderConfirmation(placed); // send email
        return placed;
    }

    @Override
    public void cancelOrder(Long orderId) {
        super.cancelOrder(orderId);
        emailService.sendCancellationEmail(orderId); // send email
    }
}
