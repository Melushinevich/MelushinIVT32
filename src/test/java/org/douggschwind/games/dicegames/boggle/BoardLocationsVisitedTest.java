package org.douggschwind.games.dicegames.boggle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Doug Gschwind
 */
public class BoardLocationsVisitedTest {
    @Test
    public void testClone() {
        BoardLocationsVisited subject = new BoardLocationsVisited(4);
        // Lets just mark the corners as being visited.
        subject.markVisited(0, 0);
        subject.markVisited(0, 3);
        subject.markVisited(3, 0);
        subject.markVisited(3, 3);

        assertTrue(subject.hasBeenVisited(0, 0));
        assertFalse(subject.hasBeenVisited(0, 1));
        assertFalse(subject.hasBeenVisited(0, 2));
        assertTrue(subject.hasBeenVisited(0, 3));

        assertFalse(subject.hasBeenVisited(1, 0));
        assertFalse(subject.hasBeenVisited(1, 1));
        assertFalse(subject.hasBeenVisited(1, 2));
        assertFalse(subject.hasBeenVisited(1, 3));

        assertFalse(subject.hasBeenVisited(2, 0));
        assertFalse(subject.hasBeenVisited(2, 1));
        assertFalse(subject.hasBeenVisited(2, 2));
        assertFalse(subject.hasBeenVisited(2, 3));

        assertTrue(subject.hasBeenVisited(3, 0));
        assertFalse(subject.hasBeenVisited(3, 1));
        assertFalse(subject.hasBeenVisited(3, 2));
        assertTrue(subject.hasBeenVisited(3, 3));

        BoardLocationsVisited clone = subject.clone();

        assertTrue(clone.hasBeenVisited(0, 0));
        assertFalse(clone.hasBeenVisited(0, 1));
        assertFalse(clone.hasBeenVisited(0, 2));
        assertTrue(clone.hasBeenVisited(0, 3));

        assertFalse(clone.hasBeenVisited(1, 0));
        assertFalse(clone.hasBeenVisited(1, 1));
        assertFalse(clone.hasBeenVisited(1, 2));
        assertFalse(clone.hasBeenVisited(1, 3));

        assertFalse(clone.hasBeenVisited(2, 0));
        assertFalse(clone.hasBeenVisited(2, 1));
        assertFalse(clone.hasBeenVisited(2, 2));
        assertFalse(clone.hasBeenVisited(2, 3));

        assertTrue(clone.hasBeenVisited(3, 0));
        assertFalse(clone.hasBeenVisited(3, 1));
        assertFalse(clone.hasBeenVisited(3, 2));
        assertTrue(clone.hasBeenVisited(3, 3));
    }
}
