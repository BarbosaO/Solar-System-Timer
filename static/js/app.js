function executeQuery() {
    $.ajax({
        url: "/home",
        type: "POST",
        success: function(resp){
            $('div#calculations').html(resp.data);
        },
        complete: function(data){
            setTimeout(executeQuery, 1000);
        }
    });
}

$(document).ready(function(){
setTimeout(executeQuery, 0);
});