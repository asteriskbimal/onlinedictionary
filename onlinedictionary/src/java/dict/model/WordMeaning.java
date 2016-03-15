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

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public void setCount(int count) {
        count++;
    }
    
    private String word;
    private List<String> wordType=new ArrayList<String>();
    private List<String> definition=new ArrayList<String>();
    private int count=0; 

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @param wordType the wordType to set
     */
    public void addWordTypeDefinition(String wordType,String definition) {
        this.wordType.add(wordType);
        this.definition.add(definition);
        
    }

    public List<String> getDefinition() {
        return definition;
    }
    
    public String getDefinition(int i) {
        return definition.get(i);
    }
    
     public List<String> getWordType() {
        return wordType;
    }
     
      public String getWordType(int i) {
        return wordType.get(i);
    }
      
}
