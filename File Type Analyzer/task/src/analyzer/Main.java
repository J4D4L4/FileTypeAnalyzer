package analyzer;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FileReaderLocal fileReader = new FileReaderLocal();
        fileReader.readPatternFile("D:\\Dev\\File Type Analyzer\\File Type Analyzer\\task\\src\\analyzer\\test.db");

        analyseFolderStructureForPatternDB(args[0], args[1]);



    }

    public static void analyseFolderStructure(String filePathIn, String pattern, String message) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        String [] listOfFiles = Arrays.stream(new File(filePathIn).listFiles()).map(file -> file.getPath()).toArray(String[]::new);
        for(String filePath : listOfFiles){
            Future<String> returnString = executor.submit(WorkerAnalysis.getCallable(filePath,pattern, message));
            String toPrint = returnString.get();
            System.out.println(toPrint);
        }


    }

    public static void analyseFolderStructureForPatternDB(String filePathIn, String patternPath) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        String [] listOfFiles = Arrays.stream(new File(filePathIn).listFiles()).map(file -> file.getPath()).toArray(String[]::new);

        FileReaderLocal fileReader = new FileReaderLocal();
        FilePattern[] patterns = fileReader.readPatternFile(patternPath).toArray(FilePattern[]::new);

        for(String filePath : listOfFiles){
            Future<String> returnString = executor.submit(WorkerAnalysis.getCallablefoMultiPatterns(filePath,patterns,""));
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
