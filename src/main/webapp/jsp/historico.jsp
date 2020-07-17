<%-- 
    
    Author     : Monica
    --%>


    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <%@page import="model.Calculadora" %>
    <%@page import="model.CalculadoraService" %>
    <%@page import="java.util.List" %>
    <%@page import="java.text.*" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico</title>
    </head>
    <style type="text/css">
        body{
            background: #f2f2f2;
        }
        .box{
            background: #B0C4DE;
            width: 190px;
            height: 220px;
            padding: 50px;
            margin: 0 auto;
            border-radius: 20px;
            align-items: center;
            box-shadow: 10px 10px #d6d6d6;
        }
        input[type="submit" i]{
            display: flex;
            justify-content:center;
            padding: 3px 15px 3px 15px;
        }
        input{
            border-radius: 6px; 
            margin: 0 auto;
            display: flex;
            justify-content:center;
            border: 3px solid transparent;
        }
        p{
            text-align: center;
            font-size: 16px;
        }
        h1{
            text-align: center;
        }
    </style>
    
    <body>
     <div class="box">
        <h3>Histórico</h3>

        <% 

        List<Calculadora> registro = (List<Calculadora>) request.getAttribute("registro");
        if(registro.isEmpty()){
        out.print("<h1>Efetue uma operação para mostrar no histórico</h1>");
    }
    else{
    out.print("<table>"+
        "<tr>"+
            "<th>Calculo efetuado</th>"+
            "<th>Data</th>"+
        "</tr>");
        for(Calculadora linha: registro){

        out.print("<tr>"+
            "<td>"+linha.getOperacao() + "</td>"+
            "<td>"+linha.getData() + "</td>"+

        "</tr>");                
    } 
out.print("</table>");
}             
%>
<a href = login.action> Calculadora </a>
</div>

</body>
</html>
