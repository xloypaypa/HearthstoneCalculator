package user;

import card.Card;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xlo on 16-1-15.
 * it's the card in user hand
 */
public class CardInHand {

    private Set<Card> cards;

    public CardInHand() {
        this.cards = new HashSet<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public boolean haveCardWithCost(int cost) {
        for (Card now : cards) {
            if (now.getCost() == cost) {
                return true;
            }
        }
        return false;
    }

    public Card getOneCardWithCost(int cost) {
        for (Card now : cards) {
            if (now.getCost() == cost) {
                return now;
            }
        }
        return null;
    }

}
