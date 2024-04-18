import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Instancia.instancia();
        Menu menu = new Menu();
        Menu.setScanner(sc);
        Paciente.setScanner(sc);
        Funcionario.setScanner(sc);
        menu.exibirMenu();
        sc.close();
    }



 /*
 * Autores: [Matheus Henrique de Oliveira Santos - RA | 10409051]
 *          [Cleide Lustosa                      - RA | 10409459]
 * Data de criação: [05/03/2024]
 */
}
