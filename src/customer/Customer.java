package customer;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 5/31/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return this.getName();
    }
}
