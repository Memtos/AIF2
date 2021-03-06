package io.aif.language.common;

import io.aif.language.sentence.separators.extractors.CharacterStatTest;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


public class StringHelperTest {

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringFirstStrIsSubstrofSecondStr() throws Exception {
        final String t1 = "RecursiveSubstringComparator";
        final String t2 = "Substring";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringSecondStrIsSubstrofFirstStr() throws Exception {
        final String t1 = "Substring";
        final String t2 = "RecursiveSubstringComparator";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringInputStringsEqual() throws Exception {
        final String t1 = "Substring";
        final String t2 = "Substring";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringFirstStrIsSubstrofSecondStrCaseInsensitive() throws Exception {
        final String t1 = "RecursiveSubstringComparator";
        final String t2 = "SUBSTriNG";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringSecondStrIsSubstrofFirstStrCaseInsensitive() throws Exception {
        final String t1 = "Substring";
        final String t2 = "RecursiveSuBstRINgComparator";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringInputStringsEqualCaseInsensitive() throws Exception {
        final String t1 = "Substring";
        final String t2 = "SuBSTRing";
        final String expected = "substring";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstring() throws Exception {
        final String t1 = "Recieve";
        final String t2 = "Percieve";
        final String expected = "cieve";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringMoreThanOneAvailable() {
        final String t1 = "performer";
        final String t2 = "berkor";
        final String expected = "er";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testFindBiggestSubstringNoneFound() {
        final String t1 = "abcde";
        final String t2 = "ghijklmno";
        final String expected = "";
        String actual;

        actual = StringHelper.findLongestCommonSubstring(t1, t2);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testGenerateSubWordsofLengthThree() throws Exception {
        final String t1 = "birch";
        final int length = 4;
        final Set<String> expected = new LinkedHashSet<>();
        expected.add("birc");
        expected.add("irch");

        final Set<String> actual = StringHelper.generateSubWords(t1, length);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testGenerateSubWordsofLengthTwo() throws Exception {
        final String t1 = "birch";
        final int length = 2;
        final Set<String> expected = new LinkedHashSet<>();
        expected.add("bi");
        expected.add("ir");
        expected.add("rc");
        expected.add("ch");

        final Set<String> actual = StringHelper.generateSubWords(t1, length);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testGenerateSubWordsofLengthOne() throws Exception {
        final String t1 = "birch";
        final int length = 1;
        final Set<String> expected = new LinkedHashSet<>();
        expected.add("b");
        expected.add("i");
        expected.add("r");
        expected.add("c");
        expected.add("h");

        final Set<String> actual = StringHelper.generateSubWords(t1, length);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testGenerateSubWordDuplicateSubWordsCollapsed() throws Exception {
        final String t1 = "papa";
        final int length = 2;
        final Set<String> expected = new LinkedHashSet<>();
        expected.add("pa");
        expected.add("ap");

        final Set<String> actual = StringHelper.generateSubWords(t1, length);
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testGenerateSubWordWordLengthIsLessThanTheLengthOfWordsToBeGenerated() throws Exception {
        final String t1 = "papa";
        final int length = t1.length() + 1;
        try {
            StringHelper.generateSubWords(t1, length);
            assert false;
        } catch (IllegalArgumentException e) {  }
    }

    @Test(groups = "unit-tests")
    public void testLooksLikeCharacterWithAStringWithSingleChar() throws Exception {
        assertEquals(StringHelper.looksLikeCharacter("h"), true);
    }

    @Test(groups = "unit-tests")
    public void testLooksLikeCharacterWithMultipleCharString() throws Exception {
        assertEquals(StringHelper.looksLikeCharacter("hey"), false);
    }

    @Test(groups = "unit-tests")
    public void testCastToChar() throws Exception {
        Character expected = 'h';
        Character actual = StringHelper.castToChar("h").get();
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testCastToCharReturnsFalse() throws Exception {
        Optional actual = StringHelper.castToChar("hey");
        assertEquals(actual.isPresent(), false);
    }

    @Test(groups = "unit-tests")
    public void testStartsWithUpperCase() throws Exception {
        boolean actual = true;
        boolean expected = StringHelper.startsWithUpperCase("Helo");
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testStartsWithUpperCaseWithLowerCasedWord() throws Exception {
        boolean actual = false;
        boolean expected = StringHelper.startsWithUpperCase("helo");
        assertEquals(actual, expected);
    }

    @Test(groups = "unit-tests")
    public void testStartsWithUpperCaseWithGarbageStrings() throws Exception {
        List<String> input = Arrays.asList("#$@@#@#@$@*", "#$%@!!!$%%");
        boolean expected = false;
        for (String token : input) {
            assertEquals(StringHelper.startsWithUpperCase(token), expected);
        }
    }
}
