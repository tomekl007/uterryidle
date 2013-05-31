public class MyResourceReturnType {
    private String requestScope;
    private String applicationScope;


    public String getRequestScope() {
        return requestScope;
    }

    public String getApplicationScope() {
        return applicationScope;
    }

    public MyResourceReturnType(String requestScope, String applicationScope) {
        this.requestScope = requestScope;
        this.applicationScope = applicationScope;
    }

    @Override
    public String toString() {
        return  requestScope + " " + applicationScope;
    }
}