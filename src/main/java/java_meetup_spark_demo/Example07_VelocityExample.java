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
