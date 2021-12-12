package exceptions;

public class AppException extends Exception {
    private String msg;
    
    AppException(String msg){
        super(msg);
    }
    
    public String toString(){
        return("Um erro ocorreu: " + msg);
    }
}
