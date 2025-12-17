package org.douggschwind.games.cardgames.euchre;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Doug Gschwind
 */
public class ClassicEuchreTest {
    @Test
    public void testHand() {
        ClassicEuchre underTest = new ClassicEuchre();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        underTest.addPlayer(player1);
        underTest.addPlayer(player2);
        underTest.addPlayer(player3);
        underTest.addPlayer(player4);

        underTest.newHand();
        underTest.dealCardsToPlayers();
        assertNotNull(underTest.getInitialTrumpBiddingCardFromKitty());

        assertEquals(5, player1.getHand().size());
        assertEquals(5, player2.getHand().size());
        assertEquals(5, player3.getHand().size());
        assertEquals(5, player4.getHand().size());

        underTest.newHand();

        assertTrue(player1.getHand().isEmpty());
        assertTrue(player2.getHand().isEmpty());
        assertTrue(player3.getHand().isEmpty());
        assertTrue(player4.getHand().isEmpty());
    }

    @Test
    public void testPlayersAllGetDistinctCards() {
        ClassicEuchre underTest = new ClassicEuchre();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        underTest.addPlayer(player1);
        underTest.addPlayer(player2);
        underTest.addPlayer(player3);
        underTest.addPlayer(player4);

        underTest.newHand();
        underTest.dealCardsToPlayers();

        // Lets make sure that the cards in any one Player's hand are NOT
        // found in any of the other Player's hands.
        for (FrenchSuitedPlayingCard player1Card : player1.getHand()) {
            assertFalse(player2.getHand().contains(player1Card));
            assertFalse(player3.getHand().contains(player1Card));
            assertFalse(player4.getHand().contains(player1Card));
        }

        for (FrenchSuitedPlayingCard player2Card : player2.getHand()) {
            assertFalse(player1.getHand().contains(player2Card));
            assertFalse(player3.getHand().contains(player2Card));
            assertFalse(player4.getHand().contains(player2Card));
        }

        for (FrenchSuitedPlayingCard player3Card : player3.getHand()) {
            assertFalse(player1.getHand().contains(player3Card));
            assertFalse(player2.getHand().contains(player3Card));
            assertFalse(player4.getHand().contains(player3Card));
        }

        for (FrenchSuitedPlayingCard player4Card : player4.getHand()) {
            assertFalse(player1.getHand().contains(player4Card));
            assertFalse(player2.getHand().contains(player4Card));
            assertFalse(player3.getHand().contains(player4Card));
        }
    }
}
