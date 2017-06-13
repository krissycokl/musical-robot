/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//  $ = jQuery
$(document).ready(function (){
    //alert("Ready to go");
    numWords = 7;
    wordsOn = -1;
    colorWordsRed = 0;
    colorBlack = 256;
    $("#btnAdvance").on("click", function(){
        wordsOn += 1;
        $("#word"+wordsOn).show();
        colorWordsRed += Math.floor(180/numWords);
        colorBlack -= Math.floor(256/numWords);
        if (colorBlack >= 0){
            colorHex = colorBlack.toString(16);
            $("body").css('background-color','#'+colorHex+colorHex+colorHex);
            $(".words-normal").css('color','#'+colorWordsRed.toString(16)+"0000");
        } else {
            $("#btnAdvance").addClass("disabled");
            $("#btnFlowers").show();
        }
    });
    
    $("#btnFlowers").on("click", function(){
        $("#flower").removeClass("hidden");
    });
});