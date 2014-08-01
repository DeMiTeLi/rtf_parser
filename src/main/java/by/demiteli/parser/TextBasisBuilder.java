/*
* In this class going common process of original rtf file.
* */

package by.demiteli.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public class TextBasisBuilder {

    public static void readRTF(String url) throws IOException {

        FileReader rtfReader = new FileReader(url);
        BufferedReader bufferedRTFReader = new BufferedReader(rtfReader);
        try {
            while (true) {

                String line = bufferedRTFReader.readLine();
                if (line == null) break;
                isolatePlainText(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedRTFReader.close();
        }
    }

    public static void isolatePlainText(String line) {

        String controlWord = "";
        int i = 0;
        char[] chars = line.toCharArray();

        while (i < chars.length) {
            if (chars[i] == '\\') {
                i++;
                while (i < chars.length && (chars[i] != ' ' && chars[i] != '\\' && chars[i] != ';'  )) {
                    controlWord = controlWord + chars[i];
                    i++;
                }

                if (controlWord.indexOf("insrsid", 0) != -1) {
                    i = ControlWordsHandler.mainHandler("insrsid", chars, i);
                } else if (controlWord.equals("par")) {
                    i = ControlWordsHandler.mainHandler("par", chars, i);
                } else if (controlWord.equals("i"))
                    i = ControlWordsHandler.mainHandler("i", chars, i);
                else if (controlWord.equals("b"))
                    i = ControlWordsHandler.mainHandler("b", chars, i);
                controlWord = "";

            } else i++;
        }
    }

}

