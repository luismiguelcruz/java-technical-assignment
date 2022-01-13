package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private Discount discountStrategy;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this(product, weightInKilos, null);
    }

    public ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos, final Discount discountStrategy) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal priceByUnit() {
        return product.pricePerKilo();
    }

    @Override
    public BigDecimal discount() {
        if (Objects.isNull(discountStrategy)){
            return BigDecimal.ZERO;
        }

        return discountStrategy.calculateDiscount(this).setScale(2);
    }

    @Override
    public BigDecimal amount() {
        return weightInKilos;
    }
}
