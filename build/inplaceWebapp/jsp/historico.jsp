<%-- 
    
    Author     : fabss
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
            background: #D3D3D3;
        }
        .box{
            background: #f2f2f2;
            width:200px;
            height:250px;
            padding: 40px;
            margin: 0 auto;
            border-radius: 10px;
        }
        input{
            margin: 0 auto;
            display: flex;
            align-items: center;
        }
        p{
            text-align: center;
        }
        h3{
            text-align: center;
            padding-bottom: 187px;
            color: #000;
        }
        a{

            color: #000;
            padding-left: 61px;
            text-align: center;
            display: flex;
            padding-top: -86px;
            margin-top: 165px;
        }
        table{
            margin-top: -190px;
            text-align: center;
        }
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
