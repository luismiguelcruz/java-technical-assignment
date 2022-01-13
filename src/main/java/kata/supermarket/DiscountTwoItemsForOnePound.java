package kata.supermarket;

import java.math.BigDecimal;

public class DiscountTwoItemsForOnePound implements Discount {
    @Override
    public BigDecimal calculateDiscount(Item item) {
        final int amount = item.amount().intValue();

        if (amount % 2 == 0) {
            return BigDecimal.ZERO;
        }

        // Discount = (itemprice * 2 * (amount % 2)) - 1
        return item.price().multiply(BigDecimal.valueOf(amount % 2).multiply(BigDecimal.valueOf(2)))
                .subtract(new BigDecimal(1));
    }
}
