package analyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReaderLocal {


    public static String readFile(String filePath) {


        String inputFile = filePath;


        try {
            FileInputStream inputStream = new FileInputStream(inputFile);

            return getFileContent(inputStream, StandardCharsets.UTF_8.name());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

    }




    public static String getFileContent(
            FileInputStream fis,
            String          encoding ) throws IOException
    {
        try( BufferedReader br =
                     new BufferedReader( new InputStreamReader(fis, encoding )))
        {
            StringBuilder sb = new StringBuilder();
            String line;
            while(( line = br.readLine()) != null ) {
                sb.append( line );
                sb.append( '\n' );
            }
            return sb.toString();
        }
    }

    public static List<FilePattern> readPatternFile(String filePath){

        String[] lines = readFile(filePath).split("\n");
        List<FilePattern> filePatterns = new ArrayList<>();

        for (String line : lines){
            String[] element = line.split(";");
            filePatterns.add(new FilePattern(Integer.parseInt(element[0]), element[1].replace("\"",""), element[2].replace("\"","")));
        }

        return filePatterns;

    }

}


