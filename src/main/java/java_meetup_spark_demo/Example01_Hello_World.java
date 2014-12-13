package java_meetup_spark_demo;

import static spark.Spark.*;

public class Example01_Hello_World
{
    public static void main(String[] args)
    {
        get("/hello", (request, response) -> "Hello World!");
    }
}
