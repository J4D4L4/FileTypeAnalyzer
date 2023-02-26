package analyzer;

import java.io.File;
import java.time.LocalDateTime;

public class KMPStrategy implements AnalyseStrategy{
    @Override
    public String analyse(String path, String pattern, String resultString) {
        LocalDateTime startTime = LocalDateTime.now();
        boolean foundPattern = KMPAlgorithmMatcher.KMPSearch(pattern, FileReaderLocal.readFile(path));
        LocalDateTime endTime = LocalDateTime.now();
        if (foundPattern) {
            return new File(path).getName()+": "+resultString;

        }
        else
            return new File(path).getName()+": Unknown file type";
    }

    @Override
    public String analyse(String path, FilePattern[] patterns, String resultString) {
        boolean foundPattern = false;
        int highestPrio = 0;
        String result = "Unknown file type";
        for (FilePattern pattern : patterns){
            if(KMPAlgorithmMatcher.KMPSearch(pattern.pattern, FileReaderLocal.readFile(path))){
                if(highestPrio < pattern.prio){
                    highestPrio = pattern.prio;
                    result = pattern.message;
                }
            }
        }
        return new File(path).getName()+": "+result;
    }


}
