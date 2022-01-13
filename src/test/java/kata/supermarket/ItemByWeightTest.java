package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ItemByWeightTest {

    @Test
    void testDiscountBuyOneKiloHalfPrice() {
        final Item item = new ItemByWeight(new WeighedProduct(new BigDecimal("5")), new BigDecimal(2),
                new DiscountBuyOneKiloHalfPrice());

        assertThat(item.discount()).isEqualTo(new BigDecimal(5).setScale(2));
    }

}