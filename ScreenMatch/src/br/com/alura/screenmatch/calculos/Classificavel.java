package br.com.alura.screenmatch.calculos;

public interface Classificavel { // interface é uma forma de termos métodos comuns entre classes distintas "sem utilizar a herança".
    int getClassificacao(); // retorna "estrela" ao inves da nota. Ela esa sem parâmetos pois sofrerá um override de acordo com a classe.

}
