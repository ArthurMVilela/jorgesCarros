package Persistencia;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface com os métodos necessários para gerenciar
 * a persistencia dos dados das classes entidades
 */
public interface DAO<Tipo> {
    public Tipo buscar(Tipo t) throws SQLException;
    public List<Tipo> buscarMultiplos(String filtro) throws SQLException;
    public List<Tipo> buscarTodos() throws SQLException;
    public Tipo inserir(Tipo t) throws SQLException;
    public boolean excluir(Tipo t) throws SQLException;
    public Tipo atualizar(Tipo t) throws SQLException;
}
