package checkout;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ShoppingCartWithOffersTest {

	private ShoppingCart shoppingCart = new ShoppingCart(new Offers());
	
	@Test
	public void shoppingCartScanned_whenshoppingCartHasOneOrangesAndOrangeOffer_ThenNoDiscount() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".25").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenshoppingCartHasTwoOrangesAndOrangeOffer_ThenNoDiscount() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".50").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenshoppingCartHasThreeOrangesAndOrangeOffer_ThentotalIsForTwoOranges() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".50").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenshoppingCartHasFourteenOrangesAndOrangeOffer_ThentotalIsForTenOranges() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange", "Orange", 
													"Orange", "Orange",	"Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("2.50").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenshoppingCartHasFifteenOrangesAndOrangeOffer_ThentotalIsForTenOranges() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("2.50").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenshoppingCartHasSixteenOrangesAndOrangeOffer_ThentotalIsForElevenOranges() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", 
													"Orange", "Orange", "Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("2.75").toString(), amount.toString());
	}

	public void shoppingCartScanned_whenshoppingCartHasOneAppleAndAppleOffer_ThenNoDiscount() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".60").toString(), amount.toString());
	}

	public void shoppingCartScanned_whenshoppingCartHasTwoApplesAndAppleOffer_ThentotalIsForOneApple() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.20").toString(), amount.toString());
	}

	public void shoppingCartScanned_whenshoppingCartHasThreeApplesAndAppleOffer_ThenOneAppleIsFree() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Apple", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.20").toString(), amount.toString());
	}


	@Test
	public void shoppingCartScanned_whenVariedBasketOfFruitWithOffers_ThenOffersWillBeApplied() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Orange", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".85").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenVariedBasketOfFruitWithOffers_ThenTotalWillBeOne70() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Orange", "Apple", "Apple", "Orange", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.70").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenVariedBasketOfFruitWithOffers_ThenTotalWillBeOne70WithDiscount() {
		
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Orange", "Apple", "Apple", "Orange", "Apple", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.70").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenUnknownFruitWithOffers_ThenOnlyApplesAndOrangesWillBeSummed() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Pear", "Apple", "Orange", "Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.10").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenEmpty_TotalWillBeZero() {
		BigDecimal amount = shoppingCart.scan(new String[] {});
		assertEquals("incorrect shopping cart amount", new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNull_ThenTotalWillBeZero() {
		BigDecimal amount = shoppingCart.scan(null);
		assertEquals("incorrect shopping cart amount", new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNullFruit_ThenTotalWillBeForNonNullFruit() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", null, "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".60").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNullFruitAndNullOffer_ThenTotalWillBeForNonNullFruitNoDiscount() {
		BigDecimal amount = new ShoppingCart(null).scan(new String[] {"Apple", null, "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.20").toString(), amount.toString());
	}
}
