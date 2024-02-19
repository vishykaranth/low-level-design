package leetcode.backtracking;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

class URLEncodingExample {

    // Method to encode a leetcode.string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static void main(String[] args) {
        String baseUrl = "https://www.google.com/search?q=";

        String query = "Hellö Wörld@Java";
        String encodedQuery = encodeValue(query); // Encoding a query leetcode.string

        String completeUrl = baseUrl + encodedQuery;
        System.out.println(completeUrl);
    }
}