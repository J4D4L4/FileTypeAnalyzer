package analyzer;

public interface AnalyseStrategy {

    String analyse(String path, String pattern, String resultString);
    String analyse(String path, FilePattern[] patterns, String resultString);

}
