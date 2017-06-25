package backend;

import static com.ssp.assigmnents.rest.ServiceEndpointConstants.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssp.assigmnents.SizeCalculatorApp;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SizeCalculatorApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SizeCalculatorTest {

	@LocalServerPort
	private int port;
	
	private RequestSpecification given() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		return RestAssured.given().log().ifValidationFails().port(port);
	}

	
	@Test
	public void testBrandsEndpoint() {
		given().when().get(String.format("%s", BRANDS_ENDPOINT)).then().statusCode(200);
	}
	@Test
	public void testCategoriesEndpoint() {
		given().when().get(String.format("%s?brand=calvin-klein", CATEGORIES_ENDPOINT)).then().statusCode(200);
	}
	
	@Test
	public void testPredictionEndpoint() {
		given().when().get(String.format("%s?brand=calvin-klein&category=dresses&measurement=32", PREDICTION_ENDPOINT)).then().statusCode(200);
	}
}
