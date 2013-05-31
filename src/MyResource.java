//import com.googlecode.funclate.Model;
import com.googlecode.totallylazy.Option;
import com.googlecode.totallylazy.Pair;
import com.googlecode.utterlyidle.*;
import com.googlecode.utterlyidle.annotations.*;
import com.googlecode.utterlyidle.rendering.Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyResource {

    private MyApplicationScopeObject applicationScopeObject;
    private MyRequestScopeObject requestScopeObject;

    public MyResource(MyApplicationScopeObject applicationScopeObject, MyRequestScopeObject requestScopeObjectObject) {
        System.out.println("injceting to MyResouce : " + applicationScopeObject + "" + requestScopeObjectObject);
        this.applicationScopeObject = applicationScopeObject;
        this.requestScopeObject = requestScopeObjectObject;
    }

    @GET
    @Path("/resourcePath")
    public MyResourceReturnType myResourceMethod() {
        applicationScopeObject.counter++;
        return new MyResourceReturnType(requestScopeObject.calculate(), applicationScopeObject.calculate());
    }

    @POST
    @Path("/postPath")
    public String myResourcePostMethod(){
        return "post" ;
    }



         @GET
         @Path("/param")
        public String get(@QueryParam("name") String name) {
            return name;
        }



        @GET
        @Path("foo/{id}")
        public String getURLwithParam(@PathParam("id") String id) {
            return id;
        }
         /*
        @GET
        @Path("/bar")
        public String getFromCookieParam(@CookieParam("name") String name) {
            return name;
        }

    //choose method with most param
        @GET
        public String get2() {
            return "no parameters";
        }

        @GET
        public String get2(@QueryParam("arg") String arg) {
            return arg;
        }

        @GET
        public String get2(@QueryParam("arg") String arg, @QueryParam("anotherArg") String anotherArg) {
            return arg+" "+anotherArg;
        }


    @Path("foo")

        @GET
        public String getDefault(@QueryParam("name") @DefaultValue("Dan") String name) {
            return name;
        }




    @Path("foo")

        @GET
        public String get(@QueryParam("name") Option<String> name) {
            return name.getOrElse("Dan");
        }


         */



//access to raw Response and Request
        @GET
        @Path("/home")
        public Response serveRequest(Request request) {
            // some logic
            HeaderParameters headers = request.headers();
            Iterator<Pair<String,String>> iterator = headers.iterator();
            while(iterator.hasNext()) {
                Pair<String, String> nameValue = iterator.next();
                System.out.println(nameValue.first()+" "+nameValue.second());
            }

            Entity entity = request.entity();
            byte[] entityAsBytes = entity.asBytes();
            String entityAsString = entity.toString();
            System.out.println(request.toString());
              return ResponseBuilder.response(Status.OK)
                      .header("CustomHeader", "value")
                      .entity("entity").build();

        }

    Map<String,Article> newsRepository;
    @GET
    @Path("/list")
    public Model newsInCategory(@QueryParam("category") @DefaultValue("politics") String category) {

        Article a1 = new Article();
        a1.setName("firtst");
        Article a2 =  new Article();
        a2.setName("senoicd");
        List<Article> news = new LinkedList<Article>();
        news.add(a1);
        news.add(a2);
        // newsRepository.get(category);
        return Model.model().add("news", news);
    }
   }
