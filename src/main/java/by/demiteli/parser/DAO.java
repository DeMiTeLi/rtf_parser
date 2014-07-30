package by.demiteli.parser;

import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public interface DAO {

    public void write(String url, StringBuilder file) throws IOException;
}
