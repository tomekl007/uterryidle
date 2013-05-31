package customer;

import com.googlecode.utterlyidle.Response;
import com.googlecode.utterlyidle.ResponseBuilder;
import com.googlecode.utterlyidle.Status;
import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.POST;
import com.googlecode.utterlyidle.annotations.Path;
import com.googlecode.utterlyidle.annotations.QueryParam;


public class CustomerResource {

    private CustomerService service;

    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    public  CustomerResource(){}

    @POST
    @Path("/createCust")
    public Response create(Customer customer) {
        Customer createdCustomer = service.create(customer);
        return null;
    }

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("param") String param) {

        return ResponseBuilder.response(Status.OK).entity(param).build();

    }


    // resource methods
}