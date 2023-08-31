package controle;

/**
 * Representação de um estudante de computação da UFCG.
 * Cada instância desta classe mantém informações como nome, matrícula, cra, ano de nascimento.
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Aluno {

	/**
	 * Nome do aluno.
	 */
	private String nome;

	/**
	 * Matrícula do aluno no formato "0000000000".
	 */
	private String matricula;

	/**
	 * Coeficiente de rendimento acadêmico do aluno.
	 */
	private double cra;

	/**
	 * Ano de nascimento do aluno.
	 */
	private int anoNascimento;

	/**
	 * Construtor para criar um objeto Aluno com nome e ano de nascimento.
	 *
	 * @param anoNascimento Ano de nascimento do aluno no formato YYYY.
	 * @param nome O nome do aluno.
	 */
	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
	}

	/**
	 * Construtor para criar um objeto Aluno com nome e matrícula.
	 *
	 * @param matricula A matrícula do aluno no formato “0000000000”
	 * @param nome O nome do aluno
	 */
	public Aluno(String matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * Um setter que define o coeficiente de rendimento acadêmico do aluno.
	 *
	 * @param cra O valor do CRA a ser definido para o aluno.
	 */
	public void setCra(double cra) {
		this.cra = cra;
	}

	/**
	 * Um getter que obtém a idade do aluno, através do cálculo entre 2023 e o ano de nascimento.
	 *
	 * @return A idade do aluno do tipo inteiro.
	 */
	public int getIdade(){
		return 2023 - anoNascimento;
	}

	/**
	 * Retorna a representação do objeto Aluno em formato de String.
	 * Contém o nome do aluno.
	 *
	 * @return Uma String que representa o objeto Aluno no formato: "Aluno - {nome}"
	 */
	public String toString() {
		return "Aluno - " + this.nome;
	}
}
