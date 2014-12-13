package java_meetup_spark_demo.Example08;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

@SuppressWarnings("unused")
class ContainerComposer
{
    public static void composeApplication(DefaultPicoContainer appContainer)
    {
        appContainer.addComponent(FooController.class);
        appContainer.addComponent(LoginController.class);
    }

    public static void composeSession(MutablePicoContainer container) { }

    public static void composeRequest(MutablePicoContainer container) { }
}
