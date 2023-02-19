package analyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class fileReader {


    public static String readFile(String filePath) {


        String inputFile = filePath;


        try {
            FileInputStream inputStream = new FileInputStream(inputFile);

            return getFileContent(inputStream, StandardCharsets.UTF_8.name());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
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

}


