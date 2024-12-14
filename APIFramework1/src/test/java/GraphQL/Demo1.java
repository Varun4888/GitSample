package GraphQL;
import static io.restassured.RestAssured.given;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;

import io.restassured.path.json.JsonPath;

public class Demo1 {
	public static void main(String[] args) throws InterruptedException 
	
	{
//      WebDriver driver=new ChromeDriver();
//      driver.get("https://accounts.google.com/v3/signin/identifier?access_type=offline&client_id=587594460880-u53ikl5ast2sup28098ofsm9iku8vvm6.apps.googleusercontent.com&code_challenge=JxzSzDnqgHvaLxcv4wjI7_oN3AUqx3TqhTfmrYA8_bg&code_challenge_method=S256&include_granted_scopes=true&prompt=select_account%20consent&redirect_uri=https%3A%2F%2Fsso.teachable.com%2Fidentity%2Fcallbacks%2Fgoogle%2Fcallback&response_type=code&scope=email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile%20openid%20profile&state=eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJnb29nbGUiLCJpYXQiOjE3Mjg1NTc1MTIsImV4cCI6MTcyODU1OTMxMiwianRpIjoiYzliYTU5MDItNjBiMy00MzUxLWFkODQtYzA0ZjhhZjg5NzA0IiwiaXNzIjoic2tfeno4dHc2ZGciLCJzdWIiOiJEajhKTWprMUIzWEtNSF83YVB1ZVEwMHdiY0Q5eWotV2Zya2VudTRxWDgtOUI1R1NwM1BiSHRRRjlZODJ1Z2lkT3hPcUN6eTVyeVZ6VGtvYjdJN3V5QSJ9.7MdN-dTqtXVhOGMdYovzvQvgmpNxWyvb_MyvprbRC0k&service=lso&o2v=2&ddm=1&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAPh0jWgmc71SRTRx7XE4VhnrHsPfJBhEvlkmXn2lKQFENv3B1tSRaQw7Kj2O-IL5evmpYRqute43dOvn808eVfIEGDxwckIzmTecDQ3b65RyoMGnkVoZIX4LhrD0GQ1XGb39CG6b61Qmtnwo_oo0U_OZXcP92RnmQMdi470az6V8bAj3k7VmLLDWjgtS7X0PyWyhMu4A_ap9H4-EFzPOvY-XBGxkqNaPHS-2gVkWXsoQF0wcbiHexPEG1g8Msnoai54we-WeduDV-ZuGR6xR-41XCKG98-TUZRJukeds0A8NdwbP0adq9CTO7QzQ-4MjwCqQlFcMya4PJAgbVYck4gtq5a9kaBEwhhw2iqxAIihZzmX-PzFq4iLUNahUBtNpuNpHyyeVJfFLPA1s3RVi1qpsND6BqMz12wCfIJ3PRW0DE8d7dWh-dNfivZenQYU3ScJAh3fypNKDbp0kJ6f19kwlHiB6Q%26flowName%3DGeneralOAuthFlow%26as%3DS1210220051%253A1728557516038534%26client_id%3D587594460880-u53ikl5ast2sup28098ofsm9iku8vvm6.apps.googleusercontent.com%23");
//	  driver.findElement(By.xpath("//input[@type='email']")).
//	  sendKeys("bansode77210@gmail.com");
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//span[text()='Next']")).click();
//	  driver.findElement(By.xpath("//input[@type='password']")).
//	  sendKeys("varun@123");
//	  Thread.sleep(3000);
//	  String url = driver.getCurrentUrl();
	  
		String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
        String partialcode=url.split("code=")[1];
        String code=partialcode.split("&scope")[0];
        System.out.println(code);
        String response =given().urlEncodingEnabled(false).log().all()
        		.queryParams("code",code)
                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("grant_type", "authorization_code")
                .queryParams("state", "verifyfjdss")
                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

		// System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);
        String r2=given().contentType("application/json").
        		  queryParams("access_token", accessToken).expect()
        		  .when().get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(r2);
	  
	  
	  
		
	}

}
