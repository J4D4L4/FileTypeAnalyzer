package analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static boolean regexContainsPattern(String text, String pattern) {
        Pattern javaPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = javaPattern.matcher(text);
        return (matcher.find());
    }

}
