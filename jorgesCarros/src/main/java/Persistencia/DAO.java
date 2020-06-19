/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 * Interface com os métodos necessários para gerenciar
 * a persistencia dos dados das classes entidades
 */
public interface DAO<Tipo> {
    public Tipo buscar(Tipo t);
    public List<Tipo> buscarMultiplos(String filtro);
    public List<Tipo> buscarTodos();
    public Tipo inserir(Tipo t);
    public boolean excluir(Tipo t);
    public Tipo atualizar(Tipo t);
}
