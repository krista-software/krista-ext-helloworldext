package app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext.service;

import org.jvnet.hk2.annotations.Service;

/**
 * Pure, framework-free greeting logic — kept out of {@code GreetingArea} so it can be unit-tested
 * without the Krista runtime (see krista-extension-testing policy).
 */
@Service
public class GreetingService {

    private static final String DEFAULT_NAME = "World";

    public String formatGreeting(String name) {
        String trimmed = name == null ? "" : name.trim();
        String subject = trimmed.isEmpty() ? DEFAULT_NAME : trimmed;
        return "Hello, " + subject + "!";
    }
}
