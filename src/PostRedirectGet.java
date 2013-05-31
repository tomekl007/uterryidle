import com.googlecode.utterlyidle.Redirector;
import com.googlecode.utterlyidle.Response;
import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.POST;
import com.googlecode.utterlyidle.annotations.Path;
import com.googlecode.utterlyidle.annotations.PathParam;

import static com.googlecode.totallylazy.proxy.Call.method;
import static com.googlecode.totallylazy.proxy.Call.on;

@Path("path/{id}")
public class PostRedirectGet {
    private final Redirector redirector;
    private FakeDb fakeDb = new FakeDb();
    // Redirector is already in the container, injected by the library
    public PostRedirectGet(Redirector redirector) {
        this.redirector = redirector;
    }

    @POST
    public Response post(@PathParam("id") String id) {
        // some logic
        System.out.println("post saving to db : " + id);
        fakeDb.setValue(id);
        return redirector.seeOther(method(on(PostRedirectGet.class).get(id)));
    }

    @GET
    public String get(@PathParam("id") String id) {
        System.out.println("get ->" + id);
        return fakeDb.getValue();
    }
}