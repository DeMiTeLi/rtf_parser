package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class RtfSingleton {

    private static RtfSingleton instance;
    StringBuilder rtfBasicText;

    public static RtfSingleton getInstance() {

        if (instance == null) {
            instance = new RtfSingleton();
        }
        return instance;
    }

    private RtfSingleton() {
    }

    public void addText(String word) {

        if (rtfBasicText == null) {
            rtfBasicText = new StringBuilder();
        }
        rtfBasicText.append(word);

    }

    public StringBuilder getRtfBasicText() {
        return rtfBasicText;

    }
}
