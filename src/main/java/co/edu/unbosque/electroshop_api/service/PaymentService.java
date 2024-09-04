package co.edu.unbosque.electroshop_api.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.CardDTO;


/**
 * Service class for handling payment processing.
 * <p>
 * This service class provides functionality to process payments by validating card details
 * and checking if the total payment amount (including IVA) is valid.
 * </p>
 */
@Service
public class PaymentService {

    /**
     * IVA rate to be applied to the payment amount.
     * <p>
     * This rate is set to 0.19 (19%).
     * </p>
     */
    private final double IVA = 0.19;

    /**
     * Processes a payment by validating the card details and checking the total payment amount.
     * <p>
     * This method uses a regular expression to check if the card number contains any alphabetic characters.
     * If the card number is invalid (contains letters) or the total payment amount (including IVA) is zero,
     * the payment is considered invalid. Otherwise, the method simulates a delay and returns true to indicate
     * that the payment is processed successfully.
     * </p>
     * 
     * @param price the amount to be charged for the payment
     * @param card the {@link CardDTO} containing the card details
     * @return true if the payment is processed successfully; false otherwise
     */
    public boolean processPayment(float price, CardDTO card) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(card.getCardNumber());
        
        if (matcher.find() && (price + (price * IVA)) != 0) {
            return false;
        } else {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Handle interruption during sleep
                e.printStackTrace();
            }
            return true;
        }
    }
	
}
