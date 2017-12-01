import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Post {
    public static void main(String args[]){
        String completeUrl="https://docs.google.com/spreadsheets/d/1Q3cVus50o_crcOzYLmXX1bpBI_QeE1yII5BWqOYV2P8/edit#gid=0";
        String body="{\n" +
                "  \"range\": \"Sheet1!A1:D5\",\n" +
                "  \"majorDimension\": \"ROWS\",\n" +
                "  \"values\": [\n" +
                "    [\"Item\", \"Cost\", \"Stocked\", \"Ship Date\"],\n" +
                "    [\"Wheel\", \"$20.50\", \"4\", \"3/1/2016\"],\n" +
                "    [\"Door\", \"$15\", \"2\", \"3/15/2016\"],\n" +
                "    [\"Engine\", \"$100\", \"1\", \"30/20/2016\"],\n" +
                "    [\"Totals\", \"=SUM(B2:B4)\", \"=SUM(C2:C4)\", \"=MAX(D2:D4)\"]\n" +
                "  ],\n" +
                "}";
        post(completeUrl,body);
    }
    public static void post(String completeUrl, String body) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(completeUrl);
        httpPost.setHeader("Content-type", "application/json");
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);

            httpClient.execute(httpPost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
