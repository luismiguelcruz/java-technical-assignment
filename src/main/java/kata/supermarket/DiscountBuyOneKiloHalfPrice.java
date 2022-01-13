package kata.supermarket;

import java.math.BigDecimal;

public class DiscountBuyOneKiloHalfPrice implements Discount {
    @Override
    public BigDecimal calculateDiscount(Item item) {
        final int completeKilos = item.amount().intValue();

        return item.priceByUnit().divide(new BigDecimal(2)).multiply(new BigDecimal(completeKilos)).setScale(2);
    }
}
