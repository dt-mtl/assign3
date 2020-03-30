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
                readBiblios[i]=Biblio.readLines(references,i);

                System.out.println("made this many articles: "+readBiblios[i].getArticlesAmount());
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
