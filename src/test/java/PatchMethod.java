import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import io.restassured.RestAssured;

public class PatchMethod {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
    RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
    .body(getFileContent("C:\\santra\\api testing\\API\\src\\test\\resources\\Patch.txt"))
    .header("Content-Type","application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
    .when().log().all().patch("/booking/650").then().log().all().assertThat().statusCode(200);
	}
public static String getFileContent(String filePath) throws FileNotFoundException {
	File file = new File(filePath);
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(file);
    sc.useDelimiter("\\Z");
    return sc.next();
}
	}


