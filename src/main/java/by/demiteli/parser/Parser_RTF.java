package by.demiteli.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dzmitry Varabei
 */
public class Parser_RTF {

    public static List<String> readRTF() throws FileNotFoundException {

        List<String> rtfList = new ArrayList<String>();
        Parser_RTF p = new Parser_RTF();
        FileReader rtfReader = new FileReader("c:\\Hi.rtf");
        BufferedReader bufferedRTFReader = new BufferedReader(rtfReader);
        try {
            while (true) {
                String line = bufferedRTFReader.readLine();
                p.isolationPlainText(line);
                if (line == null) break;
                rtfList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rtfList;
    }

    public void isolationPlainText(String line){
        String controlWord = "";
        String plainText = "";

        char[] chars = line.toCharArray();

        for (int i=0; i<chars.length; i++) {

            if (chars[i] == '\\') {
i++;
                while (chars[i]!='\\' && chars[i]!=' '){

                controlWord = controlWord + chars[i];
                    i++;
            }

                if (controlWord.indexOf("insrsid",1)!=-1){

                    while (chars[i]!=' ') i++;

                    while (chars[i]!='}') {plainText = plainText +  chars[i]; i++; }


                }


        }

        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        List<String> rtfFile = Parser_RTF.readRTF();

        Iterator iterator = rtfFile.iterator();
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }
}
