package checkout;

public class Offers {
	public static final Offer TWO_FOR_ONE = (numberOfFruit) -> (numberOfFruit / 2) + (numberOfFruit % 2);
	public static final Offer THREE_FOR_TWO = (numberOfFruit) -> (numberOfFruit / 3 * 2 ) + (numberOfFruit % 3);

	@FunctionalInterface
	interface Offer {
		long apply(long numberOfFruit);
	}
	
	public long applyOffer(long numberOfFruit, Offer offer){
		return offer.apply(numberOfFruit);
	}

}
