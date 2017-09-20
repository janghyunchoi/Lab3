 import java.io.IOException;
    import java.net.URL;
    import java.util.Scanner;


public class Lab3 {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int count(String words, String substring) {
        int i;
        int last = 0;
        int count = 0;
        do {
            i = words.indexOf(substring, last);
            if (i != -1) count++;
            last = i+substring.length();
        } while(i != -1);
        return count;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String searchOfWord = "PRINCE";
        int i = 0;
        int count = 0;
        String contents = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String upperCase = contents.toUpperCase();
        System.out.println(count(upperCase, searchOfWord));
        }
}
