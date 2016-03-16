/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WordDao {

    private Connection conn = new DbConnection().getConnection();
    private Statement statement = null;
    ResultSet resultSet =null;
    
    public List<String> getWordMeaning(String userParameter) {
       // jArray = new JSONArray();
        String words = null;
        List<String> wordList = new ArrayList<String>();
        String query = "Select distinct word from entries where word like "
                            + "'" + userParameter + "%'"
                            + " order by word";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            int count=0;
            while (resultSet.next()) {
                if(count<8){
                wordList.add(resultSet.getString(1));
                count++;
                }
                
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
              
         return wordList;
    }
    
//    public static void main(String[] main){
//        
//       System.out.println(new WordDao().getWordMeaning("A"));
//    }
}
