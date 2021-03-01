<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
input {
  outline: 0;
  position: relative;
  left: 5px;
  top: 5px;
  border: 0;
  color: #495069;
  background-color: #fff;
  border-radius: 4px;
  width: 60px;
  height: 50px;
  float: left;
  margin: 5px;
  font-size: 20px;
  box-shadow: 0 4px rgba(0,0,0,0.2);
  margin-bottom: 15px;
}
input:hover {
  border: 0 solid #000;
  color: #495069;
  background-color: #fff;
  border-radius: 4px;
  width: 60px;
  height: 50px;
  float: left;
  margin: 5px;
  font-size: 20px;
  box-shadow: 0 4px #b0d2cf;
}
#display {
  width: 265px;
  max-width: 270px;
  font-size: 26px;
  text-align: right;
  background-color: #bcbd95;
  float: left;
}


</style>

<!-- //<link rel="stylesheet" href="MyStyle.css"> -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #888;">
	<form name="calculator"><br><br>
   <table border="1" style="background-color: #222; max-width: 295px; height: 325px;" align="center">
      <tr>
         <td colspan="4">
            <input type="text" name="display" id="display" disabled>
           
         </td>
      </tr>
      <tr>
            <td><input type="button" name="one" value="1" onclick="calculator.display.value += '1'"></td>
            <td><input type="button" name="two" value="2" onclick="calculator.display.value += '2'"></td>
            <td><input type="button" name="three" value="3" onclick="calculator.display.value += '3'"></td>
            <td><input type="button" class="operator" name="plus" value="+" onclick="calculator.display.value += '+'"></td>
     </tr>
     <tr>
            <td><input type="button" name="four" value="4" onclick="calculator.display.value += '4'"></td>
            <td><input type="button" name="five" value="5" onclick="calculator.display.value += '5'"></td>
            <td><input type="button" name="six" value="6" onclick="calculator.display.value += '6'"></td>
            <td><input type="button" class="operator" name="minus" value="-" onclick="calculator.display.value += '-'"></td>
     </tr>
     <tr>
            <td><input type="button" name="seven" value="7" onclick="calculator.display.value += '7'"></td>
            <td><input type="button" name="eight" value="8" onclick="calculator.display.value += '8'"></td>
            <td><input type="button" name="nine" value="9" onclick="calculator.display.value += '9'"></td>
            <td><input type="button" class="operator" name="times" value="x" onclick="calculator.display.value += '*'"></td>
     </tr>
     <tr>
            <td><input type="button" id="clear" name="clear" value="c" onclick="calculator.display.value = ''"></td>
            <td><input type="button" name="zero" value="0" onclick="calculator.display.value += '0'"></td>
            <td><input type="button" name="doit" value="=" onclick="calculator.display.value = eval(calculator.display.value)"></td>
            <td><input type="button" class="operator" name="div" value="/" onclick="calculator.display.value += '/'"></td>
      
      </tr>
   </table>
</form>
</body>
</html>