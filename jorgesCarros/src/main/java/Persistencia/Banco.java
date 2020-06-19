package Persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Controla a conexão com o banco de dados MySQL
 */
public class Banco {
    private static String usuario, senha, nomeBanco, servidorBanco;
    private static String stringConnection;
    
    private static java.sql.Connection conexao;

    static {
        usuario = "root";
        senha = "test";
        nomeBanco = "jorgescarros";
        servidorBanco = "localhost";
    
    }
    
    public static void abrir() throws SQLException {
        
        stringConnection = "jdbc:mysql://" + servidorBanco + ":3306" + "/" + nomeBanco;
        conexao = DriverManager.getConnection(stringConnection, usuario, senha); 
    }
    
    public static void fechar() throws SQLException {
        conexao.close();
    }
    
    public static java.sql.Connection getConexao() {
        return conexao;
    }
}
