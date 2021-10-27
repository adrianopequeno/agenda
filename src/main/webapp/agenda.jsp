<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<% 
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Agenda de contatos</title>
	<link rel="icon" href="imagens/favicon.png" />
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
			<%} %>
		</tbody>
	</table>
</body>
</html>