package by.demiteli.parser;

/**
 * @author Dzmitry Varabei
 */
public class RtfSingleton {

    private static RtfSingleton instance = null;
    StringBuilder rtfBasicText = null;

    public static RtfSingleton getInstance() {

    if(instance==null){
       instance = new RtfSingleton();
    }
       return instance;
}
    private RtfSingleton(){
    }

    public void addText(String word){

    if (rtfBasicText == null) {
        rtfBasicText = new StringBuilder();
}
    rtfBasicText.append(word);

    }

    public void printText(){

        System.out.println(rtfBasicText);
    }
}
