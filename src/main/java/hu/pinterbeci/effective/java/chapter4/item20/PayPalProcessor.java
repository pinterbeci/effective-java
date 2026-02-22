package hu.pinterbeci.effective.java.chapter4.item20;

public class PayPalProcessor extends BasePaymentProcessor {
    @Override
    protected void doProcessPayment(double amount) {
        // only PayPal specific logic here
    }

    @Override
    protected void doRefund(double amount) {
        // only PayPal specific logic here
    }
}