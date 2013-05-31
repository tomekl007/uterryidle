public class MyApplicationScopeObject {

    volatile int counter = 0;

    public String calculate() {
        return "application scope " + counter;
    }
}