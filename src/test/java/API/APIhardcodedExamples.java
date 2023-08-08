package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APIhardcodedExamples {
    // Set base URI

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    // token
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTExMDY1NjcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MTE0OTc2NywidXNlcklkIjoiNTc2NiJ9.aZG0rAZHOGD3n5tDn6wBPPdtKjEEbzvQwEZoNDSBYfA";


    @Test
    public void createEmployee(){
        // prepare the request

        RequestSpecification request = given().header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"nina\",\n" +
                        "  \"emp_lastname\": \"Sara\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1995-07-23\",\n" +
                        "  \"emp_status\": \"married\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");

        // send the request

        Response response= request.when().post("/createEmployee.php");
        response.prettyPrint();

        // extract the employee_id
        String employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // assertions
        // the employee status is married

        String status = response.jsonPath().getString("Employee.emp_status");
        Assert.assertEquals("married", status);

    }
}
