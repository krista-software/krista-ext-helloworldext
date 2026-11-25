package app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext.catalog;

import app.krista.extension.executor.ExtensionResponse;
import app.krista.extension.executor.ExtensionResponseBuilder;
import app.krista.extension.impl.anno.Attribute;
import app.krista.extension.impl.anno.CatalogRequest;
import app.krista.extension.impl.anno.Domain;
import app.krista.extension.impl.anno.Field;
import app.krista.extensions.zzztestsandbox.zzzdeleteme.helloworldext.service.GreetingService;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Greeting catalog requests. The @Domain identity is shared by every Area/@Entity in this extension.
 */
@Domain(id = "catEntryDomain_a11bb761-5f94-4d6f-86d5-d77e9cb47046",
        name = "ZZZ Delete Me",
        ecosystemId = "catEntryEcosystem_7b848154-eb50-4796-a8c3-4fa51c868c61",
        ecosystemName = "ZZZ Test Sandbox",
        ecosystemVersion = "e9240f11-82ae-4623-a8b3-6d45f0b6f639")
public class GreetingArea {

    private final GreetingService greetingService;

    @Inject
    public GreetingArea(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @CatalogRequest(
            id = "localDomainRequest_5b9f2e71-3a8c-4d06-a1e4-7f2b6c9d0a85",
            name = "Get Hello World Greeting",
            description = "Return a 'Hello, World!' greeting, optionally personalized with a name.",
            area = "Greeting",
            type = CatalogRequest.Type.QUERY_SYSTEM)
    @Field.Text(name = "Message", required = false, attributes = {@Attribute(name = "visualWidth", value = "L")}, options = {})
    public ExtensionResponse getHelloWorldGreeting(
            @Field.Text(name = "Name", required = false,
                    attributes = {@Attribute(name = "visualWidth", value = "M")}, options = {}) String name) {
        Map<String, Object> out = new LinkedHashMap<>();
        out.put("Message", greetingService.formatGreeting(name));
        return new ExtensionResponseBuilder().success(out).build();
    }
}
