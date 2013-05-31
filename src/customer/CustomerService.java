package customer;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 5/31/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerService {
    public Customer create(Customer customer) {
        System.out.println("customerService creating new Customer, getCustomer : "+customer  );
       return  new Customer();
    }
}
