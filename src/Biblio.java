import java.util.ArrayList;
import java.util.

public class Biblio {
    //attributes
    protected int numArticles;
    protected Article[] articles=new Article[numArticles];

    //Constructor
    public Biblio(){

    }


    //mutator

    public void setAmount(int amount) {
        numArticles = amount;
    }
}
