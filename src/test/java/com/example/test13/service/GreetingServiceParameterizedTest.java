package com.example.test13.service;

import com.example.test13.GreetingsService;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.Argument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static com.example.test13.constants.GreetingsServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class GreetingServiceParameterizedTest {
    private final GreetingsService out = new GreetingsService();
    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(null, DEFAULT_NAME, DEFAULT_MESSAGE),
                Arguments.of(EMPTY_NAME, DEFAULT_NAME, DEFAULT_MESSAGE),
                Arguments.of(ONLY_SPACES_NAME, DEFAULT_NAME, DEFAULT_MESSAGE),
                Arguments.of(CORRECT_NAME, CORRECT_NAME, CORRECT_MESSAGE),
                Arguments.of(UPPER_CASE_NAME, CORRECT_NAME, CORRECT_MESSAGE),
                Arguments.of(LOWER_CASE_NAME, CORRECT_NAME, CORRECT_MESSAGE)
        );
    }

    @Test
    public void shouldReturnDefaultMessageWhenNameIsExists() {
        String result = out.generateGreetings();
        assertTrue(result.contains(DEFAULT_NAME));
        assertEquals(DEFAULT_MESSAGE, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectMessages(String inputName, String messageName, String expectedMessage) {
        String result = out.generateGreetings(inputName);
        Assertions.assertTrue(result.contains(messageName));
        Assertions.assertEquals(expectedMessage, result);
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNameContainsIllegalCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> out.generateGreetings(ILLEGAL_CHARACTERS_NAME)
        );
    }
}
