package co.com.expertgroup.cat.exceptions;

public class InformationException extends RuntimeException{


    public InformationException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
