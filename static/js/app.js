function executeQuery() {
    $.ajax({
        url: '/home',
        data: $('form').serialize(),
        type: "POST",
        success: function(resp){

            // update values for Mercury
            $('#mercury-dist-text').text(resp['text'])
            $('#mercury-dist').text(resp['distance'][0]);
            $('#mercury-hx').text(resp['calculations'][0][1]);
            $('#mercury-hy').text(resp['calculations'][0][2]);
            $('#mercury-hz').text(resp['calculations'][0][3]);
            
            // update values for Venus
            $('#venus-dist-text').text(resp['text'])
            $('#venus-dist').text(resp['distance'][1]);
            $('#venus-hx').text(resp['calculations'][1][1]);
            $('#venus-hy').text(resp['calculations'][1][2]);
            $('#venus-hz').text(resp['calculations'][1][3]);

            // update values for Mars
            $('#mars-dist-text').text(resp['text'])
            $('#mars-dist').text(resp['distance'][2]);
            $('#mars-hx').text(resp['calculations'][2][1]);
            $('#mars-hy').text(resp['calculations'][2][2]);
            $('#mars-hz').text(resp['calculations'][2][3]);

            // update values for Jupiter
            $('#jupiter-dist-text').text(resp['text'])
            $('#jupiter-dist').text(resp['distance'][3]);
            $('#jupiter-hx').text(resp['calculations'][3][1]);
            $('#jupiter-hy').text(resp['calculations'][3][2]);
            $('#jupiter-hz').text(resp['calculations'][3][3]);

            // update values for Saturn
            $('#saturn-dist-text').text(resp['text'])
            $('#saturn-dist').text(resp['distance'][4]);
            $('#saturn-hx').text(resp['calculations'][4][1]);
            $('#saturn-hy').text(resp['calculations'][4][2]);
            $('#saturn-hz').text(resp['calculations'][4][3]);

             // update values for Uranus
             $('#uranus-dist-text').text(resp['text'])
             $('#uranus-dist').text(resp['distance'][5]);
             $('#uranus-hx').text(resp['calculations'][5][1]);
             $('#uranus-hy').text(resp['calculations'][5][2]);
             $('#uranus-hz').text(resp['calculations'][5][3]);

            // update values for Neptune
            $('#neptune-dist-text').text(resp['text'])
            $('#neptune-dist').text(resp['distance'][6]);
            $('#neptune-hx').text(resp['calculations'][6][1]);
            $('#neptune-hy').text(resp['calculations'][6][2]);
            $('#neptune-hz').text(resp['calculations'][6][3]);
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

    $('#my-radio-box-coord').change(function(){
        selected_value = $("input[name='radio-coor']:checked").val();
        if(selected_value == 'radioH')
        {
            function executeQuery() {
                $.ajax({
                    url: '/home',
                    data: $('form').serialize(),
                    type: "POST",
                    success: function(resp){
                        // update values for Mercury
                        $('#mercury-dist').text(resp['distance'][0]);
                        $('#mercury-hx').text(resp['calculations'][0][1]);
                        $('#mercury-hy').text(resp['calculations'][0][2]);
                        $('#mercury-hz').text(resp['calculations'][0][3]);
                        
                        // update values for Venus
                        $('#venus-dist-text').text(resp['text'])
                        $('#venus-dist').text(resp['distance'][1]);
                        $('#venus-hx').text(resp['calculations'][1][1]);
                        $('#venus-hy').text(resp['calculations'][1][2]);
                        $('#venus-hz').text(resp['calculations'][1][3]);

                        // update values for Mars
                        $('#mars-dist-text').text(resp['text'])
                        $('#mars-dist').text(resp['distance'][2]);
                        $('#mars-hx').text(resp['calculations'][2][1]);
                        $('#mars-hy').text(resp['calculations'][2][2]);
                        $('#mars-hz').text(resp['calculations'][2][3]);

                        // update values for Jupiter
                        $('#jupiter-dist-text').text(resp['text'])
                        $('#jupiter-dist').text(resp['distance'][3]);
                        $('#jupiter-hx').text(resp['calculations'][3][1]);
                        $('#jupiter-hy').text(resp['calculations'][3][2]);
                        $('#jupiter-hz').text(resp['calculations'][3][3]);

                        // update values for Saturn
                        $('#saturn-dist-text').text(resp['text'])
                        $('#saturn-dist').text(resp['distance'][4]);
                        $('#saturn-hx').text(resp['calculations'][4][1]);
                        $('#saturn-hy').text(resp['calculations'][4][2]);
                        $('#saturn-hz').text(resp['calculations'][4][3]);

                        // update values for Uranus
                        $('#uranus-dist-text').text(resp['text'])
                        $('#uranus-dist').text(resp['distance'][5]);
                        $('#uranus-hx').text(resp['calculations'][5][1]);
                        $('#uranus-hy').text(resp['calculations'][5][2]);
                        $('#uranus-hz').text(resp['calculations'][5][3]);

                        // update values for Neptune
                        $('#neptune-dist-text').text(resp['text'])
                        $('#neptune-dist').text(resp['distance'][6]);
                        $('#neptune-hx').text(resp['calculations'][6][1]);
                        $('#neptune-hy').text(resp['calculations'][6][2]);
                        $('#neptune-hz').text(resp['calculations'][6][3]);

                        // update values for all coordinate text divs for hx
                        $("div[id$='x-coor-text']").text(resp['coorText'][0]);

                        // update values for all coordinate text divs for hy
                        $("div[id$='y-coor-text']").text(resp['coorText'][1]);

                        // update values for all coordinate text divs for hz
                        $("div[id$='z-coor-text']").text(resp['coorText'][2]);
                        MathJax.typeset(["div[id$='coor-text']"]);
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
        else if(selected_value == 'radioG')
        {
            function executeQuery() {
                $.ajax({
                    url: '/home',
                    data: $('form').serialize(),
                    type: "POST",
                    success: function(resp){

                        $('#mercury-dist').text(resp['distance'][0]);
                        $('#venus-dist').text(resp['distance'][1]);
                        $('#mars-dist').text(resp['distance'][2]);
                        $('#jupiter-dist').text(resp['distance'][3]);
                        $('#saturn-dist').text(resp['distance'][4]);
                        $('#uranus-dist').text(resp['distance'][5]);
                        $('#neptune-dist').text(resp['distance'][6]);

                        // update values for all coordinate text divs for gx
                        $("div[id$='x-coor-text']").text(resp['coorText'][0]);

                        // update values for all coordinate text divs for gy
                        $("div[id$='y-coor-text']").text(resp['coorText'][1]);

                        // update values for all coordinate text divs for gz
                        $("div[id$='z-coor-text']").text(resp['coorText'][2]);

                        MathJax.typeset(["div[id$='coor-text']"]);
                    },
                    complete: function(data){
                    }
                });
            }
            $(document).ready(function(){
                setTimeout(executeQuery, 0);
                });
        }
    });
});


$(document).ready(function(){
    $('#my-radio-box-units').change(function(){
        selected_value = $("input[name='radio']:checked").val();
        if(selected_value == 'radioKM')
        {
            function executeQuery() {
                $.ajax({
                    url: '/home',
                    data: $('form').serialize(),
                    type: "POST",
                    success: function(resp){
                        // update values for Mercury
                        $('#mercury-dist-text').text(resp['text']);
                        $('#mercury-dist').text(resp['distance'][0]);
                        
                        // update value for Venus
                        $('#venus-dist-text').text(resp['text'])
                        $('#venus-dist').text(resp['distance'][1]);
            
                        // update value for Mars
                        $('#mars-dist-text').text(resp['text'])
                        $('#mars-dist').text(resp['distance'][2]);

                        // update value for Jupiter
                        $('#jupiter-dist-text').text(resp['text'])
                        $('#jupiter-dist').text(resp['distance'][3]);

                        // update value for Saturn
                        $('#saturn-dist-text').text(resp['text'])
                        $('#saturn-dist').text(resp['distance'][4]);

                        // update values for Uranus
                        $('#uranus-dist-text').text(resp['text'])
                        $('#uranus-dist').text(resp['distance'][5]);

                        // update values for Neptune
                        $('#neptune-dist-text').text(resp['text'])
                        $('#neptune-dist').text(resp['distance'][6]);

                        
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

                        // update value for Saturn
                        $('#saturn-dist-text').text(resp['text'])
                        $('#saturn-dist').text(resp['distance'][4]);

                        // update values for Uranus
                        $('#uranus-dist-text').text(resp['text'])
                        $('#uranus-dist').text(resp['distance'][5]);

                        // update values for neptune
                        $('#neptune-dist-text').text(resp['text'])
                        $('#neptune-dist').text(resp['distance'][6]);
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

