import groovy.util.logging.Slf4j;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class currencyTest {
    @Test
    public void currencyTest(){

        /* TODO:
        1) get currency exchange rate USD to UAH for the 4 first days of 2022
        2) create a map in which key would be date and value - exchange rate
        3) find the minimum, maximum and the average rate for the given period
         */

        RequestSpecification requestSpecification = given()
                .spec(new RequestSpecBuilder()
                        .setUrlEncodingEnabled(false)
                        .addHeader("apikey", "hVIrBTvClCe85L86UNEZDTDrZIkzSHAb")
                        .build())
                .log().everything();

         Response response = requestSpecification.get("https://api.apilayer.com/currency_data/convert?to=UAH&from=USD&amount=1&date=2008-11-30")
                .then().extract().response();

         System.out.println(response.getBody().prettyPrint());



    }




}
