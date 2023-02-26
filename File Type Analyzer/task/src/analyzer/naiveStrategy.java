package analyzer;

import java.time.LocalDateTime;

public class naiveStrategy implements AnalyseStrategy{
    @Override
    public String analyse(String filePath, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern =PatternMatcher.regexContainsPattern(FileReaderLocal.readFile(filePath),pattern);
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            return resultString;

        }
        else
            return "Unknown file type";

    }

    @Override
    public String analyse(String path, FilePattern[] patterns, String resultString) {
        return null;
    }

}
