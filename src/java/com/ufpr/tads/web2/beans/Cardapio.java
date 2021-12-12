package com.ufpr.tads.web2.beans;

import java.util.Date;

/**
 *
 * @author julia
 */
public class Cardapio {
    private int id;
    private Date data;

    public Cardapio() {
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
