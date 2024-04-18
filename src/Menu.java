import java.util.Scanner;

public class Menu {
    private static Scanner scanner;

    public Menu() {}

    public static void setScanner(Scanner sc) {
        scanner = sc;
    }

    public void exibirMenu() throws Exception {
        int opcaoMenu = 0;
        do {
            System.out.println("");
            System.out.println("---------- MENU ----------");
            System.out.println("1. Fazer login");
            System.out.println("2. Cadastrar novo Funcionário");
            System.out.println("3. Excluir usuário");
            System.out.println("4. Encerrar programa");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoMenu) {
                case 1:
                    Usuario user = autenticarUsuario();
                    if (user == null) {
                        System.out.println("");
                        System.out.println("!!!!! Falha na autenticação. !!!!!");
                    } else {
                        user.exibirMenu();
                    }
                    break;
                case 2:
                    Funcionario.menuDeCadastro();
                    break;
                case 3:
                    excluirUsuario();
                    break;
            }
        } while (opcaoMenu != 4);
    }

    public Usuario autenticarUsuario() throws Exception {
        Usuario usuarioAutenticado = null;
        boolean autenticado = false;

        while (!autenticado) {
            try {
                System.out.print("Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                System.out.print("Digite a senha do usuário: ");
                String senha = scanner.nextLine();

                usuarioAutenticado = Consultorio.autenticaUsuario(nome, senha);

                if (usuarioAutenticado != null) {
                    autenticado = true;
                    System.out.println("");
                    System.out.println("Usuário autenticado! Bem-vindo, " + usuarioAutenticado.getNome() + ".");
                } else {
                    System.out.println("");
                    System.out.println("Usuário ou senha incorretos. Deseja tentar novamente? (S/N)");
                    String resposta = scanner.nextLine().toUpperCase();

                    if (!resposta.equals("S")) {
                        autenticado = true;
                    }
                }
            } catch (Exception e) {
                throw new Exception("Erro ao autenticar usuário: " + e.getMessage());
            }
        }
        return usuarioAutenticado;
    }

    private void excluirUsuario() throws Exception {
        Usuario user = autenticarUsuario();
        if (user == null) {
            System.out.println("");
            System.out.println("!!!!! Falha na autenticação. !!!!!");
        } else {
            try {
                Consultorio.excluirUsuario(user.getNome());
            } catch (Exception e) {
                throw new Exception("Erro ao excluir usuário: " + e.getMessage());
            }
        }
    }
}
