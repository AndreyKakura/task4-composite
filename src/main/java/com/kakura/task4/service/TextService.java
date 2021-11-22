package com.kakura.task4.service;

import com.kakura.task4.entity.TextComponent;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<TextComponent> sortParagraphsBySentenceAmount(TextComponent textComponent);

    List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent);

    List<TextComponent> removeSentences(TextComponent textComponent, int wordCount);

    Map<String, Integer> countSameWords(TextComponent textComponent);

    long countVowelLetters(TextComponent textComponent);

    long countConsonantLetters(TextComponent textComponent);
}
