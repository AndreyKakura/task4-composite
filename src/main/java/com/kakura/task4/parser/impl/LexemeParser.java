package com.kakura.task4.parser.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.TextParser;

public class LexemeParser implements TextParser {
    private final TextParser wordAndPunctuationParser = new WordAndPunctuationParser();
    private static final String LEXEME_DELIMITER_REGEX = "\\s";


    @Override
    public TextComposite parse(String data) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);

        String[] lexemes = data.split(LEXEME_DELIMITER_REGEX);

        for (String lexeme : lexemes) {
            if (!lexeme.equals("")) {
                TextComponent lexemeComponent = wordAndPunctuationParser.parse(lexeme);
                lexemeComposite.add(lexemeComponent);
            }
        }

        return lexemeComposite;
    }
}
