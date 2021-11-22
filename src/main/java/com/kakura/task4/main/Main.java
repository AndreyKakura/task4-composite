package com.kakura.task4.main;

import com.kakura.task4.entity.ComponentType;
import com.kakura.task4.entity.TextComponent;
import com.kakura.task4.entity.TextComposite;
import com.kakura.task4.exception.TextException;
import com.kakura.task4.parser.TextParser;
import com.kakura.task4.parser.impl.*;
import com.kakura.task4.reader.TextReader;
import com.kakura.task4.reader.impl.TextReaderImpl;
import com.kakura.task4.service.TextService;
import com.kakura.task4.service.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.text.JTextComponent;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws TextException {
//        TextReader reader = new TextReaderImpl();
//        String text = reader.read("src/main/resources/data/text.txt");
//        System.out.println(text);

//        TextParser letterParser = new LetterParser();
//        System.out.println(letterParser.parse("Слово"));
//
//        TextParser wordAndPunctuationParser = new WordAndPunctuationParser();
//        System.out.println(wordAndPunctuationParser.parse("“Динамо”"));
//
//        TextParser lexemeParser = new LexemeParser();
//        System.out.println(letterParser.parse("It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged."));

//        TextParser sentenceParser = new SentenceParser();
//        System.out.println(sentenceParser.parse("\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!"));



        TextComponent textComponent = new TextComposite(ComponentType.TEXT);
        TextParser paragraphParser = new ParagraphParser();
        TextReader reader = new TextReaderImpl();
        TextService textService = new TextServiceImpl();
        System.out.println(textService.sortParagraphsBySentenceAmount(paragraphParser.parse(reader.read("src/main/resources/data/text.txt"))));
    }
}
