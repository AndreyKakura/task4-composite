package com.kakura.task4.reader;

import com.kakura.task4.exception.TextException;

public interface TextReader {
    String read(String textPath) throws TextException;
}
