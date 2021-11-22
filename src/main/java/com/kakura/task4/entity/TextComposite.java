package com.kakura.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> textComponents = new ArrayList<>();
    private ComponentType componentType;

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }


    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildren() {
        return new ArrayList<TextComponent>(textComponents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (textComponents != null ? !textComponents.equals(that.textComponents) : that.textComponents != null)
            return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = textComponents != null ? textComponents.hashCode() : 0;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = componentType.getDelimiter();
        for (TextComponent textComponent : textComponents) {
            if (componentType.equals(ComponentType.TEXT)) {
                sb.append(delimiter);
            }
            sb.append(textComponent.toString());
            if (!componentType.equals(ComponentType.TEXT)) {
                sb.append(delimiter);
            }
            if (componentType.equals(ComponentType.PARAGRAPH)) {
                sb.delete(sb.length() - 3, sb.length() - 2); //delete space after paragraph
            }
        }

        return sb.toString();
    }
}
