package checkout;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCart {

	private Offers offers;

	public ShoppingCart(){}

	public ShoppingCart(Offers offers){
		this.offers = offers;
	}

	public BigDecimal scan(String[] fruits) {
		if (fruits == null || fruits.length == 0){
			return new BigDecimal("0.00");
		}
		
		long appleCount = filterBy(fruits, "Apple");
		long orangeCount = filterBy(fruits, "Orange");
		
		if (offers != null) {
			appleCount = offers.applyOffer(appleCount, Offers.TWO_FOR_ONE);
			orangeCount = offers.applyOffer(orangeCount, Offers.THREE_FOR_TWO);
		}
		
		return totalPrice(appleCount, orangeCount);
	}

	private BigDecimal totalPrice(long appleCount, long orangeCount) {
		return calculatePrice(".25", orangeCount).add(calculatePrice(".60", appleCount));
	}

	private BigDecimal calculatePrice(String price, long count) {
		return new BigDecimal(price).multiply(new BigDecimal(count));
	}

	private long filterBy(String[] fruits, String fruitToFilterBy){
		return Arrays.asList(fruits).stream()	 			
				.filter(fruit -> fruitToFilterBy.equals(fruit))
				.count();
	}
}
