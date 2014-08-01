/*
* In this class going directly format an intermediate text (basisText) from original rtf file.
* */
package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class ControlWordsHandler {

    static StringBuilder basicText = new StringBuilder();

    private int boldHandler(char[] chars, int i) {

        basicText.append("\\b ");
        String plainWord = "";
        while (chars[i] != ' ') i++;
        i++;
        while (chars[i] != '}' && i < chars.length) {
            plainWord = plainWord + chars[i];
            i++;
        }
        basicText.append(plainWord);
        basicText.append(" \\b");

        return i;
    }

    private int italicHandler(char[] chars, int i) {

        basicText.append("\\i ");
        String plainWord = "";
        while (chars[i] != ' ') i++;
        i++;
        while (chars[i] != '}' && i < chars.length) {
            plainWord = plainWord + chars[i];
            i++;
        }
        basicText.append(plainWord);
        basicText.append(" \\i");

        return i;
    }

    private int underlineHandler(char[] chars, int i) {

        basicText.append("\\u ");
        String plainWord = "";
        while (chars[i] != ' ') i++;
        i++;
        while (chars[i] != '}' && i < chars.length) {
            plainWord = plainWord + chars[i];
            i++;
        }
        basicText.append(plainWord);
        basicText.append(" \\u");

        return i;
    }

    private int textHandler(char[] chars, int i) {

        String plainWord = "";
        while (chars[i] != ' ') i++;
        i++;
        while (i < chars.length && chars[i] != '}') {
            plainWord = plainWord + chars[i];
            i++;
        }
        basicText.append(plainWord);

        return i;
    }

    private int paragraphHandler(char[] chars, int i) {

        String plainWord = "";
        i++;
        while (chars[i] != '}' && i < chars.length) {
            plainWord = plainWord + chars[i];
            i++;
        }
        if (plainWord == " ")
            basicText.append("\\par ");
        else {
            basicText.append("\\par ");
            basicText.append(plainWord);
        }

        return i;
    }

    public static int mainHandler(String s, char[] chars, int i) {

        ControlWordsHandler controlWordsHandler = new ControlWordsHandler();

        if (s.equals("b")) return controlWordsHandler.boldHandler(chars, i);
        if (s.equals("i")) return controlWordsHandler.italicHandler(chars, i);
        if (s.equals("ul")) return controlWordsHandler.underlineHandler(chars, i);
        if (s.equals("par")) return controlWordsHandler.paragraphHandler(chars, i);
        if (s.equals("insrsid")) return controlWordsHandler.textHandler(chars, i);
        else

            return 0;
    }

    public static StringBuilder getTextBasis(){
        return basicText;
    }

}
