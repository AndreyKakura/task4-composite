package com.kakura.task4.parser.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {
    private final TextParser lexemeParser = new LexemeParser();
    private static final String SENTENCE_REGEX = ".+?[.?!…](?=\\s|$)";

    @Override
    public TextComposite parse(String data) {
        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);

        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher sentenceMatcher = sentencePattern.matcher(data);

        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            TextComponent sentenceComponent = lexemeParser.parse(sentence);
            sentenceComposite.add(sentenceComponent);
        }

        return sentenceComposite;
    }
}
