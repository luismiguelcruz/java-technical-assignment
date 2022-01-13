package kata.supermarket;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal calculateDiscount(Item item);
}
