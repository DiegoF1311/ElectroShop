package co.edu.unbosque.electroshop_api.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.CardDTO;

@Service
public class PaymentService {
	
	public boolean processPayment(float price, CardDTO card) {
		Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(card.getCardNumber());
        
        if (matcher.find()) {
            return false;
        } else {
            try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return true;
        }
	}
	
}
