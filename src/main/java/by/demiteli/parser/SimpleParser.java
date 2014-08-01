package by.demiteli.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public abstract class SimpleParser {

    public abstract void parse();

    public void write(String url, StringBuilder outputBuilder) throws IOException {

        File file = new File(url);
        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(outputBuilder);

        bufferedWriter.close();

        System.out.printf("File %s is sucesesfull created.\n", url);

    }
}
