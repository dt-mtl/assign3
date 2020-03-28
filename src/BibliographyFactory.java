import java.io.*;
import java.util.Scanner;
public class BibliographyFactory {

    public static void main(String[] args){
        boolean present=true;
        int i=1;
        Biblio[] readBiblios=new Biblio[10];

        System.out.println("Welcome to Bibliography Factory!\n");

        //check how many files are present
        Scanner references = null;
        //read and validate that all 10 files are valid and present
        while(present&& i<=10) {  //TODO while loop begins

            try{
                references = new Scanner(new File("src/Latex"+i+".bib"));
                System.out.println("Number of articles in Latex"+i+".bib file: "+readArticles(references));
                readBiblios[i]=readLines(references,i,readBiblios[i]);

                System.out.println(i);

                i++;
            }catch(Exception e){
                System.out.println("Could not open input file Latex"+i+".bib for reading.");
                present=false;
                System.out.println("\nPlease check if file exists! Program will terminate after closing any opened files.");
            }

        }         //TODO while loop ends here
        references.close();
    }

    public static Biblio readLines(Scanner r,int i,Biblio read){
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
       while(r.hasNext()){
           String info=r.nextLine();
           if(info.contains("@ARTICLE")){
               info=r.nextLine();
               while(!info.contains('}'){
                    if info.contentEquals("author"){

                   }else
               }

           }
       }
        return read;
    }

    public static int readArticles(Scanner r){
        int totalArticles=0;
        while(r.hasNext()){
            String info= r.nextLine();
            if(info.contains("@ARTICLE")){
                totalArticles+=1;
            }
        }
        return totalArticles;
    }




}
