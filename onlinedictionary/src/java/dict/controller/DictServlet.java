/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.controller;
import dict.dao.WordMeaningDao;
import dict.model.WordMeaning;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author 984910
 */
public class DictServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       String input=request.getParameter("word");
       System.out.print(input);
       JSONObject job =null; //create a JSON Object obj.
       JSONArray jArray=new JSONArray(); //create a JSON Array obj.
       List<WordMeaning> wordMeaningList =new WordMeaningDao().getWordMeaning(input);
//       //jArray.addAll(wordMeaningList); 
        int i=0;
       for(WordMeaning w:wordMeaningList){
            job = new JSONObject();
            job.put("definition",w.getDefinition());
            job.put("wordType",w.getWordType());
            job.put("word",w.getWord());
            jArray.add(job);
            
        }                      
                             
               
//    JSONArray jArraya = new JSONArray();
    
//    jArraya.add("bimal");
//    jArraya.add("bijay");
//    job.put("a","Apple");
//    job.put("b","Ball");
//    jArraya.add(job);
//    joba.clear();
//    joba.put("a","Air");
//    joba.put("b","Bag");
//    jArraya.add(joba);

       response.getWriter().write(jArray.toJSONString());  
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
