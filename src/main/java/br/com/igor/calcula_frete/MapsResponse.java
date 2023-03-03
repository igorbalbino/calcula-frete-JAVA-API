package br.com.igor.calcula_frete;

import java.util.Arrays;

public class MapsResponse {

    public MapsResponse() {}

    public MapsResponse(String[] enderecoDest, String[] enderecoOri, Object[] rows, String status) {
            this.enderecoDest = enderecoDest;
            this.enderecoOri = enderecoOri;
            this.rows = rows;
            this.status = status;
    }

    private String[] enderecoDest;

    private String[] enderecoOri;

    private Object[] rows;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getEnderecoDest() {
        return enderecoDest;
    }

    public void setEnderecoDest(String[] enderecoDest) {
        this.enderecoDest = enderecoDest;
    }

    public String[] getEnderecoOri() {
        return enderecoOri;
    }

    public void setEnderecoOri(String[] enderecoOri) {
        this.enderecoOri = enderecoOri;
    }

    public Object[] getRows() {
        return rows;
    }

    public void setRows(Object[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "MapsResponse{" +
                "enderecoDest=" + Arrays.toString(enderecoDest) +
                ", enderecoOri=" + Arrays.toString(enderecoOri) +
                ", rows=" + Arrays.toString(rows) +
                ", status='" + status + '\'' +
                '}';
    }
}
