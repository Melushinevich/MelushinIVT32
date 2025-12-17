package org.douggschwind.games.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Doug Gschwind
 */
public class DeckOfCardsTest {

    @Test
    public void testDeckOfCardsLifecycle() {
        DeckOfCards<FrenchSuitedPlayingCard> underTest = new DeckOfCards<>();

        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));

        assertEquals(5, underTest.size());

        underTest.shuffle();
        assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card1 = underTest.dealCard();
        assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card1.getSuit());
        assertTrue(underTest.hasCardBeenDealt(card1));
        assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card2 = underTest.dealCard();
        assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card2.getSuit());
        assertTrue(underTest.hasCardBeenDealt(card2));
        assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card3 = underTest.dealCard();
        assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card3.getSuit());
        assertTrue(underTest.hasCardBeenDealt(card3));
        assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card4 = underTest.dealCard();
        assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card4.getSuit());
        assertTrue(underTest.hasCardBeenDealt(card4));
        assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card5 = underTest.dealCard();
        assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card5.getSuit());
        assertTrue(underTest.hasCardBeenDealt(card5));
        assertTrue(underTest.haveAllCardsBeenDealt());

        try {
            underTest.dealCard();
            fail("All cards should have been dealt at this point");
        } catch (IllegalStateException e) {
        }

        underTest.shuffle();
        assertFalse(underTest.haveAllCardsBeenDealt());
        assertEquals(5, underTest.size());
    }
}
