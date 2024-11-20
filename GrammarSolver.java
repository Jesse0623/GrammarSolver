/** GrammarSolver class
* @author Jessica Li
* @version 1.0 (05/21/2023)
*/

import java.util.*;
import java.io.*;

public class GrammarSolver
{  /**create a map to save the non-terminal that cannot be 
     *expanded as the key and the terminals that can be 
     *expanded as the value.
    */
   private Map<String, String[]> bnfRule = new TreeMap<>();
   //create a random generator to make random choices between rules.
   private Random r = new Random();
   
   /**GrammarSolver method sperated the given BNF grammar lines into 
     *non-ternimal and ternimals. First, it will save the non-ternimal
     *as the key of the map, and then save the ternimals as the value of 
     *the map.
     *@param rules it's a list of strings that contain all the BNF grammar rules in the doc.
     */
   public GrammarSolver(List<String> rules)
   {
    /** throw an IllegalArgumentException if the list is null, 
       or empty (size 0).
    */
      if(rules==null || rules.isEmpty())
      {
         throw new IllegalArgumentException();
      }
      
      //iterate each strings based on the given BNF grammar rules list. 
      for(String str : rules)
      {  //split the BNF grammar scentence into two part: right hand side(non-ternimal) and left hand side(a line that contains many ternimals that being seperated by pipes)
         //split() breaks a large string into an array of smaller string tokens. 
         //trim() removes whitespace characters at the beginning and end of the string. 
         String[] splitIntoTwo = str.trim().split("::=");
         String lhs = splitIntoTwo[0].trim();
         String[] rhs = splitIntoTwo[1].trim().split("[|]");
         if(bnfRule.containsKey(lhs))
         {
            throw new IllegalArgumentException();
         }
         //save the non-ternimal of a BNF grammar rule as the key of the map bnfRule
         //save the ternimals of a a BNF grammar rule as the value of the map bnfRule
         bnfRule.put(lhs, rhs);
      }
   }
   /** contains method will return true if the symbol that user entered is a non-ternimal
     * return false if it a ternimal. Moreover, it will throw an IllegalArgumentException
     * if the symbol's size is 0 or it's null.
     * @param the user input
     * @return return true if user input is a non-ternimal
     * @return return false if it's not
     */
   public boolean contains(String symbol) {
      if (symbol == null || symbol.length() == 0) {
        throw new IllegalArgumentException();
    }
    
      if (bnfRule.containsKey(symbol)) {
        return true;
    } else {
        return false;
    }
  }
  
  /**getSymbols method will reutrn the non-ternimals as a sorted set of strings.
    *@return return the key of the bnfRule map, which are the non-ternimals of
    *each BNF rule scentences. 
    */
   public Set<String> getSymbols(){
     return bnfRule.keySet();
  }  
  
  /** generate method allows us to generate random occurrence of the given symbol
    * based on the BNF grammar rules that saved in the map.bIt will throw an 
    * IllegalArgumentException() if the given symbol is null or it's size is 0.
    * @return symbol when the userinput "symbol" is a ternimal we cannot expand it by
    * any further, so we return the symbol.
    * @return result.trim() return the final string that we have randomly generated between
    * the rules and has cleaned all the empty space of in front and at the end of the final string.
    */
  public String generate(String symbol){
   if(symbol == null || symbol.length() == 0){
      throw new IllegalArgumentException();
  }
  //if the symbol(the userinput) is a ternimal, we cannont expand it, so we just return it.
   if(!bnfRule.containsKey(symbol)){
      return symbol;
     
   }//if the symbol is a non-ternimal
    else{
        //Array rhs contains all the values of the map bnfRules (all possible expansions) 
        //based on the given symbol (given non-ternimals).
        String[] rhs = bnfRule.get(symbol);
        /**We want to randomly choose a rule to follow from all the possibilities, so we 
          * create a random generator that the amount of choices it can pick is the size of 
          * rhs, the array that contains all the possible expansions.
          */ 
        String randTerminals = rhs[r.nextInt(rhs.length)];
        //after we get a line of tokens that being seperated by empty space, 
        // we want to split the line and save each individual token into an array.
        String[] tokens = randTerminals.split("[ \t]+");
        String result = "";//initalize a string accumulator
        /**Based on each token that in the tokens array, it use recursion to expands the 
          *non-ternmials it represents, and retrn itself if it's ternimal symbol.
          */
         for (String token : tokens) {
            result += generate(token) + " ";
            //we add an empty space at the end of each token to seperate them. 
        }

        return result.trim();
            //trim method here is to clean the white space that at the end of the last token. 
     }   
   
   
  }
  
  
}
   
   


