package controle;


import java.util.Scanner;

/**
 * Classe que faz a interação do usuário com as 4 classes: Descanso, Disciplina, RegistroResumos e RegistroTempoOnline
 *
 * @author Marcos Vinícius Fragoso de Oliveira - 122210469
 */
public class CoisaCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao CoISA - Controle Institucional da Situação Acadêmica\n"
                        + "\nEscolha um número para uma das funcionalidades a seguir:\n"
                        + "[1] Descanso\n"
                        + "[2] Disciplina\n"
                        + "[3] Registro de Resumos\n"
                        + "[4] Registro de Tempo Online\n"
        );

        int escolha = Integer.parseInt(sc.nextLine());

        switch (escolha) {
            case 1:
                menuDescanso();
                break;
            case 2:
                menuDisciplina();
                break;
            case 3:
                menuResumo();
                break;
            case 4:
                menuRegistro();
                break;
            default:
                System.out.println("A função que você digitou não existe. Só existe funções de 1 a 4.");
        }
    }

    public static void menuDescanso() {
        Descanso descanso = new Descanso();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha umas das funcionalidades de Descanso:\n"
                    + "[1] Definir horas de descanso\n"
                    + "[2] Definir quantidade de semanas\n"
                    + "[3] Verificar o status geral do aluno\n"
                    + "[0] Sair\n"
            );

            int funcao = Integer.parseInt(sc.nextLine());
            if (funcao == 0) {
                break;
            }

            switch (funcao) {
                case 1:
                    System.out.println("Digite um número inteiro referente à quantidade de horas que o aluno descansou: ");
                    int qntdHoras = Integer.parseInt(sc.nextLine());
                    descanso.defineHorasDescanso(qntdHoras);
                    break;
                case 2:
                    System.out.println("Digite um número inteiro referente à quantidade de semanas que foi feito o descanso: ");
                    int qntdSemanas = Integer.parseInt(sc.nextLine());
                    descanso.defineNumeroSemanas(qntdSemanas);
                    break;
                case 3:
                    System.out.println(descanso.getStatusGeral());
                    break;
                default:
                    System.out.println("Não existe esssa função.\n");
            }
        }
    }

    public static void menuDisciplina() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione o tipo da disciplina:\n"
                + "[1] Apenas o nome\n"
                + "[2] Nome e quantidade de notas\n"
                + "[3] Nome, quantidade de notas e pesos\n"
        );

        int tipoDisciplina = Integer.parseInt(sc.nextLine());

        Disciplina disciplina = null;
        String nome;
        int qntdNotas;

        if (tipoDisciplina == 1) {
            System.out.println("Nome da disciplina: ");
            nome = sc.nextLine();
            disciplina = new Disciplina(nome);
        } else if (tipoDisciplina == 2) {
            System.out.println("Nome da disciplina: ");
            nome = sc.nextLine();
            System.out.println("Quantidade de notas: ");
            qntdNotas = Integer.parseInt(sc.nextLine());
            disciplina = new Disciplina(nome, qntdNotas);
        } else if (tipoDisciplina == 3) {
            System.out.println("Nome da disciplina: ");
            nome = sc.nextLine();
            System.out.println("Quantidade de notas: ");
            qntdNotas = Integer.parseInt(sc.nextLine());
            double[] pesos = new double[qntdNotas];
            for(int i = 0; i < qntdNotas; i++) {
                System.out.println("Peso da nota " + (i+1) + ": ");
                pesos[i] = Double.parseDouble(sc.nextLine());
            }
            disciplina = new Disciplina(nome, qntdNotas, pesos);
        } else {
            System.out.println("Não existe esta opção.");
        }

        while (true) {
            System.out.println("Escolha umas das funcionalidades de Disciplina:\n"
                    + "[1] Cadastrar horas\n"
                    + "[2] Cadastrar nota\n"
                    + "[3] Verificar se o aluno foi aprovado\n"
                    + "[4] Ver o status geral do aluno na disciplina\n"
                    + "[0] Sair\n"
            );

            int funcao = Integer.parseInt(sc.nextLine());
            if (funcao == 0) {
                break;
            }

            switch (funcao) {
                case 1:
                    System.out.println("Quantidade de horas que deseja cadastrar: ");
                    disciplina.cadastraHoras(Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    System.out.println("Número da nota que deseja cadastrar: ");
                    int nota = Integer.parseInt(sc.nextLine());
                    System.out.println("Valor da nota " + nota + " do aluno: ");
                    disciplina.cadastraNota(nota, Double.parseDouble(sc.nextLine()));
                    break;
                case 3:
                    boolean foiAprovado;
                    if (disciplina.aprovado()) {
                        System.out.println("O aluno foi aprovado.\n");
                    } else {
                        System.out.println("O aluno não foi aprovado.\n");
                    }
                    break;
                case 4:
                    System.out.println(disciplina.toString());
                    break;
                default:
                    System.out.println("A função que você digitou não existe. Só existe funções de 1 a 4.\n");
            }


        }

    }

    public static void menuResumo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantidade de resumos do registro: ");
        RegistroResumos meusRegistros = new RegistroResumos(Integer.parseInt(sc.nextLine()));

        while (true) {
            System.out.println("Selecione uma das funcionalidades do registro:\n"
                    + "[1] Adicionar resumo\n"
                    + "[2] Imprimir resumos\n"
                    + "[3] Procurar resumo por tema\n"
                    + "[4] Procurar resumos que contém uma chave de busca\n"
                    + "[0] Sair\n"
            );

            int funcao = Integer.parseInt(sc.nextLine());
            if (funcao == 0) {
                break;
            }

            switch (funcao) {
                case 1:
                    System.out.println("Tema do resumo: ");
                    String tema = sc.nextLine();
                    System.out.println("Conteúdo do resumo: ");
                    meusRegistros.adiciona(tema, sc.nextLine());
                    break;
                case 2:
                    System.out.println(meusRegistros.imprimeResumos());
                    break;
                case 3:
                    System.out.println("Digite o tema que deseja procurar: ");
                    if (meusRegistros.temResumo(sc.nextLine())) {
                        System.out.println("Tem o tema no registro de resumos.");
                    } else {
                        System.out.println("Não tem o tema.");
                    }
                    break;
                case 4:
                    System.out.println("Digite a chave de busca: ");
                    String[] temas = meusRegistros.busca(sc.nextLine());

                    System.out.println("Temas encontrados: ");
                    for (int j = 0; j < temas.length; j++) {
                        System.out.println(temas[j]);
                    }
                    break;
                default:
                    System.out.println("Não existe esssa função.\n");
            }
        }
    }

    public static void menuRegistro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Selecione o tipo do registro de tempo online:\n"
                + "[1] Apenas o nome da disciplina\n"
                + "[2] Nome da disciplina e o tempo esperado online\n"
        );

        int escolha = Integer.parseInt(sc.nextLine());
        RegistroTempoOnline registro = null;

        System.out.println("Digite o nome da disciplina: ");
        String nomeDisciplina = sc.nextLine();

        if (escolha == 1) {
            registro = new RegistroTempoOnline(nomeDisciplina);
        } else if (escolha == 2) {
            System.out.println("Digite o tempo esperado: ");
            registro = new RegistroTempoOnline(nomeDisciplina, Integer.parseInt(sc.nextLine()));
        } else {
            System.out.println("Não existe esta opção.");
        }

        while (true) {
            System.out.println("Escolha umas das funcionalidades de Registro de Tempo Online:\n"
                    + "[1] Adicionar o tempo online\n"
                    + "[2] Verificar se atingiu a meta\n"
                    + "[3] Ver status geral do registro de tempo online\n"
                    + "[0] Sair\n"
            );

            int funcao = Integer.parseInt(sc.nextLine());
            if (funcao == 0) {
                break;
            }

            switch (funcao) {
                case 1:
                    System.out.println("Digite o tempo em horas que deseja adicionar: ");
                    registro.adicionaTempoOnline(Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    if (registro.atingiuMetaTempoOnline()) {
                        System.out.println("Atingiu a meta!");
                    } else {
                        System.out.println("Ainda não atingiu a meta.");
                    }
                    break;
                case 3:
                    System.out.println(registro.toString());
                    break;
                default:
                    System.out.println("A função que você digitou não existe. Só existe funções de 1 a 4.\n");
            }
        }
    }
}
