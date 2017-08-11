(function($) {
    $(function() {
        
        
        WebUploader.create({
            pick: '#filePicker'
        }).on('fileQueued', function( file ) {
            var start =  +new Date();

            // 返回的是 promise 对象
            this.md5File(file)

                // 可以用来监听进度
                .progress(function(percentage) {
                     $("#progressBar").width(percentage*100+"%");  
                     $("#percent").text(percentage*100+"%");
                     alert(percentage*100+"%");
                })

                // 处理完成后触发
                .then(function(ret) {
                    var end = +new Date();
                    $("#md5").val(ret);
                    $("#filename").val(file.name);
                    alert("计算成功");
            		$('#uploadButton').show();
            		$("#media").show();
                });
        });

    });
})(jQuery);