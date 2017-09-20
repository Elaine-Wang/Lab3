import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Lab 3.
 *
 * @author Elaine
 * @version 20 September 2017
 */
public class StyleLab {

    /**
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int hamletWordCount = wordCount(hamlet);
        System.out.println("The number of words in Hamlet is " + hamletWordCount);
        System.out.println("Prince occurs " + oneWordCount(hamlet, "Prince") + " times");
    }

    /**
     * Counts the number of words in given string.
     *
     * @param text string to count words from
     * @return count number of words in text
     */
    public static int wordCount(final String text) {
        Scanner s = new Scanner(text);
        int count = 0;
        while (s.hasNext()) {
            s.next();
            count++;
        }
        s.close();
        return count;
    }

    /**
     * Counts the number of specific occurrences of target word.
     *
     * @param text the string to be counted from
     * @param target the word being counted
     * @return count the number of occurrences of target word
     */
    public static int oneWordCount(final String text, final String target) {
        Scanner s = new Scanner(text);
        int count = 0;
        while (s.hasNext()) {
            String next = s.next();
            if (next.equalsIgnoreCase(target) || next.equalsIgnoreCase(target + ",")) {
                count++;
            }
        }
        s.close();
        return count;
    }

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
}
