<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">


		<h1>Listar Paciente</h1>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Data de Nascimento</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${pacientes}">
					<tr>
						<th>${p.id}</th>
						<th>${p.nome}</th>
						<th><fmt:formatDate value="${p.dataNascimento}"
								pattern="dd/MM/yyyy" /></th>
						<th><a
							href="${pageContext.request.contextPath}/paciente/excluir.do?idPaciente=${p.id}">
								<input type="button" value="Excluir" class="btn btn-danger">
						</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>