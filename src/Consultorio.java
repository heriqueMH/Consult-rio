import java.util.ArrayList;
import java.util.List;

public class Consultorio {
    private static Consultorio instancia = null;
    private List<Usuario> userCadastrado = new ArrayList<>();

    public Consultorio() {}

    public static Consultorio getInstancia() {
        if (instancia == null) {
            instancia = new Consultorio();
        }
        return instancia;
    }

    public Usuario getUsuario(String nomeBusca) {
        for (Usuario usuario : userCadastrado) {
            if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario getPaciente(String cpf) {
        for (Usuario paciente : userCadastrado) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public void exibirTodosPacientes() {
        System.out.println();
        System.out.println("----- LISTA DE PACIENTES -----");
        for (int i = 0; i < this.userCadastrado.size(); i++) {
            if (userCadastrado instanceof Paciente) {
                Paciente paciente = (Paciente) userCadastrado;
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("E-mail: " + paciente.getEmail());
                System.out.println("Endereço: " + paciente.getEndereco());
                System.out.println("------------------------------------");
            }
        }
    }

    public void cadastrarNovoUsuario(Usuario novoUsuario) {
        userCadastrado.add(novoUsuario);
        System.out.println("");
        System.out.println("!!!!! Usuário cadastrado com sucesso. !!!!!");
    }
    
    public void excluirUsuario(String nome) {
        for (int i = 0; i < this.userCadastrado.size(); i++) {
            if (this.userCadastrado.get(i).getNome().equals(nome)) {
                this.userCadastrado.remove(i);
                System.out.println("");
                System.out.println("!!!!! Paciente removido com sucesso. !!!!!");
                return;
            }
        }
        
        System.out.println("");
        System.out.println("!!!!! Paciente não encontrado. !!!!!");
    }

    public Usuario autenticaUsuario(String nome, String senha) throws AutenticacaoException {
        Usuario usuario = getUsuario(nome);
        
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            throw new AutenticacaoException("Usuário ou senha incorretos!");
        }
    }

}
