package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class HandlerOfControlWords {

    static RtfSingleton text = RtfSingleton.getInstance();

    private int boldHandler(char[] chars, int i){

        text.addText("\\b ");
        String plainWord = "";
        while (chars[i]!=' ') i++;
        i++;
        while (chars[i]!='}' && i<chars.length) {plainWord = plainWord +  chars[i]; i++; }
        text.addText(plainWord);
        text.addText(" \\b");

        return i;
    }

    private int italicHandler(char[] chars, int i){

        text.addText("\\i ");
        String plainWord = "";
        while (chars[i]!=' ') i++;
        i++;
        while (chars[i]!='}' && i<chars.length) {plainWord = plainWord +  chars[i]; i++; }
        text.addText(plainWord);
        text.addText(" \\i");

        return i;
    }

    private int underlineHandler(char[] chars, int i){

        text.addText("\\ul ");
        String plainWord = "";
        while (chars[i]!=' ') i++;
        i++;
        while (chars[i]!='}' && i<chars.length) {plainWord = plainWord +  chars[i]; i++; }
        text.addText(plainWord);
        text.addText(" \\ul");

        return i;
    }

    private int textHandler(char[] chars, int i){

        String plainWord = "";
        while (chars[i]!=' ') i++;
        i++;
        while (i<chars.length  && chars[i]!='}'){
            plainWord = plainWord +  chars[i];
            i++;
        }
        text.addText(plainWord);

        return i;
    }

    private int paragraphHandler(char[] chars, int i){

        String plainWord = "";
        i++;
        while (chars[i]!='}' && i<chars.length){
            plainWord = plainWord +  chars[i];
            i++;
        }
        if (plainWord != ""){
            text.addText(" \\par ");
            text.addText(plainWord);
        }

       return i;
    }

    public static int mainHandler(String s, char[] chars, int i){

        HandlerOfControlWords handlerOfControlWords = new HandlerOfControlWords();

        if (s.equals("b")) return handlerOfControlWords.boldHandler(chars, i);
        if (s.equals("i")) return handlerOfControlWords.italicHandler(chars, i);
        if (s.equals("ul")) return handlerOfControlWords.underlineHandler(chars, i);
        if (s.equals("par")) return handlerOfControlWords.paragraphHandler(chars, i);
        if (s.equals("insrsid")) return handlerOfControlWords.textHandler(chars, i);
        else

            return 0;
    }

}