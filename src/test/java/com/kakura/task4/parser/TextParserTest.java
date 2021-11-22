package com.kakura.task4.parser;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.impl.ParagraphParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextParserTest {
    private TextParser paragraphParser;
    private static final String EXPECTED_STRING = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
            "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
            "\tIt is a established fact that a reader will be of a page when looking at its layout...\n" +
            "\tBye бандерлоги.\n\t";

    @BeforeEach
    void setUp() {
        paragraphParser = new ParagraphParser();
    }

    @AfterEach
    void tearDown() {
        paragraphParser = null;
    }

    @Test
    void parseTest() {
        String testString = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\tBye бандерлоги.";
        TextComponent textComponent = new TextComposite(ComponentType.TEXT);
        textComponent.add(paragraphParser.parse(testString));
        String actualString = textComponent.toString();
        assertEquals(EXPECTED_STRING, actualString);
    }
}