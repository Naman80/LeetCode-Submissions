/**
 * @param {number[][]} points
 * @return {number}
 */
var numberOfPairs = function(points) {  
  let res = 0;
    
  for (let i=0; i<points.length; i++) {
    for (let j=i+1; j<points.length; j++) {
      let f = true;  
         
      // let [xi,yi] = points[i], [xj,yj] = points[j];  
        
if (points[i][0] < points[j][0] && points[i][1] < points[j][1] || points[i][0] > points[j][0] && points[i][1] > points[j][1]) continue;  
        
      let x1 = Math.min(points[i][0],points[j][0]);
      let x2 = Math.max(points[i][0],points[j][0]);  
      let y1 = Math.min(points[i][1],points[j][1]);  
      let y2 = Math.max(points[i][1],points[j][1]); 
        
      for (let k=0; k<points.length; k++) {
        if (k==i || k==j) continue;  
        // let [xk, yk] = points[k];           
          
    if (points[k][0] >= x1 && points[k][0] <= x2 && points[k][1] >= y1 && points[k][1] <= y2) {
          f = false;
          break;  
        }  
      }    
        
      if (f) res++;  
    }  
  }  
    
  return res; 
};