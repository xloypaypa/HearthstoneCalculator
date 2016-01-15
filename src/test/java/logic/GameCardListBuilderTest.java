package logic;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xlo on 16-1-15.
 * it's the testing code for game card list builder
 */
public class GameCardListBuilderTest {

    @Test
    public void should_get_4_card_with_one_unusable_and_2_unusable_1_3_cost_cards_when_random_give_3_1_4_2_and_cardCosts_give_0_1_1_1_and_1_other() {
        Random random = mock(Random.class);
        when(random.nextInt()).thenReturn(3, 1, 4, 2);
        GameCardListBuilder gameCardListBuilder =
                new GameCardListBuilder(new CardRandomListBuilder(random),
                        new CardListBuilder(new int[]{0, 1, 1, 1}, 1));
        List<Card> cards = gameCardListBuilder.buildCardList();
        assertEquals(4, cards.size());
        assertEquals(2, cards.get(0).getCost());
        assertEquals(-1, cards.get(1).getCost());
        assertEquals(1, cards.get(2).getCost());
        assertEquals(3, cards.get(3).getCost());
    }

}