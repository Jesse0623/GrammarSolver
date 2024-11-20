public class RecursionIsCool {
   public static void main(String[] args){
      sayHi(5);
   }
   
   public static void sayHi(int n) {
      //need a base case
      if(n==0) {
         System.out.println("Done!");
      }{
         System.out.println("Hi");
         n--;
         //5,4,3,2,1
         sayHi();
      }
   
   
   }






}