package org.douggschwind.games.cardgames.common;

import org.douggschwind.games.common.DeckOfCards;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Doug Gschwind
 */
public class PlayerTest {
    @Test
    public void testPlayerEquals() {
        Player player1 = new Player();

        assertEquals(player1, player1);
        assertEquals(player1.hashCode(), player1.hashCode());
    }

    @Test
    public void testPlayerNotEquals() {
        Player player1 = new Player();
        Player player2 = new Player();

        assertNotEquals(player1, player2);
        assertNotEquals(player2, player1);
    }

    @Test
    public void testNewHand() {
        DeckOfCards<FrenchSuitedPlayingCard> standardDeck = DeckFactory.createStandardDeck();
        standardDeck.shuffle();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        assertTrue(player1.getHand().isEmpty());
        assertTrue(player2.getHand().isEmpty());
        assertTrue(player3.getHand().isEmpty());
        assertTrue(player4.getHand().isEmpty());

        for (int i = 0;i < 5;i++) {
            player1.acceptDealtCard(standardDeck.dealCard());
            player2.acceptDealtCard(standardDeck.dealCard());
            player3.acceptDealtCard(standardDeck.dealCard());
            player4.acceptDealtCard(standardDeck.dealCard());
        }

        assertEquals(5, player1.getHand().size());
        assertEquals(5, player2.getHand().size());
        assertEquals(5, player3.getHand().size());
        assertEquals(5, player4.getHand().size());

        player1.newHand();
        player2.newHand();
        player3.newHand();
        player4.newHand();

        assertTrue(player1.getHand().isEmpty());
        assertTrue(player2.getHand().isEmpty());
        assertTrue(player3.getHand().isEmpty());
        assertTrue(player4.getHand().isEmpty());
    }
}
