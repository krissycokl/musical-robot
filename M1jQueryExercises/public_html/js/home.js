$(document).ready(function () {
    $("h1").css('text-align','center');
    $("h2").css('text-align','center');
    
    $(".myBannerHeading").addClass("page-header");
    $(".myBannerHeading").removeClass("myBannerHeading");
    
    $("#yellowHeading").text("Yellow Team");
    
    $(".red").css('background-color','red');
    $(".orange").css('background-color','orange');
    $(".blue").css('background-color','blue');
    $(".yellow").css('background-color','yellow');
    
    $("#yellowTeamList").append("<li>Joseph Banks</li>");
    $("#yellowTeamList").append("<li>Simon Jones</li>");
    
    $("#oops").hide();
    
    $("#footerPlaceholder").remove();
    
    $("footer").append("<p id='realFooter'>Kristen Pietsch<br>1555 Happy Drive</p>");
    $("#realFooter").css({
        'font-family':'Courier',
        'font-size':'24',
        'text-align':'center'
    });
});