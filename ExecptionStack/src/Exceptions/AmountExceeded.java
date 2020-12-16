package Exceptions;

public class AmountExceeded extends RuntimeException{
   public AmountExceeded(String msg){
       super(msg);
   }
}
