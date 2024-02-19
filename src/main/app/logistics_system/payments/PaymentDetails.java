package logistics_system.payments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDetails {
    private PaymentMode paymentMode;
    private String transactionId;
    private int amount;
    private PaymentStatus paymentStatus;
    private String cardNumber;
}
