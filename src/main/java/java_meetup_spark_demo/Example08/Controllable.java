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

import spark.Request;
import spark.Response;

import java.util.Map;

@SuppressWarnings("unused")
interface Controllable
{
    default boolean before(Request request, Response response) { return true; }

    default boolean get(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean post(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean put(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean delete(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean patch(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean head(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean trace(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean connect(Request request, Response response, final Map<String, Object> model) { return true; }

    default boolean options(Request request, Response response, final Map<String, Object> model) { return true; }

    default void after(Request request, Response response) { }
}
