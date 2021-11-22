package com.kakura.task4.service.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.exception.TextException;
import com.kakura.task4.parser.TextParser;
import com.kakura.task4.parser.impl.ParagraphParser;
import com.kakura.task4.parser.impl.SentenceParser;
import com.kakura.task4.reader.TextReader;
import com.kakura.task4.reader.impl.TextReaderImpl;
import com.kakura.task4.service.TextService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {
    private TextService textService;
    private TextParser paragraphParser;
    private TextReader reader;
    private TextComponent textComponent;

    @BeforeEach
    void setUp() throws TextException {
        textService = new TextServiceImpl();
        paragraphParser = new ParagraphParser();
        reader = new TextReaderImpl();
        textComponent = new TextComposite(ComponentType.TEXT);
        textComponent.add(paragraphParser.parse(reader.read("src/test/resources/data/testtext.txt")));
    }

    @AfterEach
    void tearDown() {
        textService = null;
        paragraphParser = null;
        textComponent = null;
    }

    @Test
    void sortParagraphsBySentenceAmount() {
        String testString = "\tSentence. Sentence.\n\tAnother sentence.\n\tSome sentence. Some sentence. Some sentence.";
        List<TextComponent> actualList = textService.sortParagraphsBySentenceAmount(paragraphParser.parse(testString));
        String expectedString = "\tAnother sentence.\n\tSentence. Sentence.\n\tSome sentence. Some sentence. Some sentence.";
        List<TextComponent> expectedList = paragraphParser.parse(expectedString).getChildren();

        assertEquals(expectedList, actualList);
    }

    @Test
    void findSentencesWithLongestWord() {
        String testString = "\tVeryveryverylongword something. Sentence.\n\tVeryveryverylongword another thing. Something. Something.\n\tSentence.";
        TextComponent testComponent = new TextComposite(ComponentType.TEXT);
        testComponent.add(paragraphParser.parse(testString));
        List<TextComponent> actualList = textService.findSentencesWithLongestWord(testComponent);

        TextComponent expectedComponent = new TextComposite(ComponentType.TEXT);
        String expectedString = "Veryveryverylongword something. Veryveryverylongword another thing.";
        expectedComponent.add(paragraphParser.parse(expectedString));
        List<TextComponent> expectedList = textService.findSentencesWithLongestWord(expectedComponent);

        assertEquals(expectedList, actualList);
    }

    @Test
    void removeSentences() {
        String testString = "\tVeryveryverylongword something. Sentence.\n\tVeryveryverylongword another thing. Something. Something.\n\tSentence.";
        TextComponent testComponent = new TextComposite(ComponentType.TEXT);
        testComponent.add(paragraphParser.parse(testString));
        List<TextComponent> actualList = textService.removeSentences(testComponent, 2);

        String expectedString = "Veryveryverylongword something. Veryveryverylongword another thing.";
        TextComponent expectedComponent = new TextComposite(ComponentType.TEXT);
        expectedComponent.add(paragraphParser.parse(expectedString));
        List<TextComponent> expectedList = textService.removeSentences(testComponent, 2);

        assertEquals(actualList, expectedList);
    }

    @Test
    void countSameWords() {
        String testString = "\tVeryveryverylongword something. Sentence.\n\tVeryveryverylongword another thing. Something. Something.\n\tSentence.";
        TextComponent testComponent = new TextComposite(ComponentType.TEXT);
        testComponent.add(paragraphParser.parse(testString));
        Map<String, Integer> sameWords = textService.countSameWords(testComponent);
        System.out.println(sameWords);
       //Map<String, Integer> expected = Map.of({)
    }
}