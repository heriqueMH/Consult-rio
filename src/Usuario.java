public abstract class Usuario {
  private String nome;
  private String cpf;
  private String email;
  private String endereco;
  private String senha;

  public Usuario(String nome, String cpf, String email, String endereco, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.endereco = endereco;
    this.senha = senha;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  protected String getSenha() {
    return this.senha;
  }

  public boolean senhaValida(String senha) {
    return this.senha.equals(senha);
}

  public abstract void exibirMenu() throws Exception;

}


