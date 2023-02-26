package analyzer;

public class StrategyExecutor {

    private AnalyseStrategy analyseStrategy;

    public void setAnalyseStrategy(AnalyseStrategy analyseStrategy){
        this.analyseStrategy = analyseStrategy;
    }

    public String analyse(String path, String pattern, String result){
        return analyseStrategy.analyse(path,pattern,result);
    }

    public String analyse(String path, FilePattern[] pattern, String result){
        return analyseStrategy.analyse(path,pattern,result);
    }


}
