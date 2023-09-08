/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    PreparedStatement prep;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
  
        conectaDAO conecta = new conectaDAO();

        try {

            prep = conecta.conectar().prepareStatement("INSERT INTO produtos(nome,valor,status) VALUES(?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            conecta.desconectar();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar dados."+ ex.getMessage());
            return false;
        }
        
    }
    
    public void venderProduto (int idVendido){
        
        conectaDAO conecta = new conectaDAO();
        
        try {
            
           prep = conecta.conectar().prepareStatement("UPDATE produtos SET status = 'Vendido' WHERE id = "+idVendido + ";");
           prep.executeUpdate();
           conecta.desconectar();
           JOptionPane.showMessageDialog(null, "Produto Vendido com sucesso.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto."+ e.getMessage());
        }
    
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

