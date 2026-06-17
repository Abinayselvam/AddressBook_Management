package Services;

import io.restassured.RestAssured;

public class AddressBookRestService {

    public void getContacts() {

        RestAssured
                .given()
                .when()
                .get("http://localhost:3000/contacts")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    public void addContact() {

        String jsonBody =
                "{"
                        + "\"firstName\":\"Bill\","
                        + "\"lastName\":\"Gates\","
                        + "\"city\":\"Chennai\","
                        + "\"state\":\"Tamil Nadu\","
                        + "\"phoneNumber\":\"9876543210\","
                        + "\"email\":\"bill@gmail.com\""
                        + "}";

        RestAssured
                .given()
                .header(
                        "Content-Type",
                        "application/json"
                )
                .body(jsonBody)
                .when()
                .post("http://localhost:3000/contacts")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    public void updateContact() {

        String jsonBody =
                "{"
                        + "\"firstName\":\"Bill\","
                        + "\"lastName\":\"Gates\","
                        + "\"city\":\"Bangalore\","
                        + "\"state\":\"Karnataka\","
                        + "\"phoneNumber\":\"9999999999\","
                        + "\"email\":\"bill@gmail.com\""
                        + "}";

        RestAssured
                .given()
                .header(
                        "Content-Type",
                        "application/json"
                )
                .body(jsonBody)
                .when()
                .put("http://localhost:3000/contacts/1")
                .then()
                .statusCode(200);
    }
    public void deleteContact(int id) {

        RestAssured
                .given()
                .when()
                .delete(
                        "http://localhost:3000/contacts/" + id
                )
                .then()
                .statusCode(200);
    }
}