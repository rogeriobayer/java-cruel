package com.ufpr.tads.web2.dao.acesso;

import com.ufpr.tads.web2.beans.Cardapio;
import com.ufpr.tads.web2.beans.Refeicao;
import com.ufpr.tads.web2.beans.RefeicaoIngrediente;
import com.ufpr.tads.web2.facade.RefeicaoFacade;
import exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author julia
 */
public class CardapioDAO {

    private static final String QUERY_BUSCAR_CARDAPIO = "SELECT id, data from cardapio where id = ?;";

    private static final String QUERY_BUSCAR_INGREDIENTES = "SELECT id, id_refeicao, id_ingrediente, quantidade, nome from refeicao_ingrediente, ingrediente\n"
            + "where ingrediente.id = id_ingrediente and id_refeicao = ?;";

    private static final String QUERY_BUSCAR_TODOS = "select *, cast(date_part('day',data) as integer) as diaMes from cardapio;";

    private Connection con = null;

    public CardapioDAO(Connection con) throws Exception {
        if (con == null) {
            throw new Exception("Conexão nula ao criar cardapioDAO.");
        }
        this.con = con;
    }

    public CardapioDAO() {

    }

    public List<Cardapio> buscarTodos() throws DAOException {
        List<Cardapio> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cardapio tipo = new Cardapio();
                tipo.setId(rs.getInt("id"));
                tipo.setData(rs.getDate("data"));
                tipo.setDiaMes(rs.getInt("diaMes"));
                lista.add(tipo);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as pessoas: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    public List<Cardapio> buscarMes(int mes, int ano) throws Exception {
        int diasMes = getQuantidadeDiasByMes(mes);
        String QUERY_BUSCA_MES = "select id, data, cast(date_part('day',data) as integer) as diaMes from cardapio where data between '01-" + mes + "-" + ano + "' and '" + diasMes + "-" + mes + "-" + ano + "';";
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCA_MES)) {
            List<Cardapio> lista = new ArrayList<>();

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cardapio t = new Cardapio();
                t.setId(rs.getInt("id"));
                t.setData(rs.getDate("data"));
                t.setDiaMes(rs.getInt("diaMes"));
                lista.add(t);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Erro buscando mes: " + mes, e);
        }
    }

    public Cardapio buscar(int cardapio_id) throws Exception {
        List<RefeicaoIngrediente> listaRefeicaoIngrediente = new ArrayList<>();
        Cardapio t = new Cardapio();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_CARDAPIO)) {
            st.setInt(1, cardapio_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                t.setId(rs.getInt("id"));
                t.setData(rs.getDate("data"));
                
                List<Refeicao> refeicoes = RefeicaoFacade.buscar(cardapio_id);
                t.setRefeicoes(refeicoes);

                refeicoes.forEach(ref -> {
                    System.out.println(ref.getId());
                });

            }
            return t;
        } catch (SQLException e) {
            throw new Exception("Erro buscando cardapio de id: " + cardapio_id, e);
        }
    }

    public static int getQuantidadeDiasByMes(int mes) {
        Calendar datas = new GregorianCalendar();
        datas.set(Calendar.MONTH, mes - 1);//2
        int quantidadeDias = datas.getActualMaximum(Calendar.DAY_OF_MONTH);
        return quantidadeDias;
    }

}
