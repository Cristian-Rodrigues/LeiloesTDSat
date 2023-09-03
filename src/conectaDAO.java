
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
     Connection con;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes_tdsat", "root", "garoto10");
            System.out.println("Conexão realizada com sucesso");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }

    public boolean desconectar() {
        try {
            con.close();
            System.out.println("Conexão desconectada.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
            return false;

        }
    } 
}
