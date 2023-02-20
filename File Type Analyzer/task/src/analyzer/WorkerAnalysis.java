package analyzer;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
public class WorkerAnalysis {

    public static Callable<String> getCallable (String filePath, String pattern, String returnMsg) {
        return () -> {
            return  interpretCommands(filePath,pattern,returnMsg);
        };


    }
    public static String interpretCommands(String fileName, String pattern, String returnMsg){
        StrategyExecutor strategyExecutor = new StrategyExecutor();
        strategyExecutor.setAnalyseStrategy(new KMPStrategy());
        return strategyExecutor.analyse(fileName,pattern,returnMsg);
    }

}
