package ma2;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;

    public Sistema() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin", "admin", Usuario.TIPO_ADMIN));
    }
    
    private Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    
    public boolean registrarUsuario(String nomeUsuario, String senha) {
        if (buscarUsuario(nomeUsuario) != null) {
            return false;
        } else {
            usuarios.add(new Usuario(nomeUsuario, senha, Usuario.TIPO_NORMAL));
            return true;
        }
    }

    public Usuario loginUsuario(String nomeUsuario, String senha) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public boolean adicionarAdmin(String nomeUsuario, String senha) {
        if (buscarUsuario(nomeUsuario) != null) {
            return false;
        } else {
            usuarios.add(new Usuario(nomeUsuario, senha, Usuario.TIPO_ADMIN));
            return true;
        }
    }

    public boolean removerAdmin(String nomeUsuario, String adminAtual) {
        Usuario usuarioParaRemover = buscarUsuario(nomeUsuario);
        if (!nomeUsuario.equals(adminAtual) && usuarioParaRemover != null && usuarioParaRemover.getTipoUsuario() == Usuario.TIPO_ADMIN) {
            usuarios.remove(usuarioParaRemover);
            return true;
        }
        return false;
    }

    public void listarAdmins() {
        System.out.println("Administradores atuais:");
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoUsuario() == Usuario.TIPO_ADMIN) {
                System.out.println(usuario.getNomeUsuario());
            }
        }
    }
}
