package org.douggschwind.games.cardgames.poker;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.FourOfAKind;
import org.douggschwind.games.cardgames.poker.common.FullHouse;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.HighCard;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.Straight;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;
import org.douggschwind.games.cardgames.poker.common.ThreeOfAKind;
import org.douggschwind.games.cardgames.poker.common.TwoPair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Doug Gschwind
 */
public class WesternHandStrengthTest {
	
	private Western underTest;
	private Player player;
	
	@BeforeEach
	public void initializeWestern() {
		underTest = new Western();
		player = new Player();
		underTest.addPlayer(player);
	}
	
	@Test
	public void testIsStrongerThan() {
		RoyalFlush royalFlush = new RoyalFlush();
		StraightFlush jackHighStraightFlush = new StraightFlush(FrenchSuitedPlayingCard.Kind.Jack);
		FourOfAKind fourTens = new FourOfAKind(FrenchSuitedPlayingCard.Kind.Ten);
		FullHouse acesBasedFullHouse = new FullHouse(FrenchSuitedPlayingCard.Kind.Ace);
		Flush queenHighFlush = new Flush(FrenchSuitedPlayingCard.Kind.Queen);
		Straight tenHighStraight = new Straight(FrenchSuitedPlayingCard.Kind.Ten);
		ThreeOfAKind tripleFours = new ThreeOfAKind(FrenchSuitedPlayingCard.Kind.Four);
		TwoPair acesAndEights = new TwoPair(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Kind.Eight);
		Pair pairJacks = new Pair(FrenchSuitedPlayingCard.Kind.Jack);
		HighCard queenHigh = new HighCard(FrenchSuitedPlayingCard.Kind.Queen);
		
		assertNull(royalFlush.isStrongerThan(royalFlush));
		assertTrue(royalFlush.isStrongerThan(jackHighStraightFlush));
		assertTrue(royalFlush.isStrongerThan(fourTens));
		assertTrue(royalFlush.isStrongerThan(acesBasedFullHouse));
		assertTrue(royalFlush.isStrongerThan(queenHighFlush));
		assertTrue(royalFlush.isStrongerThan(tenHighStraight));
		assertTrue(royalFlush.isStrongerThan(tripleFours));
		assertTrue(royalFlush.isStrongerThan(acesAndEights));
		assertTrue(royalFlush.isStrongerThan(pairJacks));
		assertTrue(royalFlush.isStrongerThan(queenHigh));
		
		assertFalse(jackHighStraightFlush.isStrongerThan(royalFlush));
		assertNull(jackHighStraightFlush.isStrongerThan(jackHighStraightFlush));
		assertTrue(jackHighStraightFlush.isStrongerThan(fourTens));
		assertTrue(jackHighStraightFlush.isStrongerThan(acesBasedFullHouse));
		assertTrue(jackHighStraightFlush.isStrongerThan(queenHighFlush));
		assertTrue(jackHighStraightFlush.isStrongerThan(tenHighStraight));
		assertTrue(jackHighStraightFlush.isStrongerThan(tripleFours));
		assertTrue(jackHighStraightFlush.isStrongerThan(acesAndEights));
		assertTrue(jackHighStraightFlush.isStrongerThan(pairJacks));
		assertTrue(jackHighStraightFlush.isStrongerThan(queenHigh));
		
		assertFalse(fourTens.isStrongerThan(royalFlush));
		assertFalse(fourTens.isStrongerThan(jackHighStraightFlush));
		assertNull(fourTens.isStrongerThan(fourTens));
		assertTrue(fourTens.isStrongerThan(acesBasedFullHouse));
		assertTrue(fourTens.isStrongerThan(queenHighFlush));
		assertTrue(fourTens.isStrongerThan(tenHighStraight));
		assertTrue(fourTens.isStrongerThan(tripleFours));
		assertTrue(fourTens.isStrongerThan(acesAndEights));
		assertTrue(fourTens.isStrongerThan(pairJacks));
		assertTrue(fourTens.isStrongerThan(queenHigh));
		
		assertFalse(acesBasedFullHouse.isStrongerThan(royalFlush));
		assertFalse(acesBasedFullHouse.isStrongerThan(jackHighStraightFlush));
		assertFalse(acesBasedFullHouse.isStrongerThan(fourTens));
		assertNull(acesBasedFullHouse.isStrongerThan(acesBasedFullHouse));
		assertTrue(acesBasedFullHouse.isStrongerThan(queenHighFlush));
		assertTrue(acesBasedFullHouse.isStrongerThan(tenHighStraight));
		assertTrue(acesBasedFullHouse.isStrongerThan(tripleFours));
		assertTrue(acesBasedFullHouse.isStrongerThan(acesAndEights));
		assertTrue(acesBasedFullHouse.isStrongerThan(pairJacks));
		assertTrue(acesBasedFullHouse.isStrongerThan(queenHigh));
		
		assertFalse(queenHighFlush.isStrongerThan(royalFlush));
		assertFalse(queenHighFlush.isStrongerThan(jackHighStraightFlush));
		assertFalse(queenHighFlush.isStrongerThan(fourTens));
		assertFalse(queenHighFlush.isStrongerThan(acesBasedFullHouse));
		assertNull(queenHighFlush.isStrongerThan(queenHighFlush));
		assertTrue(queenHighFlush.isStrongerThan(tenHighStraight));
		assertTrue(queenHighFlush.isStrongerThan(tripleFours));
		assertTrue(queenHighFlush.isStrongerThan(acesAndEights));
		assertTrue(queenHighFlush.isStrongerThan(pairJacks));
		assertTrue(queenHighFlush.isStrongerThan(queenHigh));
		
		assertFalse(tenHighStraight.isStrongerThan(royalFlush));
		assertFalse(tenHighStraight.isStrongerThan(jackHighStraightFlush));
		assertFalse(tenHighStraight.isStrongerThan(fourTens));
		assertFalse(tenHighStraight.isStrongerThan(acesBasedFullHouse));
		assertFalse(tenHighStraight.isStrongerThan(queenHighFlush));
		assertNull(tenHighStraight.isStrongerThan(tenHighStraight));
		assertTrue(tenHighStraight.isStrongerThan(tripleFours));
		assertTrue(tenHighStraight.isStrongerThan(acesAndEights));
		assertTrue(tenHighStraight.isStrongerThan(pairJacks));
		assertTrue(tenHighStraight.isStrongerThan(queenHigh));
		
		assertFalse(tripleFours.isStrongerThan(royalFlush));
		assertFalse(tripleFours.isStrongerThan(jackHighStraightFlush));
		assertFalse(tripleFours.isStrongerThan(fourTens));
		assertFalse(tripleFours.isStrongerThan(acesBasedFullHouse));
		assertFalse(tripleFours.isStrongerThan(queenHighFlush));
		assertFalse(tripleFours.isStrongerThan(tenHighStraight));
		assertNull(tripleFours.isStrongerThan(tripleFours));
		assertTrue(tripleFours.isStrongerThan(acesAndEights));
		assertTrue(tripleFours.isStrongerThan(pairJacks));
		assertTrue(tripleFours.isStrongerThan(queenHigh));
		
		assertFalse(acesAndEights.isStrongerThan(royalFlush));
		assertFalse(acesAndEights.isStrongerThan(jackHighStraightFlush));
		assertFalse(acesAndEights.isStrongerThan(fourTens));
		assertFalse(acesAndEights.isStrongerThan(acesBasedFullHouse));
		assertFalse(acesAndEights.isStrongerThan(queenHighFlush));
		assertFalse(acesAndEights.isStrongerThan(tenHighStraight));
		assertFalse(acesAndEights.isStrongerThan(tripleFours));
		assertNull(acesAndEights.isStrongerThan(acesAndEights));
		assertTrue(acesAndEights.isStrongerThan(pairJacks));
		assertTrue(acesAndEights.isStrongerThan(queenHigh));
		
		assertFalse(pairJacks.isStrongerThan(royalFlush));
		assertFalse(pairJacks.isStrongerThan(jackHighStraightFlush));
		assertFalse(pairJacks.isStrongerThan(fourTens));
		assertFalse(pairJacks.isStrongerThan(acesBasedFullHouse));
		assertFalse(pairJacks.isStrongerThan(queenHighFlush));
		assertFalse(pairJacks.isStrongerThan(tenHighStraight));
		assertFalse(pairJacks.isStrongerThan(tripleFours));
		assertFalse(pairJacks.isStrongerThan(acesAndEights));
		assertNull(pairJacks.isStrongerThan(pairJacks));
		assertTrue(pairJacks.isStrongerThan(queenHigh));
		
		assertFalse(queenHigh.isStrongerThan(royalFlush));
		assertFalse(queenHigh.isStrongerThan(jackHighStraightFlush));
		assertFalse(queenHigh.isStrongerThan(fourTens));
		assertFalse(queenHigh.isStrongerThan(acesBasedFullHouse));
		assertFalse(queenHigh.isStrongerThan(queenHighFlush));
		assertFalse(queenHigh.isStrongerThan(tenHighStraight));
		assertFalse(queenHigh.isStrongerThan(tripleFours));
		assertFalse(queenHigh.isStrongerThan(acesAndEights));
		assertFalse(queenHigh.isStrongerThan(pairJacks));
		assertNull(queenHigh.isStrongerThan(queenHigh));
	}

	@Test
	public void testDetermineHandStrengthRoyalFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthStraightFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(StraightFlush.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraightFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(StraightFlush.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKind() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Eight, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFullHouse() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Clubs));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(FullHouse.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.King, ((FullHouse) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(Flush.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthStraight() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Diamonds));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(Straight.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Eight, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraight() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(Straight.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthThreeOfAKind() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(ThreeOfAKind.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Four, ((ThreeOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthTwoPair() {
		// Dead man's hand, A's and 8's.
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(TwoPair.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((TwoPair) actualHandStrength).getHigherValuedKind());
		assertEquals(FrenchSuitedPlayingCard.Kind.Eight, ((TwoPair) actualHandStrength).getLowerValuedKind());
	}
	
	@Test
	public void testDetermineHandStrengthPair() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(Pair.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Pair) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthHighCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		assertEquals(HighCard.class, actualHandStrength.getClass());
		assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((HighCard) actualHandStrength).getHighCardKind());
	}
}