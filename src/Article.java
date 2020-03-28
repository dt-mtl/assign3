public class Article {

    //attributes of an Article
    protected String author;
    protected String journal;
    protected  String title;
    protected Integer year;
    protected String volume;
    protected Integer number;
    protected String pages;
    protected String keywords;
    protected String doi;
    protected String issn;
    protected String month;

    static int amountArticles=0;

    {
        amountArticles +=1;
    }

    //constructor for a single article
    public Article(String a,String j,String t,Integer y,String v,Integer n,String p,String k,String d,String i,String m) throws FileInvalidException {
        if (a == null || j == null || t == null || y == null || v == null || n == null || p == null || k == null || d == null || i == null || m == null){
            throw new FileInvalidException(); // should the article be invalid it will output the default message
        }else{
            author=a;
            journal=j;
            title=t;
            year=y;
            volume=v;
            number=n;
            pages=p;
            keywords=k;
            doi=d;
            issn=i;
            month=m;
            }
        }

    //acccessor
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDoi() {
        return doi;
    }

    public String getIssn() {
        return issn;
    }

    public Integer getYear() {
        return year;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getMonth() {
        return month;
    }

    public String getPages() {
        return pages;
    }

    public String getVolume() {
        return volume;
    }

    public String getJournal() {
        return journal;
    }
    //accessor for number of articles total
    public static int getAmountArticles() {
        return amountArticles;
    }
}
