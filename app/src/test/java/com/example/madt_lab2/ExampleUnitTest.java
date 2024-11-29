package com.example.madt_lab2;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.madt_lab2.utilities.TextCounting;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    /**
     * Test to probe that the option Chars count well the letters
     */
    @Test
    public void testGetCharsCount() {
        assertEquals(5, TextCounting.getCharsCount("Hello"));
        assertEquals(0, TextCounting.getCharsCount(""));
    }

    /*
    Test to probe that the option Words count well the words in the edit Text
     */
    @Test
    public void testGetWordsCount() {
        assertEquals(2, TextCounting.getWordsCount("Hello World"));
        assertEquals(0, TextCounting.getWordsCount("   ")); // Only spaces
        assertEquals(1, TextCounting.getWordsCount("SingleWord"));
        assertEquals(4, TextCounting.getWordsCount("S,4,3,w")); // Only punctuation
        assertEquals(4, TextCounting.getWordsCount("Hello, wOrdl,not here")); // Only punctuation
        assertEquals(3, TextCounting.getWordsCount("Hello.wordl.com")); // Only punctuation
    }

}
