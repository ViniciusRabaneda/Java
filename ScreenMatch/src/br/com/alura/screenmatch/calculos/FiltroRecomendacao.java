package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {
    public void filtra(Classificavel classificavel){ // Permite ser utilizado por "Qualquer coisa" que possa ser classificado.Define quais métodos devem ser implementados pelas classes que o implementarem (implements), permite que diferentes classes possam ser tratadas de maneira padronizada.
        if (classificavel.getClassificacao() >=4){
            System.out.println("Esta entre os preferidos");
        } else if(classificavel.getClassificacao()>=2){
            System.out.println("Muito bem avaliado");
        }else{
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }


}
