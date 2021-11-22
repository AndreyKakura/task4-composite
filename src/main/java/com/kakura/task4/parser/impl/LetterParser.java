package com.kakura.task4.parser.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.Letter;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.parser.TextParser;

public class LetterParser implements TextParser {

    @Override
    public TextComposite parse(String data) {
        TextComposite letterComposite = new TextComposite(ComponentType.LETTER);
        char[] letters = data.toCharArray();
        for (char letter : letters) {
            TextComponent letterComponent = new Letter(ComponentType.LETTER, letter);
            letterComposite.add(letterComponent);
        }

        return letterComposite;
    }
}
