package checkout;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCart {

	public BigDecimal scan(String[] fruits) {
		if (fruits == null || fruits.length == 0){
			return new BigDecimal("0.00");
		}
		
		long appleCount = Arrays.asList(fruits).stream()	 			
				.filter(fruit -> "Apple". equals (fruit))	
				.count();
		BigDecimal applePrice = new BigDecimal(".60").multiply(new BigDecimal(appleCount));
		
		long orangeCount = Arrays.asList(fruits).stream()	 			
				.filter(fruit -> "Orange". equals (fruit))
				.count();
		BigDecimal orangePrice = new BigDecimal(".25").multiply(new BigDecimal(orangeCount));
			
		return orangePrice.add(applePrice);
	}

	
}
