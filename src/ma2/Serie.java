package ma2;




public class Serie extends Prod_Visu {
    // atributos
    private int episodios;
    private int temporadas;
    private float duracao;
    
    // construtor
    public Serie(String titulo, int anoLanc, String diretor, String produtora, String genero, Protagonista ator, int episodios, int temporadas, float duracao) {
        super(titulo, anoLanc, diretor, produtora, genero, ator);
        this.episodios = episodios;
        this.temporadas = temporadas;
        this.duracao = duracao;
    }
    
    // métodos get e set
    public int getEpisodios() {
        return episodios;
    }
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public float getDuracao() {
        return duracao;
    }
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    // método para exibir tempo total de maratona
    @Override
    public void tempoMaratona() {
        int totalMinutos = (int) (episodios * temporadas * duracao);
        int horas = totalMinutos / 60;
        int minutos = totalMinutos % 60;
        System.out.println(horas + " horas e " + minutos + " minutos de maratona!");
    }
    // método toString
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
        builder.append("Série [\n");
        builder.append("titulo = ").append(this.getTitulo()).append(",\n");
        builder.append("Ano = ").append(this.getAnoLancamento()).append(",\n");
        builder.append("Diretor = ").append(this.getDiretor()).append(",\n");
        builder.append("Produtora = ").append(this.getProdutora()).append(",\n");
        builder.append("Genero = ").append(this.getGenero()).append(",\n");
        builder.append("Duracao =").append(duracao).append(" minutos\n]");
        builder.append("Avaliacao = ").append(this.getMediaAvaliacao()).append(" estrelas\n");
        builder.append("Quantia de avaliacoes =").append(this.getAvaliacoes().size()).append("\n]");
        return builder.toString();
    }
    
}
