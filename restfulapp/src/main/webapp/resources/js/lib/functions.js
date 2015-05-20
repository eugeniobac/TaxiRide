var getMessage = function(param, text){
  var index = param.length;
  var errors;
  index += text.indexOf(param);
  text = text.substring(index);
  index = text.indexOf("'");
  errors = text.substring(0,index);
  
  if(text.indexOf(param) > 0){
     errors += ", " + getMessage(param,text);
  }
  
  return errors;
};