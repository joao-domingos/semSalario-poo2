public class User {
	private String name;
	private int cpf;
	private String email;
	private String senha;

	private aluno(String name,
			int cpf,
			String email,
			String senha
			) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public String getName() {
		return name;
	}

	public int getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
