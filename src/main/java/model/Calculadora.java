/*
** This file contains the persistence class.
** Each class attribute is known as persistence attribute
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity(name="calculadora")
public class Calculadora { //persistence class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;  
 	
    @Column(name="operacao")
    private  String operacao;
	
    @Column(name="data")
    private Date data;

    public Calculadora(){}          //zero parameter constructor
    public String getOperacao() {   
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;

    }
    public Date getData() {   
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }  
}
