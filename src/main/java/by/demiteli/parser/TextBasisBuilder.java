package by.demiteli.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Dzmitry Varabei
 */
public class TextBasisBuilder {

    public void readRTF() throws FileNotFoundException {

        TextBasisBuilder p = new TextBasisBuilder();
        FileReader rtfReader = new FileReader("c:\\Hi.rtf");
        BufferedReader bufferedRTFReader = new BufferedReader(rtfReader);
        try {
            while (true) {

                String line = bufferedRTFReader.readLine();
                if (line == null) break;
                p.isolationPlainText(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void isolationPlainText(String line){

        String controlWord = "";
        int i=0;
        char[] chars = line.toCharArray();

        while ( i<chars.length) {
             if (chars[i] == '\\') {
                i++;
                    while (chars[i]!='\\' && chars[i]!=' '){
                    controlWord = controlWord + chars[i];
                    i++;
                    }

                if (controlWord.indexOf("insrsid",0)!=-1){

                    i = HandlerOfControlWords.mainHandler("insrsid", chars, i);

                } else
                     if (controlWord.equals("par")){

                         i = HandlerOfControlWords.mainHandler("par", chars, i);

                     }else
                        if (controlWord.equals("i"))
                            i = HandlerOfControlWords.mainHandler("i", chars, i);
                        else
                            if (controlWord.equals("b"))
                                i = HandlerOfControlWords.mainHandler("b", chars, i);
                controlWord = "";

            }else i++;
        }
    }

}
