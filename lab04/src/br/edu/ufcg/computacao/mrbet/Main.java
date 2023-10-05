package br.edu.ufcg.computacao.mrbet;

import java.util.Scanner;


/**
 * Interface com menus e textos para manipular o MrBetSistema
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class Main {
    public static void main(String[] args) {
        MrBetSistema sistema = new MrBetSistema();

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, scanner, sistema);
        }
    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\n========= MrBet =========\n" +
                        "(M)Minha inclusão de times\n" +
                        "(R)Recuperar time\n" +
                        "(.)Adicionar campeonato\n" +
                        "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
                        "(E)Exibir campeonatos que o time participa\n" +
                        "(T)Tentar a sorte e status\n" +
                        "(H)Histórico\n" +
                        "(!)Já pode fechar o programa!\n" +
                        "Opção> "
        );
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao Opção digitada.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     * @param sistema O sistema que estamos manipulando.
     */
    private static void comando(String opcao, Scanner scanner, MrBetSistema sistema) {
        switch (opcao) {
            case "M":
                incluirTime(sistema, scanner);
                break;
            case "R":
                recuperarTime(sistema, scanner);
                break;
            case ".":
                adicionarCampeonato(sistema, scanner);
                break;
            case "B":
                scanner.nextLine();
                System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
                String escolha = scanner.nextLine();
                if (escolha.equalsIgnoreCase("i")) {
                    incluirTimeEmCampeonato(sistema, scanner);
                } else if (escolha.equalsIgnoreCase("v")) {
                    verificarTimeEmCampeonato(sistema, scanner);
                } else {
                    throw new IllegalArgumentException("Entrada inválida!");
                }
                break;
            case "E":
                exibirCampeonatosQueOTimeParticipa(sistema, scanner);
                break;
            case "T":
                scanner.nextLine();
                System.out.println("(A)Apostar ou (S)Status das Apostas?");
                String escolhaAposta = scanner.nextLine();
                if (escolhaAposta.equalsIgnoreCase("a")) {
                    apostar(sistema, scanner);
                } else if (escolhaAposta.equalsIgnoreCase("s")) {
                    statusAposta(sistema);
                } else {
                    throw new IllegalArgumentException("Entrada inválida!");
                }
                break;
            case "H":
                historico(sistema);
                break;
            case "!":
                sai();
                break;
            default:
                throw new IllegalArgumentException("Entrada inválida!");
        }
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nPor hoje é só pessoal!");
        System.exit(0);
    }

    /**
     * Cadastra um time no sistema.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para pedir informações do time.
     */
    private static void incluirTime(MrBetSistema sistema, Scanner scanner) {
        scanner.nextLine();
        System.out.println("\nCódigo: ");
        String codigo = scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Mascote: ");
        String mascote = scanner.nextLine();
        System.out.println(sistema.incluirTime(codigo, nome, mascote));
    }

    /**
     * Imprime os detalhes de um time cadastrado no sistema.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para capturar qual time.
     */
    private static void recuperarTime(MrBetSistema sistema, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println(sistema.recuperarTime(codigo));
    }

    /**
     * Cadastra um campeonato no sistema.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para pedir informações do campeonato.
     */
    private static void adicionarCampeonato(MrBetSistema sistema, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Campeonato: ");
        String nome = scanner.nextLine();
        System.out.println("Participantes: ");
        int participantes = scanner.nextInt();
        System.out.println(sistema.adicionarCampeonato(nome, participantes));
    }

    /**
     * Cadastra um time em um campeonato.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para pedir as informações do time e do campeonato.
     */
    private static void incluirTimeEmCampeonato(MrBetSistema sistema, Scanner scanner) {

        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println(sistema.incluirTimeEmCampeonato(codigo, campeonato));
    }

    /**
     * Imprime se um time está participando de um campeonato.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para pedir as informações do time e do campeonato.
     */
    private static void verificarTimeEmCampeonato(MrBetSistema sistema, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println(sistema.verificaTimeEmCampeonato(codigo, campeonato));
    }

    /**
     * Imprime os campeonatos que um determinado time participa.
     *
     * @param sistema O sistema.
     * @param scanner O scanner para pedir as informações do time.
     */
    private static void exibirCampeonatosQueOTimeParticipa(MrBetSistema sistema, Scanner scanner){
        scanner.nextLine();
        System.out.println("Time: ");
        String codigo = scanner.nextLine();
        System.out.println(sistema.exibirCampeonatosQueOTimeParticipa(codigo));
    }

    /**
     * Realizar uma aposta no sistema.
     *
     * @param sistema O sistema.
     * @param scanner Objeto scanner para pedir as informações do time, do campeonato, do valor e da colocação.
     */
    private static void apostar(MrBetSistema sistema, Scanner scanner) {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Campeonato: ");
        String camp = scanner.nextLine();
        System.out.println("Colocacao: ");
        int colocacao = scanner.nextInt();
        System.out.println("Valor da aposta: R$");
        double valor = scanner.nextDouble();
        System.out.println(sistema.adicionarAposta(codigo, camp, colocacao, valor));
    }

    /**
     * Imprime o status de todas as apostas do sistema.
     *
     * @param sistema O sistema.
     */
    private static void statusAposta(MrBetSistema sistema) {
        System.out.println(sistema.statusApostas());
    }

    /**
     * Mostra o histórico do sistema obtendo as informações de time mais incluido, os times que nao participaram e o primeiro nas apostas.
     *
     * @param sistema O sistema.
     */
    private static void historico(MrBetSistema sistema) {
        System.out.println(sistema.timeMaisIncluido());
        System.out.println(sistema.timesQueNaoParticiparam());
        System.out.println(sistema.primeiroNasApostas());
    }


}
