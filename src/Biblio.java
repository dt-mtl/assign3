import java.util.ArrayList;

import java.util.Scanner;

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
    //accessor
    public int getBibNumber() {
        return bibNumber;
    }
    public Article getArticle(int i){
        return articles.get(i);
    }

    //methods
    public int getArticlesAmount(){
        return articles.size();
    }
    public String toString() {
        return "Biblio ["+ bibNumber +"] articles=" + articles +
                '}';
    }
    //this program will read through the given line and extract the information for each field by only reading one bibliography
    public static Biblio readLines(Scanner r, int i){
        Biblio read=new Biblio(i);
        String author=null;
        String journal=null;
        String title=null;
        Integer year=null;
        String volume=null;
        Integer number=null;
        String pages=null;
        String keywords=null;
        String doi=null;
        String issn=null;
        String month=null;
        //variables that indicate if info was read
        boolean au=false,jo=false,ti=false,ye=false,vo=false,nu=false,pa=false,ke=false,di=false,si=false,mo=false;


        while(r.hasNext()) {
            String info = r.nextLine();

            if(info.contains("author")){
                au=true;
                if(info.contains("{}")){
                    author=null;
                }else {
                    author = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    // System.out.println("look its author: " + author);
                }
            }

            if(info.contains("journal")){
                jo=true;
                if(info.contains("{}")){
                    journal=null;
                }else {
                    journal = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its journal: " + journal);
                }
            }

            if(info.contains("title")){
                ti=true;
                if(info.contains("{}")){
                    title=null;
                }else {
                    title = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its title: " + title);
                }
            }
            if(info.contains("year")){
                ye=true;
                if(info.contains("{}")){
                    year=null;
                }else {
                    year = Integer.parseInt(info.substring(info.indexOf('{') + 1, info.indexOf('}')));
                    // System.out.println("look its year: " + year);
                }
            }
            if(info.contains("volume")){
                vo=true;
                if(info.contains("{}")){
                    volume=null;
                }else {
                    volume = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its volume: " + volume);
                }
            }
            if(info.contains("number")){
                nu=true;
                if(info.contains("{}")){
                    number=null;
                }else {
                    number = Integer.parseInt(info.substring(info.indexOf('{') + 1, info.indexOf('}')));
                    //System.out.println("look its number: " + number);
                }
            }
            if(info.contains("pages")){
                pa=true;
                if(info.contains("{}")){
                    pages=null;
                }else {
                    pages = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its pages: " + pages);
                }
            }
            if(info.contains("keywords")){
                ke=true;
                if(info.contains("{}")){
                    keywords=null;
                }else {
                    keywords = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its keywords: " + keywords);
                }
            }
            if(info.contains("doi")){
                di=true;
                if(info.contains("{}")){
                    doi=null;
                }else {
                    doi = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its doi: " + doi);
                }
            }
            if(info.contains("ISSN")){
                si=true;
                if(info.contains("{}")){
                    issn=null;
                }else {
                    issn = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its ISSN: " + issn);
                }
            }
            if(info.contains("month")){
                mo=true;
                if(info.contains("{}")){
                    month=null;
                }else {
                    month = info.substring(info.indexOf('{') + 1, info.indexOf('}'));
                    //System.out.println("look its month: " + month + "\n\n");
                }
            }
            //this will make sure everytime an article is read it is added directly to the bibliography within which it corresponds
            if(au && jo && ti && ye && vo && nu && pa && ke && si && mo){
                Article subArt= null;
                try {                           //todo double check this particular exception!
                    subArt = new Article(author,journal,title,year,volume,number,pages,keywords,doi,issn,month);
                } catch (FileInvalidException e) {
                    e.printStackTrace();
                }
                read.addArticles(subArt);
                au=jo=ti=ye=vo=nu=pa=ke=si=mo=false;
            }

        }

        r.close();

        return read;
    }
}
