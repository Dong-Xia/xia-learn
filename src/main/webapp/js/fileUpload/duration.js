
 
$(function(){
	
	   /**  
	 
	   * @param {} second  
	 
	   * @return {}  
	 
	   * @desc 秒转化成dd hh:mm:ss  
	 
	   */ 
	function dateFormat(second){  
 
      var dd,hh,mm,ss;  
 
      second = typeof second === 'string' ? parseInt(second) : second;  
 
      if(!second || second < 0){  
 
          return;  
 
      }  
 
      //天  
 
      dd = second / (24 * 3600) | 0;  
 
      second = Math.round(second) - dd * 24 * 3600;  
 
      //小时  
 
      hh = second / 3600 | 0;  
 
      second = Math.round(second) - hh * 3600;  
 
      //分  
 
      mm = second / 60 | 0;  
 
      //秒  
 
      ss = Math.round(second) - mm * 60;  
 
      if(Math.round(dd) < 10){  
 
          dd = dd > 0 ? '0' + dd : '';  
 
      }  
 
      if(Math.round(hh) < 10){  
 
          hh = '0' + hh;  
 
      }  
 
      if(Math.round(mm) < 10){  
 
          mm = '0' + mm;  
 
      }  
 
      if(Math.round(ss) < 10){  
 
          ss = '0' + ss;  
 
      }  
 
      return dd + ' ' + hh + ':' + mm + ':' + ss;  
 
  }
});
 
 
