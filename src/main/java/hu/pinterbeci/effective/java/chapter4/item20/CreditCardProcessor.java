package hu.pinterbeci.effective.java.chapter4.item20;

public class CreditCardProcessor extends BasePaymentProcessor {
    @Override
    protected void doProcessPayment(double amount) {
        // only Visa/Mastercard specific logic here
    }

    @Override
    protected void doRefund(double amount) {
        // only Visa/Mastercard specific logic here
    }
}