package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order;

import hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.notification.EmailService;
import hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.notification.SmsService;

public class NotifyingOrderService {

    private final OrderService orderService; // wrapped, not extended
    private final EmailService emailService;
    private final SmsService smsService;

    public NotifyingOrderService(OrderService orderService,
                                 EmailService emailService,
                                 SmsService smsService) {
        this.orderService = orderService;
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public Order placeOrder(Order order) {
        Order placed = orderService.placeOrder(order); // delegate
        emailService.sendOrderConfirmation(placed);    // add behavior
        smsService.sendOrderSms(placed);               // add behavior
        return placed;
    }

    public void cancelOrder(Long orderId) {
        orderService.cancelOrder(orderId);             // delegate
        emailService.sendCancellationEmail(orderId);   // add behavior
        smsService.sendCancellationSms(orderId);       // add behavior
    }
}
