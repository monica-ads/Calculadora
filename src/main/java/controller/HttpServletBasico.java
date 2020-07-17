/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence;
import javax.persistence.Query; 
import model.Calculadora;
import model.CalculadoraService;
import java.util.Date;
import model.Usuario;
import model.UsuarioService;

/**
 *
 * 
 */
@WebServlet({"*.action","/"})
public class HttpServletBasico extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest req,
   HttpServletResponse res){

    String path = req.getServletPath();
    ServletContext sc = req.getServletContext();
    System.out.println(path); 
    switch (path){
      case "/":
      try{
        sc.getRequestDispatcher("/jsp/form.jsp").forward(req, res);
      } catch (Exception e){}
      break;
      case "/login.action":

      try{

        req.setCharacterEncoding("UTF-8");
        String nomeUsuario = req.getParameter("login");
        String senha = req.getParameter("senha");


        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        req.setAttribute("login", nomeUsuario);
        req.setAttribute("senha", senha);
        sc.getRequestDispatcher("/jsp/resposta.jsp").forward(req, res);
      }catch (Exception e){}
      break;
      case "/calculo.action":
      try{
        req.setCharacterEncoding("UTF-8");
        String operacao = req.getParameter("operacao");

        //passando para float
        double opc1 = Double.parseDouble(req.getParameter("op1"));
        double opc2 = Double.parseDouble(req.getParameter("op2"));

        double resultado = 0;
        int i = 0;

        //switch para as operações
        switch (operacao) {
          case "+":
          resultado = soma(opc1, opc2);
          break;
          case "-":
          resultado = subtracao(opc1, opc2);
          break;
          case "*":
          resultado = multiplicacao(opc1, opc2);
          break;
          case "/":
          resultado = divisao(opc1, opc2);
          break;
          case "pot":
          resultado = potencia(opc1, opc2);       
          break;
          case "raiz":
          resultado = raiz(opc1, opc2);
          break;
          default:
          break;
        }

        //convertendo para String
        String resultadoStr = Double.toString(resultado);
        res.setContentType("text/plain");
        req.setAttribute("op1", opc1);
        req.setAttribute("op2", opc2);
        PrintWriter pw = res.getWriter();
        pw.write(resultadoStr);
        pw.close();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
        EntityManager em = emf.createEntityManager();


        Calculadora calc = new Calculadora();
        calc.setOperacao(opc1+" "+operacao+" "+opc2+" = "+resultadoStr);
        Date x=new Date();
        calc.setData(x);

        em.getTransaction().begin();
        em.persist(calc);
        em.getTransaction().commit();


      }catch (Exception e){}
      break;
      case "/historico.action":
      try{

        CalculadoraService calcSer = new CalculadoraService();
        List<Calculadora> registros = calcSer.list();     
        req.setAttribute("registro", registros);


        req.getRequestDispatcher("/jsp/historico.jsp").forward(req, res);
      }catch (Exception e){}
      break;
      default:
      try{
       sc.getRequestDispatcher("/jsp/nao_encontrado.jsp").forward(req, res);
     }catch (Exception e){}               
   }      
 } 
 private double soma(double opc1, double opc2){
   return opc1 + opc2;
 }
 private double subtracao(double opc1, double opc2){
   return opc1 - opc2;
 }
 private double multiplicacao(double opc1, double opc2){
   return opc1 * opc2;
 }
 private double divisao(double opc1, double opc2){
  if (opc2 == 0) {
    return (-1);
  }
  return (opc1 / opc2);
}

private double potencia(double opc1, double opc2) {
 if (opc2 <0 ){
   return 0;
 }

 if (opc1==1){
  return 1;
}

int potencia=1;

for ( int i = 0 ; i < opc2; i++){
 potencia *= opc1;
}

return potencia; 
}
private double raiz(double opc1, double opc2) {
 double t;

 double squareRoot = opc1 / opc2;

 do {
  t = squareRoot;
  squareRoot = (t + (opc1 / t)) / opc2;
} while ((t - squareRoot) != 0);

return squareRoot;
}


}
