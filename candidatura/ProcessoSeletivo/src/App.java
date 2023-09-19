import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Felipe", "Marcio", "WIllian", "Ondina", "Lucas"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }

    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
            do {
                atendeu = atender();
                continuarTentando = !atendeu;
                if(continuarTentando)
                    tentativasRealizadas++;
                else
                    System.out.println("Contato realizado com sucesso");
            } while(continuarTentando && tentativasRealizadas < 3);

            if(atendeu)
                System.out.println("Conseguimos contato com " + candidato + " Na " + tentativasRealizadas + "a Tentativa");
            else 
                System.out.println("Não conseguimos contato com " + candidato + ", Número máximo de tentativas realizadas.");
    }



    static boolean atender() {
        return new Random().nextInt(3)==1;
    }


    static void imprimirSelecionados() {
        String [] candidatos = {"Felipe", "Marcio", "WIllian", "Ondina", "Lucas"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("FOrma abreviada com for each");
        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Felipe", "Marcio", "WIllian", "Ondina", "Lucas", "Matheus", "Marcelo", "Joao", "Pedro", "Leopoldo"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

    }


    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta");
        }  else {
            System.out.println("Aguardando demais candidatos");
            
        }
    }
}
