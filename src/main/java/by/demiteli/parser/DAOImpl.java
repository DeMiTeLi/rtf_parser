package by.demiteli.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public class DAOImpl implements DAO {
    @Override
    public void write(String url, StringBuilder writedFile) throws IOException {

        File file = new File(url);
        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.append(writedFile);

        bufferedWriter.close();

    }
}
