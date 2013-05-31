package customer;

import com.googlecode.utterlyidle.FormParameters;

import java.util.concurrent.Callable;

public class CustomerActivator implements Callable<Customer> {

    private FormParameters formParameters;

    public CustomerActivator(FormParameters formParameters) {
        this.formParameters = formParameters;
    }

    public Customer call() throws Exception {
        // convert form parameters to customer object
        return new Customer();
    }
}