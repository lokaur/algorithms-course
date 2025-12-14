package me.lokaur.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StreamsTest {

    @ParameterizedTest
    @CsvSource({
            "test1.txt, '[5:[Аня, Вася], 3:[Петя]]'",
            "test2.txt, '[5:[Аня, Вася], 3:[Петя]]'",
            "test3.txt, '[5:[Аня, Вася], 3:[Люба, Петя]]'",
            "test4.txt, '[5:[Аня, Вася], 3:[Петя]]'",
            "test5.txt, '[5:[Аня], 3:[Петя]]'",
    })
    void testStreams(final String fileName, final String expected) throws IOException {
        try (var is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            // Arrange
            assertNotNull(is);
            var lines = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .toList();

            // Act
            var result = Streams.convertToOneLine(lines);

            // Assert
            assertEquals(expected, result);
        }
    }
}
