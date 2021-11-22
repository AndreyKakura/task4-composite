package com.kakura.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Punctuation implements TextComponent {
    private static final Logger logger = LogManager.getLogger();

    private ComponentType componentType;
    private char punctuation;

    public Punctuation(ComponentType componentType, char punctuation) {
        this.componentType = componentType;
        this.punctuation = punctuation;
    }

    @Override
    public void add(TextComponent textComponent) {
        logger.error("Operation \"add\" is not available for punctuation");
        throw new UnsupportedOperationException("Operation \"add\" is not available for punctuation");
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.error("Operation \"remove\" is not available for punctuation");
        throw new UnsupportedOperationException("Operation \"remove\" is not available for punctuation");
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildren() {
        logger.error("Operation \"getChildren\" is not available for punctuation");
        throw new UnsupportedOperationException("Operation \"getChildren\" is not available for punctuation");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punctuation that = (Punctuation) o;

        if (punctuation != that.punctuation) return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = componentType != null ? componentType.hashCode() : 0;
        result = 31 * result + (int) punctuation;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }

}
