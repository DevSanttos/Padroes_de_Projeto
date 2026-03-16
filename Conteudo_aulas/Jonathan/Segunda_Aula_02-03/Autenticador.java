public class Autenticador {

    public boolean autenticar(String usuario, String senha) {

        BancoUsuarios banco = new BancoUsuarios();
        EmailService email = new EmailService();

        Usuario u = banco.buscar(usuario);

        if (u == null) {
            return false;
        }

        if (!u.getSenha().equals(senha)) {
            email.enviar(usuario, "Tentativa de login inválida");
            return false;
        }

        if (u.isBloqueado()) {
            email.enviar(usuario, "Usuário bloqueado");
            return false;
        }

        return true;
    }
}