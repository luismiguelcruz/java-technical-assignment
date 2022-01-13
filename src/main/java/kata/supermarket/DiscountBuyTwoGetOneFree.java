package kata.supermarket;

import java.math.BigDecimal;

public class DiscountBuyTwoGetOneFree implements Discount {
    @Override
    public BigDecimal calculateDiscount(Item item) {
        // Check if we are treating int numbers
        if (item.amount().stripTrailingZeros().scale() > 0) {
            throw new RuntimeException("Invalid amount for an item by unit");
        }

        final int amount = item.amount().intValue();

        if (amount % 2 == 0) {
            return BigDecimal.ZERO;
        }

        // free items =
        final int freeItems = amount / 2;
        return item.price().multiply(new BigDecimal(freeItems));
    }
}
