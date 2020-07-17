<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <title> Login </title>
        <meta charset="utf-8">
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
        }
        input[type="submit" i] {
            padding: 3px 15px 3px 15px;
            background: #A9A9A9;
            cursor: pointer;
            color: #fff;
        }
        
    </style>
    <body>
       
        <h3>Para utilizar a calculadora, faça seu login:</h3>
        <div class=" box">
        <form method="get" 
         action="login.action">
            <p>Login:</p> <input name="login"/><br/>
            <p>Senha:</p> <input name="senha"/><br/>
            <input type="submit">
        </form>
        </div>
    </body>    
</html>