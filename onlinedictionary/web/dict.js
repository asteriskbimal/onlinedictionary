/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).on("click", "#somebutton", function () { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    var word = $('#word').val();
    $.get("DictServlet", {"word": word,
        success: function (responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
            var json = JSON.parse(responseText);
            $("#somediv").append("<table><tr><th>wordType</th><th>Definition</th></tr>");
            for (var i = 0; i < json.length; i++) {
                $("#somediv").append("<tr><td>" + json[i].word + "</td><td>" + json[i].definition + "</td></tr>");
            }
            $("#somediv").append("</table>");
            // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
        }
    });
});


