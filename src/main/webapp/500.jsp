<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">
		<p align="center">Escolha sua opção logo acima</p>
		<h1 align="center">Erro no servidor</h1>
		<img src="${pageContext.request.contextPath}/images/404.jpg" alt="Page Not Found (404)."
			style="position: absolute; left: 50%; top: 50%; margin-left: -285px; margin-top: -190px;">
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>