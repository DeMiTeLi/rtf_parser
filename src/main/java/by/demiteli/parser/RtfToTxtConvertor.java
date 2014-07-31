package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class RtfToTxtConvertor extends SimpleParser {

    StringBuilder finalText = new StringBuilder();

    @Override
    public void parse(StringBuilder textBasis) {

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

    public StringBuilder getFinalHTML() {
        return finalText;
    }
}
