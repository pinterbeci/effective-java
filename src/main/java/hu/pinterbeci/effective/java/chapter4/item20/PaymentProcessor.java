package hu.pinterbeci.effective.java.chapter4.item20;

/*
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Use an interface when you want to say: "These classes must be able to do this, but I don't care how."
Use an abstract class when you want to say: "These classes share common logic that I don't want to duplicate everywhere."
 */
public interface PaymentProcessor {
    void processPayment(double amount);

    void refund(double amount);
}