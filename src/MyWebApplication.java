import com.googlecode.utterlyidle.BasePath;
import com.googlecode.utterlyidle.RestApplication;

import static com.googlecode.utterlyidle.ApplicationBuilder.application;
import static com.googlecode.utterlyidle.ServerConfiguration.defaultConfiguration;

public class MyWebApplication extends RestApplication {
    public MyWebApplication(BasePath basePath) {
        super(basePath);
        add(new Feature1Module());
        add(new PropertiesModule());

    }

    public static void main(String[] args) {
        RestApplication myapp = new MyWebApplication(BasePath.basePath("/myapp"));
        application(myapp).start(defaultConfiguration().port(8000));
    }

}