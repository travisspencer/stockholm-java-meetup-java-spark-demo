/*
 * Copyright (C) 2014 Twobo Technologies AB
 *
 * Copyright (C) 2011 Per Wendel
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

package java_meetup_spark_demo;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Example07_VelocityExample
{
    public static void main(String args[]) {

        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Map<String, String> data = new HashMap<>();

            data.put("message", "Hello Velocity World");
            data.put("att2", "Another attribute just to make sure it really works");

            model.put("data", data);
            model.put("title", "Example 07");

            return new ModelAndView(model, "hello.vm");
        }, new VelocityTemplateEngine());
    }
}
