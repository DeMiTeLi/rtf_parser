package by.demiteli.parser;

import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public class Start {
    public static void main(String[] args) throws IOException {

        TextBasisBuilder textBasisBuilder = new TextBasisBuilder();
        textBasisBuilder.readRTF();

        ParserToTXT parserToTxt = new ParserToTXT();
        parserToTxt.parseMethod(RtfSingleton.getInstance().rtfBasicText);

        ParserToHTML parserToHTML = new ParserToHTML();
        parserToHTML.parseMethod(RtfSingleton.getInstance().rtfBasicText);

        DAO dao = new DAOImpl();
        dao.write("c:\\Test.html", parserToHTML.finalHTML);
        dao.write("c:\\Test.txt", parserToTxt.finalText);
    }
}
