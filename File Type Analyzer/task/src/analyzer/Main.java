package analyzer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        interpretCommands(args);



    }

    public static void interpretCommands(String input[]){

        String algorithmStrategy= input[0].replace("--","");
        String fileName = input[0];
        String pattern = input[1].replace("\"","");
        String result = input[2].replace("\"","");

        StrategyExecutor strategyExecutor = new StrategyExecutor();

        switch (algorithmStrategy){
            case "naive" :
                strategyExecutor.setAnalyseStrategy(new naiveStrategy());
            case "KMP " :
                strategyExecutor.setAnalyseStrategy(new KMPStrategy());

        }
        strategyExecutor.analyse(fileName,pattern,result);

    }


}
