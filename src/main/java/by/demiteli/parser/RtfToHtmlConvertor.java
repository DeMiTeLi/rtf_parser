package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class RtfToHtmlConvertor extends SimpleParser {

    private StringBuilder textBasis;

    public RtfToHtmlConvertor(StringBuilder textBasis) {

        this.textBasis = textBasis;
    }

    StringBuilder finalHTML = new StringBuilder();

    @Override
    public void parse() {


        StringBuilder paramWord = new StringBuilder();

        int italicNumber = 0,
                boldNumber = 0,
                underlineNumber = 0,
                paragraphNumber = 0;

        finalHTML.append("<html>\n<body>\n\n");

        for (int i = 0; i < textBasis.length(); i++) {
            char character = textBasis.charAt(i);
            if (character == '\\') {
                while (textBasis.charAt(i) != ' ') {
                    paramWord.append(textBasis.charAt(i));
                    i++;
                }

                String stringParamWord = paramWord.toString();

                if (stringParamWord.equals("\\rquote")) {
                    finalHTML.append("'");
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (stringParamWord.equals("\\par")) {
                    paragraphNumber++;
                    if (paragraphNumber % 2 == 0) {
                        finalHTML.append("</p>");
                        finalHTML.append('\n');
                        finalHTML.append("<p> ");
                    } else {
                        finalHTML.append('\n');
                        finalHTML.append("<p> ");
                    }

                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (stringParamWord.equals("\\i")) {
                    italicNumber++;
                    if (italicNumber % 2 != 0)
                        finalHTML.append("<i> ");
                    else finalHTML.append("</i> ");
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (stringParamWord.equals("\\b")) {
                    boldNumber++;
                    if (boldNumber % 2 != 0)
                        finalHTML.append("<b> ");
                    else finalHTML.append("</b> ");
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
                if (stringParamWord.equals("\\ul")) {
                    underlineNumber++;
                    if (underlineNumber % 2 != 0)
                        finalHTML.append("<ul>");
                    else finalHTML.append("</ul>");
                    paramWord.delete(0, paramWord.length());
                    continue;
                }
            } else

                finalHTML.append(character);

        }
        if (paragraphNumber > 0) finalHTML.append(" </p>");
        finalHTML.append("\n\n</body>\n</html>");

    }

    public StringBuilder getFinalHTML() {
        return finalHTML;
    }
}