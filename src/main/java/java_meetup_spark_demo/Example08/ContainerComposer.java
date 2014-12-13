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
