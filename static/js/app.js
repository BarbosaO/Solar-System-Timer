function executeQuery() {
    $.ajax({
        url: '/home',
        data: $('form').serialize(),
        type: "POST",
        success: function(resp){

            // update values for mercury
            $('#mercury-dist-text').text(resp['text'])
            $('#mercury-dist').text(resp['distance'][0]);
            $('#mercury-hx').text(resp['calculations'][0][1]);
            $('#mercury-hy').text(resp['calculations'][0][2]);
            $('#mercury-hz').text(resp['calculations'][0][3]);
            
            // update value for venus
            $('#venus-dist-text').text(resp['text'])
            $('#venus-dist').text(resp['distance'][1]);
            $('#venus-hx').text(resp['calculations'][1][1]);
            $('#venus-hy').text(resp['calculations'][1][2]);
            $('#venus-hz').text(resp['calculations'][1][3]);

            // update value for mars
            $('#mars-dist-text').text(resp['text'])
            $('#mars-dist').text(resp['distance'][2]);
            $('#mars-hx').text(resp['calculations'][2][1]);
            $('#mars-hy').text(resp['calculations'][2][2]);
            $('#mars-hz').text(resp['calculations'][2][3]);

            // update value for jupiter
            $('#jupiter-dist-text').text(resp['text'])
            $('#jupiter-dist').text(resp['distance'][3]);
            $('#jupiter-hx').text(resp['calculations'][3][1]);
            $('#jupiter-hy').text(resp['calculations'][3][2]);
            $('#jupiter-hz').text(resp['calculations'][3][3]);
        },
        complete: function(data){
            setTimeout(executeQuery, 1000);
        }
    });
}

$(document).ready(function(){
    setTimeout(executeQuery, 0);
});

$(document).ready(function(){
    $('#my-radio-box-units').change(function(){
        selected_value = $("input[name='radio']:checked").val();
        clearTimeout(executeQuery);
        if(selected_value == 'radioKM')
        {
            function executeQuery() {
                $.ajax({
                    url: '/home',
                    data: $('form').serialize(),
                    type: "POST",
                    success: function(resp){
                        // update values for mercury
                        $('#mercury-dist-text').text(resp['text']);
                        $('#mercury-dist').text(resp['distance'][0]);
                        
                        // update value for venus
                        $('#venus-dist-text').text(resp['text'])
                        $('#venus-dist').text(resp['distance'][1]);
            
                        // update value for mars
                        $('#mars-dist-text').text(resp['text'])
                        $('#mars-dist').text(resp['distance'][2]);

                        // update value for jupiter
                        $('#jupiter-dist-text').text(resp['text'])
                        $('#jupiter-dist').text(resp['distance'][3]);
                    },
                    complete: function(data){
                        setTimeout(executeQuery, 1000);
                    }
                });
            }
            $(document).ready(function(){
                setTimeout(executeQuery, 0);
                });
                
        }
        else if(selected_value == 'radioAU')
        {
            function executeQuery() {
                $.ajax({
                    url: '/home',
                    data: $('form').serialize(),
                    type: "POST",
                    success: function(resp){
                        // update values for mercury
                        $('#mercury-dist-text').text(resp['text']);
                        $('#mercury-dist').text(resp['distance'][0]);
                        
                        // update value for venus
                        $('#venus-dist-text').text(resp['text'])
                        $('#venus-dist').text(resp['distance'][1]);
            
                        // update value for mars
                        $('#mars-dist-text').text(resp['text'])
                        $('#mars-dist').text(resp['distance'][2]);
                        
                        // update value for jupiter
                        $('#jupiter-dist-text').text(resp['text'])
                        $('#jupiter-dist').text(resp['distance'][3]);
                    },
                    complete: function(data){
                        setTimeout(executeQuery, 1000);
                    }
                });
            }
            $(document).ready(function(){
                setTimeout(executeQuery, 0);
                });
        }
    });
});

function updateTime() {
    $.ajax({
        url: '/home',
        type: "POST",
        success: function(resp){
            $("#current-time-text").text(resp['currentTime']);
        },
        complete: function(data){
            setTimeout(updateTime, 1000);
        }
    });
}

$(document).ready(function(){
    setTimeout(updateTime, 0);
});

