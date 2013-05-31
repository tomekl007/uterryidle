import com.googlecode.utterlyidle.Renderer;

public class PrintfRenderer implements Renderer<MyResourceReturnType> {
    public String render(MyResourceReturnType value) throws Exception {
        return String.format("--- %s --- %s ---", value.getRequestScope(), value.getApplicationScope());
    }
}