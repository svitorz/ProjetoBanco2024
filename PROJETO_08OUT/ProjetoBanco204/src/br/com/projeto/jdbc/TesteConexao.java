/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class TesteConexao {
    public static void main(String[] args) {
        ConnectionFactory objConnection=
                new ConnectionFactory();
        //vamos criar o try catch
        try{
            //vamos chamar o método para
            //estabelcer a conexão
            objConnection.getConnection();
            //se tudo der cert
            JOptionPane.showMessageDialog(null,
                    "Conexão estabelecida!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,
                    "Não conectado:"+e.getMessage());
        }
    }
}
