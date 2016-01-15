package logic;

import java.security.InvalidParameterException;

/**
 * Created by xlo on 16-1-15.
 * it's the card list builder
 */
public class CardListBuilder {

    public Card[] buildCardList(int[] cardCosts, int other) {
        if (other < 0) {
            throw new InvalidParameterException();
        }
        for (int now : cardCosts) {
            if (now < 0) {
                throw new InvalidParameterException();
            }
        }
        int sum = other;
        for (int now : cardCosts) {
            sum += now;
        }
        Card[] cards = new Card[sum];
        int pos = 0;
        for (int cost = 0; cost < cardCosts.length; cost++) {
            for (int i = 0; i < cardCosts[cost]; i++) {
                cards[pos++] = new Card(cost);
            }
        }
        while (other > 0) {
            cards[pos++] = new Card(-1);
            other--;
        }
        return cards;
    }

}
