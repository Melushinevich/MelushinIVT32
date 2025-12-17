package org.douggschwind.games.cardgames.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Doug Gschwind
 */
public class FrenchSuitedPlayingCardTest {

	@Test
	public void testEquals() {
		FrenchSuitedPlayingCard card1 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts);
		FrenchSuitedPlayingCard card2 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts);
		assertEquals(card1, card2);
		assertEquals(card2, card1);
	}
	
	@Test
	public void testNotEquals() {
		FrenchSuitedPlayingCard card1 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts);
		FrenchSuitedPlayingCard card2 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs);
		assertFalse(card1.equals(card2));
		assertFalse(card2.equals(card1));
	}

	@Test
	public void testGetDistinctCardKinds2() {
		List<FrenchSuitedPlayingCard> dealtHand = new ArrayList<>();
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		Set<FrenchSuitedPlayingCard.Kind> distinctCardKinds = FrenchSuitedPlayingCard.getDistinctCardKinds(dealtHand);
		assertEquals(2, distinctCardKinds.size());
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Three));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ten));
	}

	@Test
	public void testGetDistinctCardKinds3() {
		List<FrenchSuitedPlayingCard> dealtHand = new ArrayList<>();
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		Set<FrenchSuitedPlayingCard.Kind> distinctCardKinds = FrenchSuitedPlayingCard.getDistinctCardKinds(dealtHand);
		assertEquals(3, distinctCardKinds.size());
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Three));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ten));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ace));
	}

	@Test
	public void testGetDistinctCardKinds4() {
		List<FrenchSuitedPlayingCard> dealtHand = new ArrayList<>();
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		Set<FrenchSuitedPlayingCard.Kind> distinctCardKinds = FrenchSuitedPlayingCard.getDistinctCardKinds(dealtHand);
		assertEquals(4, distinctCardKinds.size());
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Two));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Three));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ten));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ace));
	}

	@Test
	public void testGetDistinctCardKinds5() {
		List<FrenchSuitedPlayingCard> dealtHand = new ArrayList<>();
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		dealtHand.add(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		Set<FrenchSuitedPlayingCard.Kind> distinctCardKinds = FrenchSuitedPlayingCard.getDistinctCardKinds(dealtHand);
		assertEquals(5, distinctCardKinds.size());
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Two));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Three));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ten));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Queen));
		assertTrue(distinctCardKinds.contains(FrenchSuitedPlayingCard.Kind.Ace));
	}

	@Test
	public void testBeats() {
		for (FrenchSuitedPlayingCard.Kind outerKind : FrenchSuitedPlayingCard.Kind.values()) {
			for (FrenchSuitedPlayingCard.Kind innerKind : FrenchSuitedPlayingCard.Kind.values()) {
				if (outerKind.equals(innerKind)) {
					assertSame(null, outerKind.hasHigherRank(innerKind));
				} else if (outerKind.getRank() < innerKind.getRank()) {
					assertTrue(outerKind.hasHigherRank(innerKind));
				} else {
					assertFalse(outerKind.hasHigherRank(innerKind));
				}
			}
		}
	}
	
	@Test
	public void testHasHigherRank() {
		FrenchSuitedPlayingCard card1 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades);
		FrenchSuitedPlayingCard card2 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts);
		assertTrue(card2.getKind().hasHigherRank(card1.getKind()));
		assertFalse(card1.getKind().hasHigherRank(card2.getKind()));
		assertNull(card1.getKind().hasHigherRank(card1.getKind()));
		assertNull(card2.getKind().hasHigherRank(card2.getKind()));
	}
	
	@Test
	public void testHasLowerRank() {
		FrenchSuitedPlayingCard card1 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades);
		FrenchSuitedPlayingCard card2 = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts);
		assertFalse(card1.getKind().hasLowerRank(card2.getKind()));
		assertTrue(card2.getKind().hasLowerRank(card1.getKind()));
		assertNull(card1.getKind().hasLowerRank(card1.getKind()));
		assertNull(card2.getKind().hasLowerRank(card2.getKind()));
	}
}
