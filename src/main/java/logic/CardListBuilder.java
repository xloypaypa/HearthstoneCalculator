package logic;

import java.security.InvalidParameterException;

/**
 * Created by xlo on 16-1-15.
 * it's the card list builder
 */
public class CardListBuilder {

    public Card[] buildCardList(int[] cardCosts, int other) {
        checkParamValid(cardCosts, other);
        Card[] cards = buildCardsArray(cardCosts, other);
        int pos = 0;
        pos = buildNormalCard(cardCosts, cards, pos);
        buildOtherCard(other, cards, pos);
        return cards;
    }

    private int buildOtherCard(int other, Card[] cards, int pos) {
        while (other > 0) {
            cards[pos++] = new Card(-1);
            other--;
        }
        return pos;
    }

    private int buildNormalCard(int[] cardCosts, Card[] cards, int pos) {
        for (int cost = 0; cost < cardCosts.length; cost++) {
            for (int i = 0; i < cardCosts[cost]; i++) {
                cards[pos++] = new Card(cost);
            }
        }
        return pos;
    }

    private Card[] buildCardsArray(int[] cardCosts, int other) {
        int sum = other;
        for (int now : cardCosts) {
            sum += now;
        }
        return new Card[sum];
    }

    private void checkParamValid(int[] cardCosts, int other) {
        if (other < 0) {
            throw new InvalidParameterException();
        }
        for (int now : cardCosts) {
            if (now < 0) {
                throw new InvalidParameterException();
            }
        }
    }

}
