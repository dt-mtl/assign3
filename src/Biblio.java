import java.util.ArrayList;
import java.util.Arrays;

public class Biblio {
    //attributes
    private int bibNumber;
    private ArrayList<Article> articles;


    //Constructor
    //parameterised
    public Biblio(int a){
        bibNumber=a;
        this.articles=new ArrayList<Article>();
    }
    //mutator


    public void addArticles(Article a) {
        articles.add(a);
    }

    @Override
    public String toString() {
        return "Biblio ["+ bibNumber +"] articles=" + articles +
                '}';
    }
}
