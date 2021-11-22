package com.kakura.task4.parser.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.Punctuation;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndPunctuationParser implements TextParser {
    private final TextParser letterParser = new LetterParser();
    private static final String WORD_REGEX = "[А-я\\w]+";
    private static final String WORD_OR_PUNCTUATION_REGEX = "([\\wа-яА-ЯёЁ]+)|(\\p{Punct})";

    @Override
    public TextComposite parse(String data) {
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);

        Pattern pattern = Pattern.compile(WORD_OR_PUNCTUATION_REGEX);
        Matcher matcher = pattern.matcher(data);

        while(matcher.find()) {
            String group = matcher.group();
            Pattern wordPattern = Pattern.compile(WORD_REGEX);
            Matcher wordMatcher = wordPattern.matcher(group);

            if(wordMatcher.matches()) {
                TextComponent wordComponent = letterParser.parse(group);
                wordComposite.add(wordComponent);
            } else {
                TextComponent punctuationComponent = new Punctuation(ComponentType.PUNCTUATION,group.charAt(0));
                wordComposite.add(punctuationComponent);
            }
        }

        return wordComposite;
    }
}
