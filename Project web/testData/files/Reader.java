package testData.files;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Reader {

    public static JSONObject getUser(String userKey) {
        return readJson("src/testData/files/users.json", userKey);
    }

    public static JSONObject getProduct(String productKey) {
        return readJson("src/testData/files/products.json", productKey);
    }
    public static JSONObject getCheckoutUser(String checkoutkey) {
        return readJson("src/testData/files/checkout.json", checkoutkey);
    }

    private static JSONObject readJson(String filePath, String key) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            return (JSONObject) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrl() {
        return "https://www.saucedemo.com/";
    }
}
