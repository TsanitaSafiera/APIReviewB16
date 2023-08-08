package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"nina\",\n" +
                "  \"emp_lastname\": \"Sara\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1995-07-23\",\n" +
                "  \"emp_status\": \"married\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
        return  createEmployeePayload;
    }

    // create the payload in json format and return a string of payload
    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","justin");
        obj.put("emp_lastname","azzuri");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-07-21");
        obj.put("emp_status","happy");
        obj.put("emp_job_title","QA");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }

    public static String updateEmployeePartiallyPayload(String empID,String key,String value){
        JSONObject obj = new JSONObject();
        obj.put("employee_id",empID);
        obj.put(key, value);
        return obj.toString();
    }


}
