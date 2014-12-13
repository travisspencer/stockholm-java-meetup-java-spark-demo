package java_meetup_spark_demo;

import static spark.Spark.*;

public class Example06_JsonAcceptTypeExample
{
    public static void main(String args[])
    {
        get("/hello", "application/json", (request, response) -> {
            response.type("application/json");

            return "{\"message\": \"Hello World\"}";
        });
    }
}
