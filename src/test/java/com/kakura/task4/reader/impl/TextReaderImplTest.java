package com.kakura.task4.reader.impl;

import com.kakura.task4.exception.TextException;
import com.kakura.task4.reader.TextReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReaderImplTest {
    private TextReader reader;
    private static final String EXPECTED_STRING = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\r\n" +
            "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n" +
            "\tIt is a established fact that a reader will be of a page when looking at its layout...\r\n" +
            "\tBye бандерлоги.";

    @BeforeEach
    void setUp() {
        reader = new TextReaderImpl();
    }

    @AfterEach
    void tearDown() {
        reader = null;
    }

    @Test
    void read() throws TextException {
        String actualString = reader.read("src/test/resources/data/testtext.txt");
        assertEquals(EXPECTED_STRING, actualString);
    }
}