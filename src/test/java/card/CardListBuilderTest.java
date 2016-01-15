package card;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xlo on 16-1-15.
 * it's the testing code for card list builder
 */
public class CardListBuilderTest {

    @Test
    public void should_build_3_cards_with_1_2_3_cost_when_give_0_1_1_1_in_cardCosts() {
        CardListBuilder cardListBuilder = new CardListBuilder(new int[]{0, 1, 1, 1}, 0);
        Card[] cards = cardListBuilder.buildCardList();
        Set<Integer> costSet = new HashSet<>();
        for (Card now : cards) {
            costSet.add(now.getCost());
        }
        assertEquals(3, cards.length);
        assertTrue(costSet.contains(1));
        assertTrue(costSet.contains(2));
        assertTrue(costSet.contains(3));
    }

    @Test
    public void should_build_1_unusable_cards_when_give_1_other() {
        CardListBuilder cardListBuilder = new CardListBuilder(new int[]{0, 1, 1, 1}, 1);
        Card[] cards = cardListBuilder.buildCardList();
        Set<Integer> costSet = new HashSet<>();
        for (Card now : cards) {
            costSet.add(now.getCost());
        }
        assertTrue(costSet.contains(-1));
    }

    @Test(expected = InvalidParameterException.class)
    public void should_get_InvalidParameterException_when_give_negative_number_in_cardCosts() {
        CardListBuilder cardListBuilder = new CardListBuilder(new int[]{0, 1, 1, -1}, 0);
        cardListBuilder.buildCardList();
    }

    @Test(expected = InvalidParameterException.class)
    public void should_get_InvalidParameterException_when_give_negative_number_in_other() {
        CardListBuilder cardListBuilder = new CardListBuilder(new int[]{0, 1, 1, 1}, -1);
        cardListBuilder.buildCardList();
    }

}