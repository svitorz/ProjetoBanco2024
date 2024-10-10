/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ClienteModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;




public class ClienteDAO {
    //vamos criar um objeto do tipo
    //Connection (SLQ)
    private Connection con;
    
    //vamos criar o método construtor
    //para estabeler a conexão com 
    //o banco de dados predefinido
    //em ConnectionFactory
    
    public ClienteDAO(){
        
        //associa e chama o método
        //para estabelecer a conexão
        this.con = 
           new ConnectionFactory().getConnection();    
    }
    
    //VAMOS CRIAR O MÉTODO PARA CADASTRAR O CLIENTE
    public void cadastrarCliente(
            ClienteModel objCliente){
        
        try{
            String sql;
            sql="insert into cliente (cod,nome,cpf,\n" +
            "  rua,numero,bairro, estado,\n" +
            "  telefone,genero) values (default,"
             + "?,?,?,?,?,?,?,?);";
            
            //conectar ao BD e organizar o código SQL
            PreparedStatement psmt = con.prepareStatement(sql);
            //vamos colocar o nome do objeto criado
            psmt.setString(1, objCliente.getNome());
            psmt.setString(2, objCliente.getCpf());
            psmt.setString(3, objCliente.getRua());
            psmt.setInt(4, objCliente.getNumero());
            psmt.setString(5, objCliente.getBairro());
            psmt.setString(6, objCliente.getEstado());
            psmt.setString(7, objCliente.getTelefone());
            psmt.setString(8, objCliente.getGenero());
            
            //então utilizarmos o código para executar 
            psmt.execute();
            
            //depois de executar vamos fechar a conexão
            psmt.close();
             
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,
               "Erro no SQL: "+e.getMessage());
        }
    }
    
    public List<ClienteModel> listarClientes(){
        try{
           List<ClienteModel> lista = new ArrayList<>();
           String sql = "SELECT * FROM CLIENTE";
           
           PreparedStatement pst = con.prepareStatement(sql);
           ResultSet rs=pst.executeQuery();
           
           while(rs.next()){
               ClienteModel clienteModel = new ClienteModel();
               clienteModel.setCodcli(rs.getInt("cod")); 
               clienteModel.setNome(rs.getString("nome")); 
               clienteModel.setCpf(rs.getString("cpf")); 
               clienteModel.setTelefone(rs.getString("telefone")); 
               clienteModel.setBairro(rs.getString("bairro")); 
               clienteModel.setEstado(rs.getString("estado")); 
               clienteModel.setGenero(rs.getString("genero")); 
               clienteModel.setNumero(rs.getInt("numero")); 
               lista.add(clienteModel);
           }
           return lista;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta ao banco de dados" + e.getMessage());
            return null;
        }
    }
}

