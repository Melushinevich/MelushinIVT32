package org.douggschwind.games.dicegames.boggle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Houses an n-ary tree that decomposes our list of valid words into a sequence of nodes for ease
 * in determining if a sequence of letters is a word or the first letters of one to many valid words.
 * @author Doug Gschwind
 */
public class WordTreeTest {
    @Test
    public void comprehensiveTest() {
        // We will use but a brief subset of valid words for our testing purposes here.
        Set<String> validWords = new HashSet<>();
        validWords.add("apple");
        validWords.add("artist");
        validWords.add("art");
        validWords.add("arts");
        validWords.add("banana");
        validWords.add("ban");
        validWords.add("bane");
        validWords.add("two");
        validWords.add("to");
        validWords.add("too");
        validWords.add("top");
        validWords.add("three");
        validWords.add("thank");
        validWords.add("thanks");
        validWords.add("thee");
        validWords.add("theme");
        validWords.add("them");
        validWords.add("the");
        validWords.add("though");
        validWords.add("those");
        validWords.add("this");
        validWords.add("that");
        validWords.add("thus");
        validWords.add("thought");
        validWords.add("thoughts");
        validWords.add("thorough");
        validWords.add("you");
        validWords.add("zebra");
        validWords.add("zero");
        validWords.add("zoo");

        final WordTree subject = new WordTree();
        subject.seed(validWords);

        Set<String> invalidWords = new HashSet<>();
        invalidWords.add("appled");
        invalidWords.add("arf");
        invalidWords.add("b");
        invalidWords.add("band");
        invalidWords.add("color");
        invalidWords.add("deck");
        invalidWords.add("easy");
        invalidWords.add("false");
        invalidWords.add("gaff");
        invalidWords.add("house");
        invalidWords.add("idle");
        invalidWords.add("joy");
        invalidWords.add("king");
        invalidWords.add("long");
        invalidWords.add("mind");
        invalidWords.add("none");
        invalidWords.add("optional");
        invalidWords.add("people");
        invalidWords.add("queen");
        invalidWords.add("rest");
        invalidWords.add("session");
        invalidWords.add("t");
        invalidWords.add("u");
        invalidWords.add("v");
        invalidWords.add("w");
        invalidWords.add("x");
        invalidWords.add("y");
        invalidWords.add("z");

        for (String invalidWord : invalidWords) {
            assertFalse(validWords.contains(invalidWord));
        }

        assertFalse(subject.isValidWord(null));
        assertFalse(subject.isValidWord(""));
        invalidWords.forEach(invalidWord -> assertFalse(subject.isValidWord(invalidWord)));
        validWords.forEach(validWord -> assertTrue(subject.isValidWord(validWord)));

        assertTrue(subject.hasWordsThatBeginWith("a"));
        assertFalse(subject.hasWordsThatBeginWith("ab"));
        assertFalse(subject.hasWordsThatBeginWith("az"));
        assertTrue(subject.hasWordsThatBeginWith("ap"));
        assertTrue(subject.hasWordsThatBeginWith("ar"));
        assertTrue(subject.hasWordsThatBeginWith("art"));
        assertTrue(subject.hasWordsThatBeginWith("arti"));
        assertFalse(subject.hasWordsThatBeginWith("az"));

        assertTrue(subject.hasWordsThatBeginWith("b"));
        assertTrue(subject.hasWordsThatBeginWith("ba"));
        assertTrue(subject.hasWordsThatBeginWith("ban"));
        assertTrue(subject.hasWordsThatBeginWith("bana"));
        assertTrue(subject.hasWordsThatBeginWith("banan"));
        assertTrue(subject.hasWordsThatBeginWith("banana"));
        assertFalse(subject.hasWordsThatBeginWith("bb"));
        assertFalse(subject.hasWordsThatBeginWith("bz"));

        assertFalse(subject.hasWordsThatBeginWith("c"));
        assertFalse(subject.hasWordsThatBeginWith("d"));
        assertFalse(subject.hasWordsThatBeginWith("e"));
        assertFalse(subject.hasWordsThatBeginWith("f"));
        assertFalse(subject.hasWordsThatBeginWith("g"));
        assertFalse(subject.hasWordsThatBeginWith("h"));
        assertFalse(subject.hasWordsThatBeginWith("i"));
        assertFalse(subject.hasWordsThatBeginWith("j"));
        assertFalse(subject.hasWordsThatBeginWith("k"));
        assertFalse(subject.hasWordsThatBeginWith("l"));
        assertFalse(subject.hasWordsThatBeginWith("m"));
        assertFalse(subject.hasWordsThatBeginWith("n"));
        assertFalse(subject.hasWordsThatBeginWith("o"));
        assertFalse(subject.hasWordsThatBeginWith("p"));
        assertFalse(subject.hasWordsThatBeginWith("q"));
        assertFalse(subject.hasWordsThatBeginWith("r"));
        assertFalse(subject.hasWordsThatBeginWith("s"));

        assertTrue(subject.hasWordsThatBeginWith("t"));
        assertTrue(subject.hasWordsThatBeginWith("th"));
        assertTrue(subject.hasWordsThatBeginWith("tha"));
        assertTrue(subject.hasWordsThatBeginWith("thi"));
        assertTrue(subject.hasWordsThatBeginWith("tho"));
        assertTrue(subject.hasWordsThatBeginWith("to"));

        assertFalse(subject.hasWordsThatBeginWith("u"));
        assertFalse(subject.hasWordsThatBeginWith("v"));
        assertFalse(subject.hasWordsThatBeginWith("w"));
        assertFalse(subject.hasWordsThatBeginWith("x"));

        assertTrue(subject.hasWordsThatBeginWith("z"));
        assertTrue(subject.hasWordsThatBeginWith("ze"));
        assertTrue(subject.hasWordsThatBeginWith("zeb"));
        assertTrue(subject.hasWordsThatBeginWith("zebr"));
        assertTrue(subject.hasWordsThatBeginWith("zebra"));
        assertTrue(subject.hasWordsThatBeginWith("zer"));
        assertTrue(subject.hasWordsThatBeginWith("zero"));
        assertTrue(subject.hasWordsThatBeginWith("zo"));
        assertFalse(subject.hasWordsThatBeginWith("zz"));
    }
}
