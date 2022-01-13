package kata.supermarket;

import java.math.BigDecimal;

public interface Item {
    BigDecimal price();
    BigDecimal priceByUnit();
    BigDecimal discount();
    BigDecimal amount();
}
