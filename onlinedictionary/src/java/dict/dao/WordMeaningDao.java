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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author 984910
 */
public class WordMeaningDao {

    private Connection conn = new DbConnection().getConnection();
    private Statement statement = null;
    String userParameter="A";
   
    
    JSONObject job=new JSONObject(); //create a JSON Object obj.
    JSONArray jArray = new JSONArray(); //create a JSON Array obj.
    
    public JSONArray getWordMeaning( ) {
        WordMeaning wordMeaning = new WordMeaning();
        String query = "Select word,wordtype,definition from entries where word ="
                            + "'" + userParameter + "'"
                            + "order by word,wordtype,definition";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                
                wordMeaning.setWord(resultSet.getString(1));
                wordMeaning.addWordTypeDefinition(resultSet.getString(2), resultSet.getString(3));
                job.put("wordtype", resultSet.getString(2));
                job.put("worDefinition", resultSet.getString(3));
            }
            jArray.add(job); //add the JSON obj (job) to an JSON array.This will make it easier to fetch the results of each.
            job.clear();

            while (resultSet.next()) {
                wordMeaning.addWordTypeDefinition(resultSet.getString(2), resultSet.getString(3));
                job.put("wordtype", resultSet.getString(2));
                job.put("worDefinition", resultSet.getString(3));
                jArray.add(job); //add the JSON obj (job) to an JSON array.This will make it easier to fetch the results of each.
                job.clear();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
              
        return jArray;
    }
//    
//    public static void main(String[] main){
//        
//        WordMeaning test=new WordMeaningDao().getWordMeaning();
//        System.out.println(test.getWord()+":\n");
//        for(int i=0;i<test.getDefinition().size();i++){
//             System.out.println(test.getWordType(i)+":"+test.getDefinition(i)+":\n");
//        }
//    }
}
