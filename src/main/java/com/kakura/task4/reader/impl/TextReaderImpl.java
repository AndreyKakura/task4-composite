package com.kakura.task4.reader.impl;

import com.kakura.task4.exception.TextException;
import com.kakura.task4.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReaderImpl implements TextReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public String read(String textPath) throws TextException {
        Path path = Paths.get(textPath);

        if (!Files.exists(path)) {
            logger.error("File does not exist");
            throw new TextException("File does not exist");
        }

        String text;

        try {
            text = Files.readString(path);
        } catch (IOException e) {
            logger.error("IOException");
            throw new TextException("IOException", e);
        }

        return text;
    }
}
