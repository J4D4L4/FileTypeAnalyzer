package analyzer;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        String [] listOfFiles = Arrays.stream(new File(args[0]).listFiles()).map(file -> file.getPath()).toArray(String[]::new);
        for(String filePath : listOfFiles){
            Future<String> returnString = executor.submit(WorkerAnalysis.getCallable(filePath,args[1], args[2]));
            String toPrint = returnString.get();
            System.out.println(toPrint);
        }







    }

    public static void interpretCommands(String input[]){

        String algorithmStrategy= input[0].replace("--","");
        String fileName = input[1];
        String pattern = input[2].replace("\"","");
        String result = input[3].replace("\"","");

        StrategyExecutor strategyExecutor = new StrategyExecutor();

        switch (algorithmStrategy){
            case "naive" :
                strategyExecutor.setAnalyseStrategy(new naiveStrategy());
                break;
            case "KMP" :
                strategyExecutor.setAnalyseStrategy(new KMPStrategy());
                break;
            default:
                break;


        }
        strategyExecutor.analyse(fileName,pattern,result);

    }


}
