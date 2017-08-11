       var progress;  
       var uploadProcessTimer = null;  
         
        function formSubmit(){    
           uploadProcessTimer =window.setInterval("getFileUploadProcess()",0.001);//每隔0.1毫秒执行callback  
           document.getElementById("formFile").submit();  
        }    
         
        function getFileUploadProcess() {    
              $.ajax({  
                     type:"post",  
                     url:"fileUploadStatus.do",  
                     dataType:"text",  
                     success:function(data){  
                              
                               
                         if(data=="100%"){  
                             alert("上传成功"); 
                         }else{  
                              progress=data;  
                             $("#progressBar").width(data);  
                             $("#percent").text(data);  
                         }  
                     }  
             });  
          };