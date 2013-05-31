package test;

import com.googlecode.utterlyidle.Response;
import com.googlecode.utterlyidle.ResponseBuilder;
import com.googlecode.utterlyidle.Status;
import customer.CustomerResource;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

public class HelloResourceTest {

    @Test
    public void getHello() {
        CustomerResource resource = new CustomerResource();


        Response response = resource.hello("test");

        assertEquals(ResponseBuilder.response(Status.OK).entity("test").build(), response);
    }
}