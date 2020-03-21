(function worker() {
    $.ajax({
      url: '/index.html', 
      success: function(data) {
        $('.result').html(data);
      },
      complete: function() {
        // Schedule the next request when the current one's complete
        setTimeout(worker, 3000);
      }
    });
  })();