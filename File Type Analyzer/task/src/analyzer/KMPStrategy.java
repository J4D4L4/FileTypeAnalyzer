package analyzer;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class KMPStrategy implements AnalyseStrategy{
    @Override
    public String analyse(String path, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern = KMPAlgorithmMatcher.KMPSearch(pattern,fileReader.readFile(path));
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            return new File(path).getName()+": "+resultString;

        }
        else
            return new File(path).getName()+": Unknown file type";
    }


}
