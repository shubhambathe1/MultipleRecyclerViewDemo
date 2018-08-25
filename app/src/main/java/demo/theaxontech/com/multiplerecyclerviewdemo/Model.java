package demo.theaxontech.com.multiplerecyclerviewdemo;

public class Model {

    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;
    public static final int AUDIO_TYPE=2;

    public int type;
    public int data;
    public String textHeader, textFooter;

    public Model(int type, String textHeader, String textFooter, int data)
    {
        this.type=type;
        this.data=data;
        this.textHeader = textHeader;
        this.textFooter = textFooter;
    }

}
