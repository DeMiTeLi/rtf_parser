/*
* This class is for convertion of text basis to txt file.
* */
package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class RtfToTxtConvertor extends SimpleParser {

    private StringBuilder textBasis;

    public RtfToTxtConvertor(StringBuilder textBasis) {

        this.textBasis = textBasis;
    }

    StringBuilder finalText = new StringBuilder();

    @Override
    public void parse() {

        StringBuilder paramWord = new StringBuilder();

        for (int i = 0; i < textBasis.length(); i++) {

            char character = textBasis.charAt(i);

            if (character == '\\') {

                while (textBasis.charAt(i) != ' ') {

                    paramWord.append(textBasis.charAt(i));
                    i++;
                }

                if (paramWord.toString().equals("\\rquote")) {
                    finalText.append("'");
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (paramWord.toString().equals("\\par")) {
                    finalText.append('\n');
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (paramWord.toString().equals("\\i") || paramWord.toString().equals("\\b"))
                    paramWord.delete(0, paramWord.length());
            } else

                finalText.append(character);

        }
    }

    public StringBuilder getFinalText() {
        return finalText;
    }
}
