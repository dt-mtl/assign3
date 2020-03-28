public class FileInvalidException extends Exception{
    //constructors
    //default
    public FileInvalidException(){
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
    }
    //desired message of the exception
   public FileInvalidException(String e){
        super(e);
    }

    //accessor
    public String getMessage() {
        return super.getMessage();
    }
}
