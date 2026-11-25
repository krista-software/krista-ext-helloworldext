package app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext.catalog;

import app.krista.extension.executor.ExtensionResponse;
import app.krista.extension.executor.ExtensionResponseBuilder;
import app.krista.extension.executor.Invoker;
import app.krista.extension.impl.anno.Attribute;
import app.krista.extension.impl.anno.CatalogRequest;
import app.krista.extension.impl.anno.Domain;
import app.krista.extension.impl.anno.Field;

import javax.inject.Inject;
import java.lang.management.ManagementFactory;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Setup area — the standard Test Connection + Health Check requests.
 *
 * This extension has no external system (auth pattern NONE), so both checks are local: Test Connection
 * always succeeds, and Health Check reports only JVM heap usage. Area name "SetUp" matches the spelling
 * already registered under this domain in Krista Studio (case-sensitive match on export).
 */
@Domain(id = "catEntryDomain_a11bb761-5f94-4d6f-86d5-d77e9cb47046",
        name = "ZZZ Delete Me",
        ecosystemId = "catEntryEcosystem_7b848154-eb50-4796-a8c3-4fa51c868c61",
        ecosystemName = "ZZZ Test Sandbox",
        ecosystemVersion = "e9240f11-82ae-4623-a8b3-6d45f0b6f639")
public class SetupArea {

    private final String invokerId;

    @Inject
    public SetupArea(Invoker invoker) {
        this.invokerId = invoker.getInvokerId();
    }

    @CatalogRequest(
            id = "localDomainRequest_a3f1c9e2-7b4d-4e18-9a2f-6c0d8b5e1f73",
            name = "Test Connection",
            description = "Confirm the extension is reachable. There is no external system to validate against.",
            area = "SetUp",
            type = CatalogRequest.Type.QUERY_SYSTEM)
    @Field.Boolean(name = "Success", required = false, attributes = {}, options = {})
    @Field.Text(name = "Message", required = false, attributes = {@Attribute(name = "visualWidth", value = "L")}, options = {})
    public ExtensionResponse testConnection() {
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("Success", true);
        out.put("Message", "HelloWorldExt is reachable (no external system to connect to).");
        return new ExtensionResponseBuilder().success(out).build();
    }

    @CatalogRequest(
            id = "localDomainRequest_d8e4b267-1c9a-4f53-8b70-2e5f9a1c3d64",
            name = "Health Check",
            description = "Report extension JVM health.",
            area = "SetUp",
            type = CatalogRequest.Type.QUERY_SYSTEM)
    @Field.Boolean(name = "Is Healthy", required = false, attributes = {}, options = {})
    @Field(name = "Heap Used MB", type = "Number", required = false, attributes = {@Attribute(name = "visualWidth", value = "S")}, options = {})
    @Field.Text(name = "Details", required = false, attributes = {@Attribute(name = "visualWidth", value = "L")}, options = {})
    public ExtensionResponse healthCheck() {
        long heapUsedMb = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024);
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("Is Healthy", true);
        out.put("Heap Used MB", (double) heapUsedMb);
        out.put("Details", "OK (invoker " + invokerId + ")");
        return new ExtensionResponseBuilder().success(out).build();
    }
}
