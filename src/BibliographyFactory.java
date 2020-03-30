import java.io.*;
import java.util.Scanner;

public class BibliographyFactory {

    public static void main(String[] args){
        boolean present=true;
        int i=1;
        Biblio[] readBiblios=new Biblio[10];

        //populate the array so it isnt null todo double check this!
        for(int j=0;j<10;j++){
            readBiblios[j]=new Biblio(j);
        }
        

        System.out.println("Welcome to Bibliography Factory!\n");

        //check how many files are present
        Scanner references = null;
        //read and validate that all 10 files are valid and present
       while(present&& i<=10) {  //TODO while loop begins

            try{
                references = new Scanner(new File("src/Latex"+i+".bib")); //everytime you want to re read the file you have to renew it... weird
                System.out.println("Number of articles in Latex"+i+".bib file: "+readArticles(references)); //this checks how many articles are pressent in the bibliography
                System.out.println("reading through biblio: "+i);
                references = new Scanner(new File("src/Latex"+i+".bib"));
                readBiblios[i]=readLines(references,i);

                System.out.println("read through biblio: "+i);

                i++;
            }catch(Exception e){
                System.out.println("Could not open input file Latex"+i+".bib for reading.");
                present=false;
                System.out.println("\nPlease check if file exists! Program will terminate after closing any opened files.");
            }

        }         //TODO while loop ends here
        references.close();
    }

    //this program will read through the given line and extract the information for each field by only reading one bibliography
    public static Biblio readLines(Scanner r,int i){
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

    public static int readArticles(Scanner r){
        int totalArticles=0;
        while(r.hasNext()){
            String info= r.nextLine();
            //System.out.println(info);
            if(info.contains("@ARTICLE")){
                totalArticles+=1;
            }
        }
        return totalArticles;
    }




}
