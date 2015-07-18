<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="corpo">

		<h1>Cadastar Consulta</h1>

		<script type="text/javascript">
			function carregaMedicosDaEspecialidade() {
				
				$("select#medico option").remove();
				var selectMedicos = $('#medico');
				selectMedicos.append('<option value="">selecione</option>');
				
				if($("#especialidade").val()!='') {
					
					$ajax({
						type:"get",
						url:"${pageContext.request.contextPath}/medico/listarPorEspecialidade.do",
						data:'especialidade='+ $("#especialidade").val(),
						success:function(medicos){
							$.each(medicos, function(i, medico){
								selectMedicos.append('<option value="'+medico.id+'">' + medico.nome + '</option>');
							});	
						},
						error:function(){
							alert("Erro ao pesquisar médicos pela especialidade");
						}
					});
				}
			}
		</script>

		<springform:form method="post" action="${pageContext.request.contextPath}/consulta/agendar.do" modelAttribute="consulta">
			<div style="width: 300px;">
				<div class="form-group">
					<label for="especialidade">Especialidade:</label>
					<select id="especialidade" onchange="carregaMedicosDaEspecialidade();" class="form-control">
						<option value="">selecione</option>
						<c:forEach items="${especialidades}" var="e">
							<option value="${e}">${e.descricao}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</springform:form>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>