[//]: # Copyright (C) 2014 Twobo Technologies AB
[//]: # 
[//]: # Licensed under the Apache License, Version 2.0 (the "License");
[//]: # you may not use this file except in compliance with the License.
[//]: # You may obtain a copy of the License at
[//]: # 
[//]: # http://www.apache.org/licenses/LICENSE-2.0
[//]: # 
[//]: # Unless required by applicable law or agreed to in writing, software
[//]: # distributed under the License is distributed on an "AS IS" BASIS,
[//]: # WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
[//]: # See the License for the specific language governing permissions and
[//]: # limitations under the License.

# Stockholm Java User Group Meeting Demo Files

> This repository contains the code samples used during the presentation given by [Travis Spencer][travis] to the Stockholm Java user group meeting on December 11, 2014.

## Simple Examples

The simples examples (1 -7) are all in seperate Java files. To test them, do the following:

1. Build the code (`mvn package`).
2. Execute the example (e.g., `java java_meetup_spark_demo.Example01_Hello_World`); this will start the Web API.
3. Run the corresponding script (e.g., `scripts/Example01_Hello_World`) which will curl a request to the API.

All of these simple examples are [based on the ones distributed with Spark][spark].

## More Complex Example

In the Example08 source directory, you will find an example that adds some useful functionality on top of Spark:

* Pico container integration, including hierarchical dependency resolution 
* Simplified programming model for creating controllers
* Syntactic sugar to beautify Spark's syntax for defining routes

### Pico Integration

The Pico integration is handled in the `Application` class. On application startup, session creation, and request initiation, the `ContainerComposer`'s respective static methods will be called to wire-up any app-, session-, and request-level dependencies. These will be passed on to the controllers and other objects.

### Controllers

A controller is a class that implements the `Controllable` interface. This interface defines all the methods that a Web API might want to respond to (e.g., `get`, `post`, etc.). This interface uses Java 8's new `default` keyword on *all* of these methods, effectively making it an abstract class rather than an interface. Consequently, a controller only needs to override the methods it wishes to handle; the others will not be routed. For each method that is overloaded, the `Router` (a derivative of Spark's router) will reflectively wire-up the overload to the given endpoint. 

The net effect is that message handling for an endpoint is packaged up in a Controller class (e.g., see `FooController` below), and the routes are kept together in the microservice's `Application` class.

## Examples of an Application and a Controller

### Application Example

```
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
        // Etc.
    }
}
```

### Controller Example

```
public class FooController implements Controllable
{
    @Override
    public boolean before(Request request, Response response)
    {
        if (request.session(false) == null)
        {
            response.redirect("/login");

            return false;
        }

        return true;
    }

    @Override
    public boolean get(Request request, Response response, final Map<String, Object> model)
    {
        Map<String, String> data = new HashMap<>();

        data.put("e1", "e1 value");
        data.put("e2", "e2 value");
        data.put("e3", "e3 value");

        model.put("user", "tspencer");
        model.put("data", data);

        return true;
    }
}
```

## More Information

For more information, check out the [Spark home page][spark-home-page] and read through [the documentation][spark-docs]. For questions or info on these examples or the micro-micro framework in Example08, contract [Travis Spencer][travis].

[spark]: https://github.com/perwendel/spark
[spark-home-page]: http://sparkjava.com/
[spark-docs]: http://sparkjava.com/documentation.html
[travis]: http://travisspencer.com/contact-me.html