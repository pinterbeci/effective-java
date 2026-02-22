package hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.notification;

import hu.pinterbeci.effective.java.chapter4.item18.business.example.domain.order.Order;

public class SmsService {
    public void sendOrderSms(Order placed) {
        //business logic here
    }

    public void sendCancellationSms(Long orderId) {
        //business logic here
    }
}
