package ma2;

public class Usuario {
    public static final int TIPO_NORMAL = 0;
    public static final int TIPO_ADMIN = 1;

    private String nomeUsuario;
    private String senha;
    private int tipoUsuario;

    public Usuario(String nomeUsuario, String senha, int tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }
}
