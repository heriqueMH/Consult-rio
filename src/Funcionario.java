import java.util.Scanner;

public class Funcionario extends Usuario {
    private static Scanner scanner;

    public Funcionario(String nome, String cpf, String email, String endereco, String senha) {
        super(nome, cpf, email, endereco, senha);
    }

    public static void setScanner(Scanner sc) {
        scanner = sc;
    }

    @Override
    public void exibirMenu() throws Exception {
        int opcaoMenu;
        do {
            System.out.println("");
            System.out.println("----- MENU DO FUNCIONÁRIO -----");
            System.out.println("1. Buscar Paciente");
            System.out.println("2. Cadastrar Paciente");
            System.out.println("3. Listar todos Pacientes");
            /* System.out.println("4. Consultar agendamentos de paciente");  */
            System.out.println("4. Desligar Paciente");
            System.out.println("5. Fazer logoff");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMenu) {
                case 1:
                System.out.println("Digite o CPF do paciente:");
                String cpfStr = scanner.nextLine();
                
                if (!validarCPF(cpfStr)) {
                    throw new CPFException("CPF inválido!");
                }
                
                Usuario usuario = Consultorio.getPaciente(cpfStr);
                
                if (usuario != null) {
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("CPF: " + usuario.getCpf());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Endereço: " + usuario.getEndereco());
                } else {
                    System.out.println("Usuário não encontrado.");
                }
                    break;
                case 2:
                    Paciente.menuDeCadastro();
                    break;
                case 3:
                    Consultorio.exibirTodosPacientes();
                    break;
                /* case 4:

                    break; */
                case 4:
                    System.out.println("");
                    System.out.print("Digite a senha para confirmar a remoção do paciente: ");
                    String senha = scanner.next();
                    removerPaciente(senha);
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("!!!!! Saindo do programa... !!!!!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoMenu != 5);
    }


    public static void menuDeCadastro() throws Exception {
        setScanner(scanner);
            System.out.println("");
            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a senha do funcionário: ");
            String senha = scanner.nextLine();
            System.out.print("Digite o CPF do funcionário: ");
            String cpfStr = scanner.nextLine();
            if (!validarCPF(cpfStr)) {
                throw new CPFException("CPF inválido!");
            }
            System.out.print("Digite o email do funcionário: ");
            String email = scanner.nextLine();
            System.out.print("Digite o endereço do funcionário: ");
            String endereco = scanner.nextLine();

            Funcionario funcionario = new Funcionario(nome, cpfStr, email, endereco, senha);
            Consultorio.cadastrarNovoUsuario(funcionario);
    }

    public static boolean validarCPF(String cpfStr) {
        if (cpfStr.length() != 11) {
            return false;
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpfStr.charAt(i) - '0') * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }
        
        if ((cpfStr.charAt(9) - '0') != primeiroDigito) {
            return false;
        }
        
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpfStr.charAt(i) - '0') * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }
        
        return (cpfStr.charAt(10) - '0') == segundoDigito;
    }

    public void removerPaciente(String senha) {
        Usuario pacienteDesligar = null;
        if (senha.equals(getSenha())) {
            System.out.println("");
            System.out.println("----- EXCLUSÃO DE PACIENTE -----");
            System.out.print("Digite o CPF do Paciente a ser removido: ");
            String cpfStr = scanner.nextLine();
        
            pacienteDesligar = Consultorio.getPaciente(cpfStr);

            if (pacienteDesligar != null) {
                Consultorio.excluirUsuario(pacienteDesligar.getNome());
                System.out.println("");
                System.out.println("!!!!! Paciente removido com sucesso. !!!!!");
              } else {
                System.out.println("");
                System.out.println("!!!!! Paciente não encontrada. !!!!!");
              }
        } else {
            System.out.println("");
            System.out.println("!!!!! Senha incorreta. Remoção não realizada. !!!!!");
        }
    }
}
