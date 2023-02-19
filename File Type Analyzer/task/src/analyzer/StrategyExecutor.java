package analyzer;

public class StrategyExecutor {

    private AnalyseStrategy analyseStrategy;

    public void setAnalyseStrategy(AnalyseStrategy analyseStrategy){
        this.analyseStrategy = analyseStrategy;
    }

    public void analyse(String path, String pattern, String result){
        analyseStrategy.analyse(path,pattern,result);
    }

}
