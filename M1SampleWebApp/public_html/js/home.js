/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    numWords = 7;
    wordsOn = -1;
    colorWordsRed = 0;
    colorBlack = 255;
    $("#btnAdvance").on("click", function(){
        wordsOn += 1;
        $("#word"+wordsOn).show();
        colorWordsRed += Math.floor(180/numWords);
        colorBlack -= Math.floor(256/numWords);
        if (colorBlack > 0){
            $("body").css('background-color','rgb('+colorBlack+', '+colorBlack+', '+colorBlack+')');
            $(".words-normal").css('color','rgb('+colorWordsRed+',0,0)');
        } else {
            $("#btnAdvance").addClass("disabled");
            $("#btnFlowers").show();
        }
    });
    
    $("#btnFlowers").on("click", function(){
        $("#flower").removeClass("hidden");
    });
});