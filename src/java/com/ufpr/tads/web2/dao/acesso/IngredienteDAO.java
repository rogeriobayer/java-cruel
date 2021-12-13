package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.Ingrediente;
import com.ufpr.tads.web2.beans.TipoIngrediente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class IngredienteDAO {

     private static final String QUERY_BUSCAR = "SELECT i.id as id, i.nome, i.tipo, i.descricao, ti.nome as nome_ti FROM ingrediente i\n"
            + "left join tipo_ingrediente ti on i.tipo = ti.id where i.id=?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT i.id as id, i.nome, i.tipo, i.descricao, ti.nome as nome_ti FROM ingrediente i\n"
            + "left join tipo_ingrediente ti on i.tipo = ti.id;";
    private static final String QUERY_INSERIR = "INSERT INTO ingrediente(nome, tipo, descricao) VALUES (?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM ingrediente WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE ingrediente SET nome = ?, tipo = ?, descricao = ? WHERE id = ?;";

    private Connection con = null;

    public IngredienteDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar categoriaDAO.");
        }
        this.con = con;
    }

    public Ingrediente buscar(int id) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TipoIngrediente ti = new TipoIngrediente();
                ti.setId(rs.getInt("tipo"));
                ti.setNome(rs.getString("nome_ti"));
                Ingrediente i = new Ingrediente();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setTipo(ti);
                i.setDescricao(rs.getString("descricao"));
                return i;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando ingrediente: " + id, e);
        }
    }

    public List<Ingrediente> buscarTodos() throws Exception {
        List<Ingrediente> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            //System.out.println(QUERY_BUSCAR_TODOS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TipoIngrediente tipo = new TipoIngrediente();
                tipo.setId(rs.getInt("tipo"));
                tipo.setNome(rs.getString("nome_ti"));
                Ingrediente i = new Ingrediente();
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setDescricao(rs.getString("descricao"));
                i.setTipo(tipo);
                lista.add(i);
            }
            System.out.println(lista);
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando todOs os ingredientes: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public void inserir(Ingrediente ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            TipoIngrediente ti = new TipoIngrediente();
            ti = ingrediente.getTipo();
            
            st.setString(1, ingrediente.getNome());
            st.setInt(2, ti.getId());
            st.setString(3, ingrediente.getDescricao());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao criar categoria: "
                    + QUERY_INSERIR, e);
        }
    }

    public void remover(Integer id) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar categoria: "
                    + QUERY_REMOVER, e);
        }
    }

    public void editar(Ingrediente ingrediente) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            
            
            
            TipoIngrediente ti;
            ti = ingrediente.getTipo();
            
            System.out.println( ingrediente.getNome());
             System.out.println( ti.getId());
             System.out.println( ingrediente.getDescricao());
             System.out.println( ingrediente.getId());
             

            st.setString(1, ingrediente.getNome());
            st.setInt(2, ti.getId());
            st.setString(3, ingrediente.getDescricao());
            st.setInt(4, ingrediente.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao editar categoria: "
                    + QUERY_EDITAR, e);
        }
    }
}
