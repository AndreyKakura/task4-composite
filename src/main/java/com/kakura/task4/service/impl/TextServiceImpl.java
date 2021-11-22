package com.kakura.task4.service.impl;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.Punctuation;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.service.TextService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    private static final String VOWEL_REGEX = "(?iu)[aeiouyаеёионыэюя]";
    private static final String CONSONANT_REGEX = "(?iu)[a-zа-я&&[^aeiouyаеёионыэюя]]";

    @Override
    public List<TextComponent> sortParagraphsBySentenceAmount(TextComponent textComponent) {

        List<TextComponent> paragraphs = textComponent.getChildren();
        paragraphs.sort(new Comparator<TextComponent>() {
            @Override
            public int compare(TextComponent textComponent1, TextComponent textComponent2) {
                return Integer.compare(textComponent1.getChildren().size(), textComponent2.getChildren().size());
            }
        });
        return paragraphs;
    }

    @Override
    public List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent) {
        int maxLength = findLengthOfLongestWord(textComponent);
        return textComponent.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .flatMap(sentence -> sentence.getChildren().stream())
                .filter(lexeme -> lexeme.getChildren().stream()
                        .anyMatch(word -> word.getType().equals(ComponentType.WORD) && word.toString().length() == maxLength))
                .collect(Collectors.toList());
    }

    @Override
    public List<TextComponent> removeSentences(TextComponent textComponent, int wordCount) {
        return textComponent.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .flatMap(sentence -> sentence.getChildren().stream())
                .filter(lexeme -> lexeme.getChildren().stream()
                        .filter(word -> word.getType().equals(ComponentType.WORD)).count() >= wordCount).toList();


    }

    @Override
    public Map<String, Integer> countSameWords(TextComponent textComponent) {
        Map<String, Integer> sameWords = textComponent.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .flatMap(s -> s.getChildren().stream())
                .flatMap(lx -> lx.getChildren().stream().filter(w -> !(w instanceof Punctuation)))
                .map(w -> w.toString().toLowerCase())
                .collect(Collectors.toMap(s -> s, i -> 1, (i1, i2) -> i1 + i2));


        Map<String, Integer> otherWords = textComponent.getChildren().stream()
                .flatMap(p -> p.getChildren().stream())
                .flatMap(s -> s.getChildren().stream())
                .flatMap(lx -> lx.getChildren().stream())
                .flatMap(word -> word.getChildren().stream())
                .map(w -> w.toString().toLowerCase())
                .collect(Collectors.toMap(s -> s, i -> 1, (i1, i2) -> i1 + i2));

        otherWords.values().removeIf(i -> i == 1);

        return otherWords;
    }

    private int findLengthOfLongestWord(TextComponent textComponent) {
        return textComponent.getChildren().stream()
                .flatMap(paragraph -> paragraph.getChildren().stream())
                .flatMap(sentence -> sentence.getChildren().stream())
                .flatMap(lexeme -> lexeme.getChildren().stream())
                .filter(word -> word.getType().equals(ComponentType.WORD))
                .max(Comparator.comparingInt(word -> word.toString().length()))
                .get().toString().length();
    }
}
