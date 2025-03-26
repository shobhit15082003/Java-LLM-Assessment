package Java.Backend.LLM.Assesment.demo.exception;

public class InsuranceNotFoundException extends RuntimeException{
    public InsuranceNotFoundException(String msg){
        super(msg);
    }
}
