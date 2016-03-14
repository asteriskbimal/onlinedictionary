/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.model;

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
    private String wordType;
    private String definition;
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
     * @return the wordType
     */
    public String getWordType() {
        return wordType;
    }

    /**
     * @param wordType the wordType to set
     */
    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    /**
     * @return the definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * @param definition the definition to set
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    
}
