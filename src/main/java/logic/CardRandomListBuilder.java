package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by xlo on 16-1-15.
 * it's the card random list builder
 */
public class CardRandomListBuilder {

    private Random random;

    public CardRandomListBuilder(Random random) {
        this.random = random;
    }

    public List<Card> buildCardRandomList(Card[] cards) {
        List<CardNode> cardNodes = new ArrayList<>();
        for (Card now : cards) {
            cardNodes.add(new CardNode(now, random.nextInt()));
        }
        cardNodes.sort((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));
        return cardNodes.stream().map(CardNode::getCard).collect(Collectors.toList());
    }

    private class CardNode {
        private Card card;
        private int value;

        public CardNode(Card card, int value) {
            this.card = card;
            this.value = value;
        }

        public Card getCard() {
            return card;
        }

        public int getValue() {
            return value;
        }
    }

}
