$(document).ready(function () {
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();
    $("[id$=Weather").hide();
    
    $("#mainButton").on("click", function(){
        $("#mainInfoDiv").show();
        $("#akronInfoDiv").hide();
        $("#minneapolisInfoDiv").hide();
        $("#louisvilleInfoDiv").hide();
    });
    
    $("#akronButton").on("click", function(){
        $("#mainInfoDiv").hide();
        $("#akronInfoDiv").show();
        $("#minneapolisInfoDiv").hide();
        $("#louisvilleInfoDiv").hide();
    });
    
    $("#minneapolisButton").on("click", function(){
        $("#mainInfoDiv").hide();
        $("#akronInfoDiv").hide();
        $("#minneapolisInfoDiv").show();
        $("#louisvilleInfoDiv").hide();
    });
    
    $("#louisvilleButton").on("click", function(){
        $("#mainInfoDiv").hide();
        $("#akronInfoDiv").hide();
        $("#minneapolisInfoDiv").hide();
        $("#louisvilleInfoDiv").show();
    });
    
    $("[id$=WeatherButton]").on("click", function(){
        if ($(this).is(":contains('Show')")){
            $(this).text("Hide Weather");
        } else {
            $(this).text("Show Weather");
        }
        city = this.id.replace("WeatherButton","");
        $("#"+city+"Weather").toggle();
    });
    
    $("tr").has("td").hover(
            function (){
                $(this).css('background-color','whitesmoke');
            },
            function (){
                $(this).css('background-color','');
            }
    );
});