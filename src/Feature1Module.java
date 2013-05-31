import com.googlecode.totallylazy.Callable1;
import com.googlecode.utterlyidle.*;
import com.googlecode.utterlyidle.annotations.HttpMethod;
import com.googlecode.utterlyidle.handlers.CachePolicy;
import com.googlecode.utterlyidle.handlers.GZipPolicy;
import com.googlecode.utterlyidle.handlers.GzipHandler;
import com.googlecode.utterlyidle.handlers.ResponseHandlers;
import com.googlecode.utterlyidle.modules.*;
import com.googlecode.yadic.Container;
import customer.Customer;
import customer.CustomerActivator;
import customer.CustomerResource;
import customer.CustomerService;

import static com.googlecode.totallylazy.Exceptions.ignoringException;
import static com.googlecode.utterlyidle.PathMatcher.path;
import static com.googlecode.utterlyidle.handlers.CachePolicy.cachePolicy;
import static com.googlecode.utterlyidle.handlers.GZipPolicy.gZipPolicy;
import static com.googlecode.utterlyidle.sitemesh.ContentTypePredicate.contentType;




import static com.googlecode.utterlyidle.Requests.method;
import static com.googlecode.utterlyidle.annotations.AnnotatedBindings.annotatedClass;
import static com.googlecode.utterlyidle.handlers.RenderingResponseHandler.renderer;

public class Feature1Module implements StartupModule, RequestScopedModule, ApplicationScopedModule, ResourcesModule, ResponseHandlersModule, ArgumentScopedModule {
    //for each request one object
    @Override
    public Container addPerRequestObjects(Container container) throws Exception {
        System.out.println("addPerRequestObjects : " + container);
        container.add(MyRequestScopeObject.class);
        //enabling custom caching policy
        container.addInstance(CachePolicy.class, cachePolicy(60).
                add(path("foo/bar")).
                add(contentType(MediaType.TEXT_JAVASCRIPT)).
                add(contentType(MediaType.TEXT_CSS)));

        //enabling gzip
        container.addInstance(GZipPolicy.class, gZipPolicy().
                add(contentType(MediaType.TEXT_JAVASCRIPT)).
                add(contentType(MediaType.TEXT_CSS)));

        container.add(CustomerService.class);
        return container.decorate(HttpHandler.class, GzipHandler.class);

        //return container;
    }

    @Override
    public Resources addResources(Resources resources) throws Exception {
        System.out.println("addResources : " + resources);
        resources.add(annotatedClass(MyResource.class));
        resources.add(annotatedClass(PostRedirectGet.class));
        resources.add(annotatedClass(CustomerResource.class));
        return resources;
    }

    @Override
    public ResponseHandlers addResponseHandlers(ResponseHandlers handlers) throws Exception {
        System.out.println("addResponseHandlers : " + handlers);
        return handlers.add(method(HttpMethod.GET).and(path("/resourcePath")), renderer(PrintfRenderer.class));
    }
    //one object for all application
    @Override
    public Container addPerApplicationObjects(Container container) throws Exception {
        System.out.println("addPerAppliationObjects : " + container);

        container.add(MyApplicationScopeObject.class);

        return container;
    }
    @Override
    public Container addPerArgumentObjects(Container container) throws Exception {
        return container.addActivator(Customer.class, CustomerActivator.class);
    }

    @Override
    public Container start(Container requestScope) {
        final HttpHandler handler = requestScope.get(HttpHandler.class);
        ignoringException(requestLessStyle()).apply(handler);
        return requestScope;
    }

    private Callable1<HttpHandler, Response> requestLessStyle() {
        return new Callable1<HttpHandler, Response>() {
            @Override
            public Response call(HttpHandler handler) throws Exception {
                System.out.println("call method afterStartOfapplication : " + handler);
                return handler.handle(RequestBuilder.get("stylesheets/style.less").build());
            }
        };
    }


}