/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    //vamos criar um método do tipo
    //Connection
    public Connection getConnection(){
        String usuario, senha, banco;
        try{
            //vamos criar os atributos
            //para acessar o banco
            String url;
            banco="projetobanco";
            usuario="vitor";
            senha="postdba";
            url="jdbc:postgresql://"
                    + "localhost:5432/"+banco;
            //se tudo der certo
            //o código vai estabelcer 
            //conexão com o BD
            return DriverManager.getConnection(url,
                    usuario,senha);
            
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
