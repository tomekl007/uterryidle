import com.googlecode.utterlyidle.Resources;
import com.googlecode.utterlyidle.modules.Module;
import com.googlecode.utterlyidle.modules.RequestScopedModule;
import com.googlecode.utterlyidle.modules.ResourcesModule;
import com.googlecode.yadic.Container;

import java.util.Properties;

import static com.googlecode.totallylazy.proxy.Call.method;
import static com.googlecode.totallylazy.proxy.Call.on;
import static com.googlecode.utterlyidle.dsl.BindingBuilder.get;
import static com.googlecode.utterlyidle.dsl.BindingBuilder.queryParam;

public class PropertiesModule implements ResourcesModule, RequestScopedModule {
    public Container addPerRequestObjects(Container container) throws Exception {
        return container.addInstance(Properties.class, System.getProperties());
    }

    public Resources addResources(Resources resources) throws Exception {
        resources.add(get("/properties").resource(method(on(Properties.class).getProperty(queryParam(String.class, "name")))).build());
        return resources.add(get("/properties").resource(method(on(Properties.class).stringPropertyNames())).build());
    }
}