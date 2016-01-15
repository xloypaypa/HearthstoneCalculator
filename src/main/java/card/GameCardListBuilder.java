package card;

import java.util.List;

/**
 * Created by xlo on 16-1-15.
 * it's the game card list builder
 */
public class GameCardListBuilder {

    private CardRandomListBuilder cardRandomListBuilder;
    private CardListBuilder cardListBuilder;

    public GameCardListBuilder(CardRandomListBuilder cardRandomListBuilder, CardListBuilder cardListBuilder) {
        this.cardRandomListBuilder = cardRandomListBuilder;
        this.cardListBuilder = cardListBuilder;
    }

    public List<Card> buildCardList() {
        return cardRandomListBuilder.buildCardRandomList(cardListBuilder.buildCardList());
    }
}
