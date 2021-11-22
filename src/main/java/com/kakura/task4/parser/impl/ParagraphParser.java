package com.kakura.task4.parser.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.TextParser;

public class ParagraphParser implements TextParser {
    private final SentenceParser sentenceParser = new SentenceParser();
    private static final String PARAGRAPH_DELIMITER_REGEX = "(?m)(?=^((\\t)|(\\s{4})))";

    @Override
    public TextComposite parse(String data) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);

        String[] paragraphs = data.split(PARAGRAPH_DELIMITER_REGEX);

        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = sentenceParser.parse(paragraph);
            paragraphComposite.add(paragraphComponent);
        }

        return paragraphComposite;
    }
}
