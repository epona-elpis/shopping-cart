package checkout;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class ShoppingCartTest {

	private ShoppingCart shoppingCart = new ShoppingCart();

	@Test
	public void shoppingCartScanned_whenVariedBasketOfFruit_ThenTotalWillBeCorrect() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Orange", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.45").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenUnknownFruit_ThenOnlyApplesAndOrangesWillBeSummed() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Pear", "Apple", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.45").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenEmpty_TotalWillBeZero() {
		BigDecimal amount = shoppingCart.scan(new String[] {});
		assertEquals("incorrect shopping cart amount", new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenAllApples_ThenTotalWillBeCorrect() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", "Apple", "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.80").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenAllOranges_ThenTotalWillBeCorrect() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Orange", "Orange", "Orange"});
		assertEquals("incorrect shopping cart amount", new BigDecimal(".75").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNull_ThenTotalWillBeZero() {
		BigDecimal amount = shoppingCart.scan(null);
		assertEquals("incorrect shopping cart amount", new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNullFruit_ThenTotalWillBeForNonNullFruit() {
		BigDecimal amount = shoppingCart.scan(new String[] {"Apple", null, "Apple"});
		assertEquals("incorrect shopping cart amount", new BigDecimal("1.20").toString(), amount.toString());
	}
}
