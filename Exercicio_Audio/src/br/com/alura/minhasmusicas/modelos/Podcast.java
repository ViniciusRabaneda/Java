package br.com.alura.minhasmusicas.modelos;

public class Podcast extends Audio {
    private String apresenteador;
    private String descricao;

    public String getApresenteador() {
        return apresenteador;
    }

    public void setApresenteador(String apresenteador) {
        this.apresenteador = apresenteador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int getClassificacao() {
        if (this.getTotalCurtidas() > 500) {
            return 10;
        } else {
            return 8;
        }
    }
}

