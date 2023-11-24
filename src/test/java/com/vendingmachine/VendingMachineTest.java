package com.vendingmachine;

import com.vendingmachine.VendingMachine.InsufficientFunds;
import com.vendingmachine.VendingMachine.ItemNotFound;
import com.vendingmachine.VendingMachine.NotEnoughChange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.vendingmachine.Coin.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendingMachineTest {
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = VendingMachine.builder()
                .withItem(1, new Item("Chips", 4))
                .withItem(2, new Item("Coca Cola", 12))
                .withItem(3, new Item("Chocolate Bar", 15))
                .build();
    }

    @Test
    void buyingWithoutFundsShouldFail() {
        assertThrows(InsufficientFunds.class, () -> machine.buy(1));
    }

    @Test
    void buyingWithoutChangeShouldFail() {
        machine.insert(Money.from(FIVE_CENTS));

        assertThrows(NotEnoughChange.class, () -> machine.buy(1));
    }

    @Test
    void forceBuyingWithoutChangeShouldSucceed() {
        machine.insert(Money.from(FIVE_CENTS));

        assertEquals(Money.empty(), machine.forceBuy(1));
    }

    @Test
    void buyingANonExistingItemShouldFail() {
        assertThrows(ItemNotFound.class, () -> machine.buy(10));
    }

    @ParameterizedTest
    @MethodSource("changeSourceProvider")
    void buyingAnItemShouldReturnChange(Money money, int itemCode, Money expectedChange) {
        machine = VendingMachine.builder()
                .withMoney(Money.empty()
                    .add(ONE_CENT, 100)
                    .add(TWO_CENTS, 100)
                    .add(FIVE_CENTS, 100))
                .withItem(1, new Item("Chips", 4))
                .withItem(2, new Item("Coca Cola", 12))
                .withItem(3, new Item("Chocolate Bar", 15))
                .build();

        machine.insert(money);

        assertEquals(expectedChange, machine.buy(itemCode));
    }

    private static Stream<Arguments> changeSourceProvider() {
        return Stream.of(
                Arguments.of(
                        Money.from(FIVE_CENTS, FIVE_CENTS, FIVE_CENTS),
                        2,
                        Money.from(ONE_CENT, TWO_CENTS)
                ),
                Arguments.of(
                        Money.from(FIVE_CENTS, FIVE_CENTS, FIVE_CENTS),
                        3,
                        Money.empty()
                ),
                Arguments.of(
                        Money.from(FIVE_CENTS, FIVE_CENTS, FIVE_CENTS, TWO_CENTS),
                        2,
                        Money.from(FIVE_CENTS)
                ),
                Arguments.of(
                        Money.from(TEN_CENTS, FIVE_CENTS, FIVE_CENTS, FIVE_CENTS),
                        3,
                        Money.from(TEN_CENTS)
                )
        );
    }

    @Test
    void cancelShouldReturnInsertedMoney() {
        machine.insert(Money.from(TWO_CENTS, TWO_CENTS, ONE_CENT));

        assertEquals(Money.from(TWO_CENTS, TWO_CENTS, ONE_CENT), machine.cancel());
    }
}
