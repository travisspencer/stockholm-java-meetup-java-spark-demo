/*
 * Copyright (C) 2014 Twobo Technologies AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
