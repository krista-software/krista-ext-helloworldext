package app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void returnsDefaultGreetingWhenNameIsNull() {
        assertEquals("Hello, World!", service.formatGreeting(null));
    }

    @Test
    void returnsDefaultGreetingWhenNameIsEmpty() {
        assertEquals("Hello, World!", service.formatGreeting(""));
    }

    @Test
    void treatsBlankWhitespaceNameAsOmitted() {
        assertEquals("Hello, World!", service.formatGreeting("   "));
    }

    @Test
    void personalizesGreetingWhenNameIsProvided() {
        assertEquals("Hello, Alex!", service.formatGreeting("Alex"));
    }

    @Test
    void trimsSurroundingWhitespaceFromProvidedName() {
        assertEquals("Hello, Alex!", service.formatGreeting("  Alex  "));
    }
}
