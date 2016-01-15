package logic;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by xlo on 16-1-15.
 * it's the testing code for card list builder
 */
public class CardRandomListBuilderTest {

    @Test
    public void should_get_3_2_1_card_cost_when_random_give_3_2_1() {
        Random random = mock(Random.class);
        when(random.nextInt()).thenReturn(3, 2, 1);
        CardRandomListBuilder cardRandomListBuilder = new CardRandomListBuilder(random);

        Card[] cards = new Card[3];
        cards[0] = new Card(1);
        cards[1] = new Card(2);
        cards[2] = new Card(3);

        List<Card> result = cardRandomListBuilder.buildCardRandomList(cards);
        assertEquals(3, result.get(0).getCost());
        assertEquals(2, result.get(1).getCost());
        assertEquals(1, result.get(2).getCost());
    }

    @Test
    public void should_get_1_3_2_card_cost_when_random_give_1_3_2() {
        Random random = mock(Random.class);
        when(random.nextInt()).thenReturn(1, 3, 2);
        CardRandomListBuilder cardRandomListBuilder = new CardRandomListBuilder(random);

        Card[] cards = new Card[3];
        cards[0] = new Card(1);
        cards[1] = new Card(2);
        cards[2] = new Card(3);

        List<Card> result = cardRandomListBuilder.buildCardRandomList(cards);
        assertEquals(1, result.get(0).getCost());
        assertEquals(3, result.get(1).getCost());
        assertEquals(2, result.get(2).getCost());
    }

}