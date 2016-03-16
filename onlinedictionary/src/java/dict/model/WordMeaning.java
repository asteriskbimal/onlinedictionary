/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 984910
 */
public class WordMeaning {
   
    private String word;
    private String wordType;
    private String definition;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

   
    public String getDefinition() {
        return definition;
    }
    
     
      public String getWordType() {
        return wordType;
    }
      
      public void setDefinition(String definition) {
        this.definition=definition;
    }
         
      public void setWordType(String wordType) {
        this.wordType=wordType;
    }
      
      public String toString(){
          return (this.word+":"+this.wordType+":"+this.definition);
      }
      
}
