public class Instancia {
        public static void instancia() {
                Paciente Paciente = new Paciente("Maria", "03446526536", "maria@example.com", "Rua B", "senhaPaciente");
                Consultorio.cadastrarNovoUsuario(Paciente);

                Paciente Paciente1 = new Paciente("Joao", "03446526536", "joao@email.com", "Rua A, 123", "senha123");
                Consultorio.cadastrarNovoUsuario(Paciente1);

                Paciente Paciente2 = new Paciente("Maria", "03446526536", "maria@email.com", "Rua B, 456", "senha456");
                Consultorio.cadastrarNovoUsuario(Paciente2);

                Funcionario Funcionario = new Funcionario("Joao", "03446526536", "joao@example.com", "Rua A", "senha");
                Consultorio.cadastrarNovoUsuario(Funcionario);

                Funcionario Funcionario1 = new Funcionario("Carlos", "03446526536", "carlos@email.com", "Rua C, 789",
                                "senha789");
                Consultorio.cadastrarNovoUsuario(Funcionario1);

                Funcionario Funcionario2 = new Funcionario("Ana", "03446526536", "ana@email.com", "Rua D, 1011",
                                "senha1011");
                Consultorio.cadastrarNovoUsuario(Funcionario2);

        }
}