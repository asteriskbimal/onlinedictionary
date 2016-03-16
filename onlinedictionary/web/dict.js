/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on("click", "#somebutton", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    var word = $('#word').val();
    $("#somediv").text("");
    $.get("DictServlet",{"word" : word},function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
            var json = JSON.parse(responseText);
             $("#somediv").append("<h3>Word:"+json[0].word +"</h3><br>");
             $("#somediv").append("<table style='padding:8px;'><tr style='padding:8px;text-align: left;border-bottom: 1px solid #ddd;'><th>Word Definition</th></tr>");
            for (var i = 0; i < json.length; i++) {
                if(i%2==0)
                $("#somediv").append("<tr style='padding:8px;text-align: left;border-bottom: 1px solid #ddd;background-color:#DFDFDF;'><td>"+(i+1)+"</td><td>" + json[i].wordType+ "</td><td>" + json[i].definition + "</td></tr>");
                else
                $("#somediv").append("<tr style='padding:8px;text-align: left;border-bottom: 1px solid #ddd;background-color:#FFFFFF;'><td>"+(i+1)+"</td><td>" + json[i].wordType+ "</td><td>" + json[i].definition + "</td></tr>");    
        }
           
//            // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
    $("#somediv").append("</table>");
});

  /************For search in top nav bar ***/
 
  $(document).on("keypress","#word",function(){
    var search=$(this).val();
    if (search.length >=1)//let user hit three initials alphabet
    {
        $.get("WordServlet",{"keyword" : search},function (data) { 
            var json = JSON.parse(data);
 //           console.log(json[0].words);
//             for (var i = 0; i < json.length; i++) {  
//                $("#wordzlist").append("<option value="+json[i]+">");
//             }
          
        });
   
    } 
  });



