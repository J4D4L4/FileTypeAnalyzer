package analyzer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class KMPStrategy implements AnalyseStrategy{
    @Override
    public void analyse(String path, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern = KMPAlgorithmMatcher.KMPSearch(pattern,fileReader.readFile(path));
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            System.out.println(resultString);

        }
        else
            System.out.println("Unknown file type");
        System.out.println("It took" + (endTime.toEpochSecond(ZoneOffset.UTC)-startTime.toEpochSecond(ZoneOffset.UTC)) +" seconds");
    }


}
