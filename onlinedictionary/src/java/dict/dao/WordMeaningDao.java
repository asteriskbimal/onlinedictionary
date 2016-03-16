/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.dao;

import dict.model.WordMeaning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author 984910
 */
public class WordMeaningDao {

    private Connection conn = new DbConnection().getConnection();
    private Statement statement = null;
     ResultSet resultSet =null;
    //String userParameter="A";
   
//    JSONObject job; //create a JSON Object obj.
//    JSONArray jArray; //create a JSON Array obj.
    
    public List<WordMeaning> getWordMeaning(String userParameter) {
       // jArray = new JSONArray();
        WordMeaning wordMeaning = null;
        List<WordMeaning> wordMeaningList = new ArrayList<WordMeaning>();
        String query = "Select * from entries where word ="
                            + "'" + userParameter + "'"
                            + " order by word,wordtype,definition";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

//            if (resultSet.next()) {
//                
//                wordMeaning.setWord(resultSet.getString(1));
////                wordMeaning.addWordTypeDefinition(resultSet.getString(2), resultSet.getString(3));
//////                job.put("wordtype", resultSet.getString(2));
//////                job.put("worDefinition", resultSet.getString(3));
//            }
////            jArray.add(job); //add the JSON obj (job) to an JSON array.This will make it easier to fetch the results of each.
////            job.clear();

            while (resultSet.next()) {
//                job=new JSONObject()
                wordMeaning=new WordMeaning();
                wordMeaning.setWord(resultSet.getString(1));
                wordMeaning.setWordType(resultSet.getString(2)); 
                wordMeaning.setDefinition(resultSet.getString(3));
//                job.put("wordtype", resultSet.getString(2));
//                job.put("worDefinition", resultSet.getString(3));
//                jArray.add(job); //add the JSON obj (job) to an JSON array.This will make it easier to fetch the results of each.
//                job.clear();
                wordMeaningList.add(wordMeaning);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
              
       //  jArray.add(wordMeaning);
         return wordMeaningList;
    }
    
    public static void main(String[] main){
        
        List<WordMeaning> test=new WordMeaningDao().getWordMeaning("A");
        for(WordMeaning w:test){
            System.out.println(w.getWordType()+":"+w.getDefinition());
        }
    }
}
