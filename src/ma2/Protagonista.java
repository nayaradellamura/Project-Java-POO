package ma2;

public class Protagonista {
    // atributos
    private String nome;
    private int idade;
    
    // construtor
    public Protagonista(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // métodos get e set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
