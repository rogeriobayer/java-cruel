package exceptions;


public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String string) {
        super(string);
    }

    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    
}