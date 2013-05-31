/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 5/31/13
 * Time: 7:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Article {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
