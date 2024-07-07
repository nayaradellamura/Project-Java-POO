package ma2;

public class Filme extends Prod_Visu {
    // atributos
    private float duracao;
    
    // construtor
    public Filme(String titulo, int anoLanc, String diretor, String produtora, String genero, Protagonista ator, float duracao2) {
        super(titulo, anoLanc, diretor, produtora, genero, ator);
        this.duracao = duracao2;
        
    }
    
    public float getDuracao() {
        return duracao;
    }
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    @Override
    public void tempoMaratona() {
        int totalMinutos = (int) duracao;
        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;
        System.out.println(horas + " horas e " + minutos + " minutos de maratona!");
    }
    // método toString
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        builder.append("Filme [\n");
        builder.append("titulo = ").append(this.getTitulo()).append(",\n");
        builder.append("Ano = ").append(this.getAnoLancamento()).append(",\n");
        builder.append("Diretor = ").append(this.getDiretor()).append(",\n");
        builder.append("Produtora = ").append(this.getProdutora()).append(",\n");
        builder.append("Genero = ").append(this.getGenero()).append(",\n");
        builder.append("Duracao =").append(duracao).append(" minutos\n");
        builder.append("Avaliacao = ").append(this.getMediaAvaliacao()).append(" Estrelas\n");
        builder.append("Quantia de avaliacoes = ").append(this.getAvaliacoes().size()).append("\n]");
        return builder.toString();
    }
}
