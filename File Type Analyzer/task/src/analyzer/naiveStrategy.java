package analyzer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class naiveStrategy implements AnalyseStrategy{
    @Override
    public void analyse(String filePath, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern =PatternMatcher.regexContainsPattern(fileReader.readFile(filePath),pattern);
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            System.out.println(resultString);

        }
        else
            System.out.println("Unknown file type");
        System.out.println("It took" + (endTime.toEpochSecond(ZoneOffset.UTC)-startTime.toEpochSecond(ZoneOffset.UTC)) +" seconds");
    }

}
