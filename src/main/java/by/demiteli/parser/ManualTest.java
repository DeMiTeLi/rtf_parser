/*
* This class is for manual testing of application.
* */
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

        RtfToTxtConvertor rtfToTxtConvertor = new RtfToTxtConvertor(ControlWordsHandler.getTextBasis());
        rtfToTxtConvertor.parse();
        rtfToTxtConvertor.write(outputTxtFile, rtfToTxtConvertor.getFinalText());

        RtfToHtmlConvertor rtfToHtmlConvertor = new RtfToHtmlConvertor(ControlWordsHandler.getTextBasis());
        rtfToHtmlConvertor.parse();
        rtfToHtmlConvertor.write(outputHtmlFile, rtfToHtmlConvertor.getFinalHTML());

    }
}
