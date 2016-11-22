package checkout;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class ShoppingCartTest {

	@Test
	public void shoppingCartScanned_whenVariedBasketOfFruit_ThenTotalWillBeCorrect() {
		ShoppingCart cart = new ShoppingCart();
		BigDecimal amount = cart.scan(new String[] {"Apple", "Orange", "Apple"});
		assertEquals(new BigDecimal("1.45").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenUnknownFruit_ThenOnlyApplesAndOrangesWillBeSummed() {
		ShoppingCart cart = new ShoppingCart();
		BigDecimal amount = cart.scan(new String[] {"Apple", "Pear", "Apple", "Orange"});
		assertEquals(new BigDecimal("1.45").toString(), amount.toString());
	}

	@Test
	public void shoppingCartScanned_whenEmpty_TotalWillBeZero() {
		ShoppingCart cart = new ShoppingCart();
		BigDecimal amount = cart.scan(new String[] {});
		assertEquals(new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenAllApples_ThenTotalWillBeCorrect() {
		ShoppingCart cart = new ShoppingCart();
		BigDecimal amount = cart.scan(new String[] {"Apple", "Apple", "Apple"});
		assertEquals(new BigDecimal("1.80").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenAllOranges_ThenTotalWillBeCorrect() {
		ShoppingCart cart = new ShoppingCart();
		BigDecimal amount = cart.scan(new String[] {"Orange", "Orange", "Orange"});
		assertEquals(new BigDecimal(".75").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNull_ThenTotalWillBeZero() {
		BigDecimal amount = new ShoppingCart().scan(null);
		assertEquals(new BigDecimal("0.00").toString(), amount.toString());
	}
	
	@Test
	public void shoppingCartScanned_whenNullFruit_ThenTotalWillBeForNonNullFruit() {
		BigDecimal amount = new ShoppingCart().scan(new String[] {"Apple", null, "Apple"});
		assertEquals(new BigDecimal("1.20").toString(), amount.toString());
	}
}
