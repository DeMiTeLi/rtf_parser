package by.demiteli.parser;

import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public class ManualTest {
    public static void main(String[] args) throws IOException {

        String inputFileName = "c:\\Hi.rtf";
        String outputTxtFile = "c:\\Test.txt";
        String outputHtmlFile = "c:\\Test.html";

        TextBasisBuilder.readRTF(inputFileName);

        RtfToTxtConvertor rtfToTxtConvertor = new RtfToTxtConvertor(HandlerOfControlWords.getTextBasis());
        rtfToTxtConvertor.parse();
        rtfToTxtConvertor.write(outputTxtFile, rtfToTxtConvertor.getFinalText());

        RtfToHtmlConvertor rtfToHtmlConvertor = new RtfToHtmlConvertor(HandlerOfControlWords.getTextBasis());
        rtfToHtmlConvertor.parse();
        rtfToHtmlConvertor.write(outputHtmlFile, rtfToHtmlConvertor.getFinalHTML());

    }
}
