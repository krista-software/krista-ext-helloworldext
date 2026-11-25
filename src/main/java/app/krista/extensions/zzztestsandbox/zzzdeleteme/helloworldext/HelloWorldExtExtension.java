package app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext;

import app.krista.extension.executor.Invoker;
import app.krista.extension.impl.anno.ChangeLog;
import app.krista.extension.impl.anno.Extension;
import app.krista.extension.impl.anno.InvokerRequest;
import app.krista.extension.impl.anno.Java;
import app.krista.extension.impl.anno.StaticResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

/**
 * HelloWorldExt extension entry point — a minimal, self-contained sample extension that returns a
 * "Hello, World!" greeting (optionally personalized) with no external system or credentials involved.
 *
 * Auth pattern: NONE — there is nothing to authenticate against, so this class declares no connection
 * {@code @Field.*} fields and no Setup/Authentication tab requirement beyond the standard Documentation
 * tab and the always-present Setup area (Test Connection / Health Check), which simply reports success.
 */
@Extension(name = "HelloWorldExt", version = "1.0.0",
        description = "Minimal sample extension that returns a 'Hello, World!' greeting.")
@StaticResource(path = "docs", file = "docs")
@ChangeLog(file = "docs/pages/ReleaseNotes.md")
@Java(version = Java.Version.JAVA_21)
public final class HelloWorldExtExtension {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldExtExtension.class);

    private final Invoker invoker;

    @Inject
    public HelloWorldExtExtension(Invoker invoker) {
        this.invoker = invoker;
    }

    /** Setup-tab tabs. */
    @InvokerRequest(InvokerRequest.Type.CUSTOM_TABS)
    public Map<String, String> customTabs() {
        return Map.of("Documentation", "static/docs");
    }

    /** Test-Connection button. There is no external system to reach, so this always succeeds. */
    @InvokerRequest(InvokerRequest.Type.TEST_CONNECTION)
    public void testConnection() {
        LOGGER.info("HelloWorldExt test connection succeeded for invoker {} (no external system).",
                invoker.getInvokerId());
    }
}
