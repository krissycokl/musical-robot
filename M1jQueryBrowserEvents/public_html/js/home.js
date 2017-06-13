$(document).ready(function () {
    $("#akronInfoDiv").hide();
    $("#minneapolisInfoDiv").hide();
    $("#louisvilleInfoDiv").hide();
    $("[id$=Weather").hide();
    
    $("#mainButton").add("#akronButton").add("#minneapolisButton").add("#louisvilleButton")
            .on("click", function(){
        $("[id$=InfoDiv]").hide();
        city = this.id.replace("Button","");
        $("#"+city+"InfoDiv").show();
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