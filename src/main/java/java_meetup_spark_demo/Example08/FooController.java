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

import java.util.HashMap;
import java.util.Map;

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
