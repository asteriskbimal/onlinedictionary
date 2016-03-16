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
             $("#somediv").append("<table><tr><th>Word Type</th><th>Definition</th></tr>");
            for (var i = 0; i < json.length; i++) {
            
                $("#somediv").append("<tr><td>" + json[i].wordType+ "</td><td>" + json[i].definition + "</td></tr>");
            }
            $("#somediv").append("</table>");
//            // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
   
});


