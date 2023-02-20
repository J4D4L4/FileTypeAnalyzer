package analyzer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class naiveStrategy implements AnalyseStrategy{
    @Override
    public String analyse(String filePath, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern =PatternMatcher.regexContainsPattern(fileReader.readFile(filePath),pattern);
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            return resultString;

        }
        else
            return "Unknown file type";

    }

}
