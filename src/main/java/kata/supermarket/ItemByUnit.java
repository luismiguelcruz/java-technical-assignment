package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemByUnit implements Item {

    private final Product product;
    private final BigDecimal amount;
    private Discount discountStrategy;

    ItemByUnit(final Product product) {
        this(product, BigDecimal.ONE);
    }

    public ItemByUnit(final Product product, final BigDecimal amount) {
        this.product = product;
        this.amount = amount;
    }

    public ItemByUnit(Product product, BigDecimal amount, Discount discount) {
        checkValidAmount(amount);
        this.product = product;
        this.amount = amount;
        this.discountStrategy = discount;
    }

    private void checkValidAmount(final BigDecimal amount) {
        if (amount.stripTrailingZeros().scale() > 0) {
            throw new RuntimeException("Invalid amount for an item by unit");
        }
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    public BigDecimal priceByUnit() {
        return price();
    }

    @Override
    public BigDecimal amount() {
        return amount;
    }

    @Override
    public BigDecimal discount() {
        if (Objects.isNull(discountStrategy)){
            return BigDecimal.ZERO;
        }

        return discountStrategy.calculateDiscount(this);
    }
}
