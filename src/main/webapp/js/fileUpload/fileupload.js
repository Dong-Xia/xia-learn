 

$(function(){
	
	 
	$("#file").change(function(){
		var file = this.files[0];
	    name = file.name; //文件名称
	    size = file.size;  //文件大小
	    type = file.type; // audio/mpeg  判断音频格式是不是MP3 
	    if(type&&type!=""){
	    	if(type=="audio/mpeg"||type=="audio/mp3"){
			    var fileExtension = getFileExtension(name);
			    if(fileExtension&&fileExtension==".mp3"){
			    	var reader = new FileReader();
	                 reader.onload=function(){
	                 	$("#media").html("<audio style='width:100%;' id='myAudio' src='"+this.result+"' autoplay='autoplay' controls='controls'>Your browser does not support the audio tag.</audio>");
	                 };
	                reader.readAsDataURL(file);
	                $("#status").html("计算文件MD5");
	                /*calculatorMd5(file);*/
	                calculate(file);
	                /*Md5File(file, "status", function(md5){
	                	$("#md5").val(md5);
	                	
	                	$("#uploadButton").show();
	                });*/
			    }else{
			    	alert("文件 后缀不是 .mp3  fileExtension="+fileExtension);
			    }
	    		
	    	}else{
	    		alert("文件 MIME类型不是 audio/mpeg或 audio/mp3  type="+type);
	    	}
	    }else{
	    	alert("unknown file MIME type");
	    	
	    }
	    
	});
	/**
	 * 根据文件名称获取文件的后缀  包含.
	 */
	function getFileExtension(fileName){
		var fileExtension = fileName.substring(fileName.lastIndexOf('.') ).toLowerCase(); //包含.  .mp3  
		return fileExtension;
	};
	
	function calculate(file){
		var fileReader = new FileReader(),
	        blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice,
	        chunkSize = 2097152,
	        // read in chunks of 2MB
	        chunks = Math.ceil(file.size / chunkSize),
	        currentChunk = 0,
	        spark = new SparkMD5();

	    fileReader.onload = function(e) {
	        console.log("read chunk nr", currentChunk + 1, "of", chunks);
	        spark.appendBinary(e.target.result); // append binary string
	        currentChunk++;

	        if (currentChunk < chunks) {
	            loadNext();
	        }
	        else {
	            console.log("finished loading");
                alert("计算成功");
        		$('#uploadButton').show();
        		$("#md5").val(spark.end());
	            console.info("computed hash", spark.end()); // compute hash
	        }
	    };

	    function loadNext() {
	        var start = currentChunk * chunkSize,
	            end = start + chunkSize >= file.size ? file.size : start + chunkSize;
	            var percent=(end/file.size)*100;
	            $("#progressBar").width(percent+"%");  
                $("#percent").text(percent+"%");
		        console.log("read chunk nr", file.size , "of", chunkSize);
	        fileReader.readAsBinaryString(blobSlice.call(file, start, end));
	    };

	    loadNext();
	};
 });