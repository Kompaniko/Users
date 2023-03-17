package org.example;
import io.restassured.RestAssured;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.File;
import java.util.Arrays;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class User implements RandomNameGenerator {

    public void createNewUser(String email, String firstName) {

        String password = "stepanandreevichqwerty";
        String birthday = "12";

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest/doregister";

        String jsonUserInfo = "{\"email\":\"" + email + "\", \"name\":\"" + firstName + "\", " +
                "\"password\":\"" +  password + "\", \"birthday\":\"" + birthday +"\"}";

        given()
                .header("Content-type", "application/json")
                .body(jsonUserInfo)
                .post(baseURI)
                .then().statusCode(200)
                .log().body();
    }
    public void addNewAvatar(String email) {

        baseURI = "http://users.bugred.ru/tasks/rest/addavatar";

        File fileAvatar = new File("/Users/nikita/Downloads/256x256bb.jpg");

        given()
                .multiPart("avatar", fileAvatar, "256x256bb.jpg")
                .formParam("email", email)
                .when()
                .post(baseURI)
                .then()
                .statusCode(200)
                .log().body();

    }
    public void deleteAvatar(String email ){
        baseURI = "http://users.bugred.ru/tasks/rest/deleteavatar";

        given()
                .formParam("email", email)
                .when()
                .post(baseURI)
                .then()
                .statusCode(200)
                .log().body();
    }
    public void createUserWithTasks(String email, String name, String task, String taskTwo){

        Random random = new Random();
        String randomStr = "";
        while (randomStr.length() < 12){
            randomStr +=(char) (random.nextInt(13) + 'a');
        }
        Random random1 = new Random();
        String randomInfoUsers = "";
        while (randomInfoUsers.length() <= 12){
            randomInfoUsers += (char) (random1.nextInt(13) + 'e');
        }
        JSONObject jsonUserInfo = new JSONObject();
        jsonUserInfo.put("email", email + "@gmail.com");
        jsonUserInfo.put("name", "User " + name);

        JSONArray tasksArray = new JSONArray();
        JSONObject task1 = new JSONObject();
        task1.put("title", task);
        task1.put("description", "Первая задача 111");
        JSONObject task2 = new JSONObject();
        task2.put("title", taskTwo);
        task2.put("description", "Вторая задача 111");
        tasksArray.add(task1);
        tasksArray.add(task2);
        jsonUserInfo.put("tasks", tasksArray);

        JSONArray companiesArray = new JSONArray();
        companiesArray.add(19);
        companiesArray.add(20);
        jsonUserInfo.put("companies", companiesArray);

        jsonUserInfo.put("hobby", randomInfoUsers);
        jsonUserInfo.put("adres", randomInfoUsers);
        jsonUserInfo.put("name1", randomInfoUsers);
        jsonUserInfo.put("surname1", randomInfoUsers);
        jsonUserInfo.put("fathername1", randomInfoUsers);
        jsonUserInfo.put("cat", randomInfoUsers);
        jsonUserInfo.put("dog", randomInfoUsers);
        jsonUserInfo.put("parrot", randomInfoUsers);
        jsonUserInfo.put("cavy", randomInfoUsers);
        jsonUserInfo.put("hamster", randomInfoUsers);
        jsonUserInfo.put("squirrel", randomInfoUsers);
        jsonUserInfo.put("phone", randomInfoUsers);
        jsonUserInfo.put("inn", "123456789012");
        jsonUserInfo.put("gender", "m");
        jsonUserInfo.put("birthday", "01.01.1900");
        jsonUserInfo.put("date_start", "11.11.2000");

        String jsonString = jsonUserInfo.toString();
        baseURI = "http://users.bugred.ru/tasks/rest/createuserwithtasks";

        given()
                .header("Content-type", "application/json")
                .body(jsonString)
                .post(baseURI)
                .then().statusCode(200)
                .log().body();
    }
    public void createNewCompany(String company_name, String company_type, String email_owner, String company_users){
//        String company_name = "Рога и копыта";
//        String company_type = "ОАО";
//        String email_owner = "Nikko@gmail.com";
//        String[] company_users = {"stepanandreevic@hqwerty","nmalwe@ya.ru"};

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest/createcompany";

        JSONArray jsonCompanyUsers = new JSONArray();
        jsonCompanyUsers.addAll(Arrays.asList(company_users));

        JSONObject jsonUserInfo = new JSONObject();
        jsonUserInfo.put("company_name", company_name);
        jsonUserInfo.put("company_type", company_type);
        jsonUserInfo.put("company_users", jsonCompanyUsers);
        jsonUserInfo.put("email_owner", email_owner);

        given()
                .header("Content-type", "application/json")
                .body(jsonUserInfo.toJSONString())
                .post(baseURI)
                .then().statusCode(200)
                .log().body();
    }
}

