<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="java.util.*" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CarRental</title>
	</head>
	<body>
		<%
   			String model1 = "fordScorpio";
    		String model2 = "hondaFit";
    		int year1 = 1990;
    		int year2 = 2004;
    		int year3 = 1995;
    		int year4 = 2000;
    		int value = 1000;
    	%>
		<form method="GET" action="Servlet1">
			Информация об автомобиле<br>
			Модель автомобиля<input type="text" name="model1" value=<%=model1%>>
			<input type="submit">
		</form>
		<form method="GET" action="Servlet2">
			Автомобили, изготовленные до 1990 года<br>
			Год выпуска автомобиля<input type="text" name="year1" value=<%=year1%>>
			<input type="submit">
		</form>
		<form method="GET" action="Servlet3">
			Автомобили Honda Fit, изготовленные после 2004 года<br>
			Модель автомобиля<input type="text" name="model2" value=<%=model2%>>
			Год выпуска автомобиля<input type="text" name="year2" value=<%=year2%>>
			<input type="submit">
		</form>
		<form method="GET" action="Servlet4">
			Информация об автомобиле<br>
			Госномер<input type="text" name="number">
			<input type="submit">
		</form>
		<form method="GET" action="Servlet5">
			Прокат<br>
			<label for="date">Нижняя граница</label>
			<input type="date" id="date" name="between">
			<label for="date">Верхняя граница</label>
			<input type="date" id="date" name="and">
			<input type="submit">
		</form>
		<form method="GET" action="Servlet6">
			Стоимость проката
			<input type="submit">
		</form>
		<form method="GET" action="Servlet7">
			Средняя страховая стоимость
			<input type="submit">
		</form>
		<form method="GET" action="Servlet8">
			Стоимость одного дня проката
			<input type="submit">
		</form>
		<form method="POST" action="Servlet1">
			Старые автомобили<br>
			Год выпуска автомобиля<input type="text" name="year3" value=<%=year3%>>
			<input type="submit">
		</form>
		<form method="POST" action="Servlet2">
			Создать копию таблицы АВТОМОБИЛИ
			<input type="submit">
		</form>
		<form method="POST" action="Servlet2">
			<input type="hidden" name="action" value="delete"/> 
			Удалить запись<br>
			Стоимость одного дня проката<input type="text" name="value" value=<%=value%>>
			<input type="submit" value="DELETE"/>
		</form>
		<form method="POST" action="Servlet2">
			<input type="hidden" name="action" value="put"/> 
			Увеличить стоимость одного дня проката на 10%<br> 
			Год выпуска автомобиля<input type="text" name="year4" value=<%=year4%>>
			<input type="submit">
		</form>	
	</body>
</html>