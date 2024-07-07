package ma2;

import java.util.ArrayList;

public class Prod_Visu implements Classificacao, Tempo {
    // atributos
    private String titulo;
    private int anoLancamento;
    private String diretor;
    private String produtora;
    private String genero;
    private int total = 0;
    private ArrayList<Integer> avaliacoes;
	private Protagonista ator;
    
    // construtor
    public Prod_Visu(String titulo, int anoLancamento, String diretor, String produtora, String genero, Protagonista ator) {
    	
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.produtora = produtora;
        this.genero = genero;
        this.avaliacoes = new ArrayList<>();
        this.ator = ator;
    }

    // métodos get e set
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getProdutora() {
        return produtora;
    }
    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
	public Protagonista getAtor() {
		return ator;
	}
	public void setAtor(Protagonista ator) {
		this.ator = ator;
	}
	
	public ArrayList<Integer> getAvaliacoes() {
		return avaliacoes;
	}
	public boolean avaliar(int avaliacao) {
        if (avaliacao >= 1 && avaliacao <= 5) {
            avaliacoes.add(avaliacao);
            return true;
        } else {
            return false;
        }
    }

    public double getMediaAvaliacao() {
        if (avaliacoes.isEmpty()) {
            return 0;
        }
        int soma = 0;
        for (int avaliacao : avaliacoes) {
            soma += avaliacao;
        }
        return (double) soma / avaliacoes.size();
    }
    
    // método para exibir tempo total de maratona
    public void tempoMaratona() {
    }
    
    // método toString
    
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        builder.append("Titulo=").append(titulo).append("\n");
        builder.append("Ano=").append(anoLancamento).append("\n");
        builder.append("Diretor=").append(diretor).append("\n");
        builder.append("Prdutora=").append(produtora).append("\n");
        builder.append("Genero=").append(genero).append("\n");
        builder.append("Avaliacao=").append(this.getMediaAvaliacao()).append("\n");
        builder.append("Quantia de avaliacoes=").append(this.avaliacoes.size()).append("\n");
        builder.append("\n");
        return builder.toString();
    }


}