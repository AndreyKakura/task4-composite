package com.kakura.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Letter implements TextComponent {
    private static final Logger logger = LogManager.getLogger();

    private ComponentType componentType;
    private char letter;

    public Letter(ComponentType componentType, char letter) {
        this.componentType = componentType;
        this.letter = letter;
    }

    @Override
    public void add(TextComponent textComponent) {
        logger.error("Operation \"add\" is not available for letter");
        throw new UnsupportedOperationException("Operation \"add\" is not available for letter");
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.error("Operation \"remove\" is not available for letter");
        throw new UnsupportedOperationException("Operation \"remove\" is not available for letter");
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.error("Operation \"getChildren\" is not available for letter");
        throw new UnsupportedOperationException("Operation \"getChildren\" is not available for letter");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter1 = (Letter) o;

        if (letter != letter1.letter) return false;
        return componentType == letter1.componentType;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (int) letter;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
