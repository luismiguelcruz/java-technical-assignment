package kata.supermarket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemByUnitTest {

    @Test
    void testInvalidItemsThrowException() {
        final Exception exception = assertThrows(RuntimeException.class, () -> {
            new ItemByUnit(new Product(new BigDecimal("5")), new BigDecimal(5.3), new DiscountBuyTwoGetOneFree());
        });

        assertThat(exception.getMessage()).isEqualTo("Invalid amount for an item by unit");
    }

    static Stream<Arguments> testDiscountBuyTwoGetOneFree() {
        return Stream.of(
                Arguments.of(new ItemByUnit(new Product(new BigDecimal("5")), new BigDecimal(3),
                        new DiscountBuyTwoGetOneFree()), 5),
                Arguments.of(new ItemByUnit(new Product(new BigDecimal("5")), new BigDecimal(5),
                        new DiscountBuyTwoGetOneFree()), 10)
        );
    }

    @MethodSource
    @ParameterizedTest
    void testDiscountBuyTwoGetOneFree(final Item item, final int value) {
        assertThat(item.discount()).isEqualTo(new BigDecimal(value));
    }

    @Test
    void testDiscountBuyTwoItemsForOnePound() {
        final Item item = new ItemByUnit(new Product(new BigDecimal("5")), new BigDecimal(3),
                new DiscountTwoItemsForOnePound());

        assertThat(item.discount()).isEqualTo(new BigDecimal(9));
    }

}