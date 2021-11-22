package com.kakura.task4.entity;

public enum ComponentType {
    TEXT("\t"),
    PARAGRAPH("\n\t"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    LETTER(""),
    PUNCTUATION("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
