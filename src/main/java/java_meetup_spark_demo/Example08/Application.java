package java_meetup_spark_demo.Example08;

import org.picocontainer.DefaultPicoContainer;
import spark.servlet.SparkApplication;

import javax.naming.ConfigurationException;

import static java_meetup_spark_demo.Example08.Router.*;

public class Application implements SparkApplication
{
    private final DefaultPicoContainer appContainer;

    public Application() throws ConfigurationException
    {
        appContainer = new DefaultPicoContainer();

        ContainerComposer.composeApplication(appContainer);
    }

    @Override
    public void init()
    {
        route("/login").to(LoginController.class, usingContainer(appContainer), renderedWith("login.vm"));
        route("/foo").to(FooController.class, usingContainer(appContainer), renderedWith("foo.vm"));
    }
}
