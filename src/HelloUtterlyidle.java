import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.Path;

import static com.googlecode.utterlyidle.ApplicationBuilder.application;

public class HelloUtterlyidle {
    public static void main(String[] args) throws Exception {
        application().addAnnotated(HelloResource.class).start();
    }

    public static class HelloResource {
        @GET
        @Path("/")
        public String hello() {
            return "Hello Utterlyidle";
        }
    }
}