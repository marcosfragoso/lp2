package agenda;

/**
 * Representação de uma Agenda que mantém uma lista de contatos e favoritos.
 * Nela é possível armazenar e gerenciar contatos.
 * 
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 *
 */
public class Agenda {
	/**
	 * Armazena o tamanho máximo de contatos da Agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;

	/**
	 * Armazena o tamanho máximo de favoritos da Agenda.
	 */
	private static final int TAMANHO_AGENDA_FAV = 10;

	/**
	 * Armazena os contatos da agenda num array.
	 */
	private Contato[] contatos;

	/**
	 * Armazena os contatos favoritos da agenda num array.
	 */
	private Contato[] favoritos;

	/**
	 * Construtor que cria uma nova instância da classe Agenda.
	 * O número máximo de contatos e favoritos já são pré definidos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_AGENDA_FAV];
	}

	/**
	 * É um getter que acessa todos os contatos favoritos da agenda.
	 * @return Um array com todos os contatos favoritos da agenda.
	 */
	public Contato[] getFavoritos() {
		return favoritos;
	}

	/**
	 * É um getter que acessa todos os contatos da agenda.
	 * @return Um array com todos os contatos da agenda.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados completos de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Símbolo de coração em caso de favorido, nome completo e telefone. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}

	/**
	 * Retorna todos os contatos que contém no nome ou no sobrenome o nome passado.
	 *
	 * @param nomeOrSobrenome O nome que deseja buscar
	 * @return Todos os contatos que contém no nome/sobrenome o parametro passado.
	 */
	public String getContatos(String nomeOrSobrenome) {
		String retorno = "";
		int contador = 1;
		for (Contato contato : this.contatos) {
			if (contato != null && (contato.getNome().equals(nomeOrSobrenome) || contato.getSobrenome().equals(nomeOrSobrenome))){
				retorno += "\n" + contador + " - " + contato.toString();
			}
			contador ++;
		}
		return retorno;
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Só é permitido cadastrar contato nas posições entre 1 e 100.
	 * Não é permitido cadastro sem telefone ou nome.
	 *
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		}

		for (Contato contato : getContatos()) {
			if (contato != null && contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)) {
				return "CONTATO JA CADASTRADO";
			}
		}

		if (nome == null || telefone == null || telefone.isEmpty() || nome.isEmpty()) {
			return "CONTATO INVALIDO";
		}

		Contato contato = new Contato(nome, sobrenome, telefone);
		this.contatos[posicao - 1] = contato;
		return "CADASTRO REALIZADO";
	}

	/**
	 * Lista todos os contatos existentes na agenda.
	 *
	 * @return Nome completo, incluindo nome e sobrenome de cada contato existente na agenda. Em caso de favorito aparecec um coração.
	 */
	public String listarContatos() {
		String retorno = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				retorno += "\n" + (i + 1) + " - " + this.contatos[i].getNome() + " " + this.contatos[i].getSobrenome();
			}
		}
		return retorno;
	}

	/**
	 * Adiciona um determinado contato em uma posição aos favoritos. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * Não é permitido adicionar um contato que já está na lista dos favoritos.
	 *
	 * @param contato A posição na lista de contatos do contato a ser adicionado nos favoritos.
	 * @param posicao A posição em que o contato vai ser adicionado na lista de favoritos.
	 * @return Uma String representando se o contato foi adicionado. Se ele já existe, se foi adicionado ou se a posição é inválida.
	 */
	public String adicionarFavorito(int contato, int posicao) {

		if (posicao < 1 || posicao > 10) {
			return "POSIÇÃO INVÁLIDA";
		}

		boolean jaEhFavorito = false;
		for (Contato c : this.favoritos) {
			if (this.contatos[contato - 1].equals(c)) {
				jaEhFavorito = true;
			}
		}
		if (jaEhFavorito) {
			return "CONTATO JÁ EXISTE NA LISTA DE FAVORITOS";
		}

		if (this.favoritos[posicao - 1] != null) {
			this.favoritos[posicao - 1].setFavorito(false);
			Contato contatoInserido = getContato(contato);
			contatoInserido.setFavorito(true);
			this.favoritos[posicao - 1] = getContato(contato);
			return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
		}

		Contato contatoInserido = getContato(contato);
		contatoInserido.setFavorito(true);
		this.favoritos[posicao - 1] = getContato(contato);
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
	}

	/**
	 * Lista todos os contatos favoritos existentes na agenda.
	 *
	 * @return Nome completo, incluindo nome e sobrenome de todos os contatos favoridos e um símbolo representando que é favorito.
	 */
	public String listarFavoritos() {
		String favoritos = "";
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				favoritos += "\n" + (i + 1) + " - " + this.favoritos[i].toString();
			}
		}
		return favoritos;
	}

	/**
	 * Remove um contato de uma posição da lista de favoritos.
	 * @param posicao A posição que deseja remover o contato.
	 * @return Uma String representando se o contato foi removido. Se o contato foi removido ou se não existe o contato nessa posição.
	 */
	public String removerFavorito(int posicao) {
		if (this.favoritos[posicao - 1] != null) {
			this.favoritos[posicao - 1].setFavorito(false);
			this.favoritos[posicao - 1] = null;
			return "CONTATO REMOVIDO COM SUCESSO";
		} else {
			return "NÃO EXISTE FAVORITO NESSA POSIÇÃO";
		}
	}

	/**
	 * Remove um contato da agenda de acordo com a posição passada.
	 *
	 * @param posicao A posição que o contato a ser removido se encontra.
	 * @return Uma String representando se o contato foi removido ou se ele não existe na agenda.
	 */
	public String removerContato(int posicao) {
		if (posicao < 1 || posicao > 100) { throw new IndexOutOfBoundsException("ERRO: Posição inválida!"); }

		if (this.contatos[posicao - 1] != null) {
			if (this.contatos[posicao - 1].isFavorito()){
				for (int i = 0; i < this.favoritos.length; i++) {
					if (this.contatos[posicao - 1].equals(this.favoritos[i])) {
						this.removerFavorito(i);
					}
				}
			}
			this.contatos[posicao - 1] = null;
			return ("CONTATO REMOVIDO COM SUCESSO!");
		}
		return "CONTATO NÃO EXISTE NA AGENDA!";
	}





}
