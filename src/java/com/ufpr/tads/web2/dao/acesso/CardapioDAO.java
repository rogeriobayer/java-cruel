package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.Cardapio;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class CardapioDAO {

    private static final String QUERY_BUSCAR = "select cardapio.id as cardapio_id, cardapio.data, refeicao.id as refeicao_id, refeicao.turno, ingrediente.nome from cardapio\n"
            + "left join refeicao in cardapio.id = refeicao.id_cardapio\n"
            + "left join refeicao_ingrediente in refeicao.id = refeicao_ingrediente.id_refeicao\n"
            + "left join ingrediente in refeicao_ingrediente.id_ingrediente = ingrediente.id\n"
            + "where cardapio.id = ?;";

    private static final String QUERY_BUSCA_MESES = "select distinct to_number(to_char(data, 'MM'),'99G999D9S') mes from cardapio;";

    private Connection con = null;

    public CardapioDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar cardapioDAO.");
        }
        this.con = con;
    }

    public List<Integer> buscarMeses() throws DAOException {
        List<Integer> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCA_MESES)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("mes"));
                lista.add(rs.getInt("mes"));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as pessoas: "
                    + QUERY_BUSCA_MESES, e);

        }
    }

    public Cardapio buscar(int id) throws Exception {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cardapio t = new Cardapio();
                t.setId(rs.getInt("id"));
                t.setData(rs.getDate("data"));
                return t;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Erro buscando tipo: " + id, e);
        }
    }
}
