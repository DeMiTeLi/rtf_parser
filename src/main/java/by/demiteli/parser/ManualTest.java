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

        RtfToTxtConvertor rtfToTxtConvertor = new RtfToTxtConvertor();
        rtfToTxtConvertor.parse(RtfSingleton.getInstance().getRtfBasicText());
        rtfToTxtConvertor.write(outputTxtFile, rtfToTxtConvertor.getFinalHTML());

        RtfToHtmlConvertor rtfToHtmlConvertor = new RtfToHtmlConvertor();
        rtfToHtmlConvertor.parse(RtfSingleton.getInstance().getRtfBasicText());
        rtfToHtmlConvertor.write(outputHtmlFile, rtfToHtmlConvertor.getFinalHTML());

    }
}
