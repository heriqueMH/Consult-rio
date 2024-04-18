import java.util.Scanner;

public class Paciente extends Usuario {
    private static Scanner scanner;

    public Paciente(String nome, String cpf, String email, String endereco, String senha) {
        super(nome, cpf, email, endereco, senha);
    }

    public static void setScanner(Scanner sc) {
        scanner = sc;
    }

    @Override
    public void exibirMenu() {
        int opcaoMenu;
        do {
            System.out.println("");
            System.out.println("-------- MENU DO PACIENTE --------");
/*          System.out.println("1. Agendar Consulta");
            System.out.println("3. Cadastrar Nova Consulta");
            System.out.println("4. Excluir Consulta"); */
            System.out.println("5. Fazer logoff");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMenu) {
  /*            case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break; */
                case 4:
                    System.out.println("");
                    System.out.println("!!!!! Saindo do programa... !!!!!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcaoMenu != 4);
    }

    public static void menuDeCadastro() throws Exception {
        setScanner(scanner);
        try {
            System.out.print("Digite o nome do paciente: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a senha do paciente: ");
            String senha = scanner.nextLine();
            System.out.print("Digite o CPF do paciente: ");
            String cpfStr = scanner.nextLine();
            if (!validarCPF(cpfStr)) {
                throw new CPFException("CPF inválido!");
            }
            System.out.print("Digite o email do paciente: ");
            String email = scanner.nextLine();
            System.out.print("Digite o endereço do paciente: ");
            String endereco = scanner.nextLine();

            Paciente paciente = new Paciente(nome, cpfStr, email, endereco, senha);
            Consultorio.cadastrarNovoUsuario(paciente);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrar paciente: " + e.getMessage());
        }
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
}