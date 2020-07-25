package app;
import javax.swing.JOptionPane;
import java.io.IOException;

class ClassePrincipal {
    public static void main (String[] args) throws IOException {
        //Instância da classe abstrata com 2 registros
        Votacao [] vot = new Votacao[100];

        //Instância da classe Metodos e indicadores
        ClasseMetodos met = new ClasseMetodos();
        ClasseIndicadores ind = new ClasseIndicadores();

        //Variaveis
        int i;
        int opc = 0;

        //Execução do método construtor
        for (i = 0; i < 100; i++){
            vot[i] = new Votacao();
        }

        //Menu de opções
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("SISTEMA DE VOTAÇÃO\n\n1 - Carregar votos (seção e candidato)\n2 - Classificar dados (por seção)\n3 - Gravar registros\n4 - Demonstrar indicadores\n9 - Finalizar"));
            switch (opc){
                case 1: vot = met.fCadastraVotacao(vot);
                break;

                case 2: vot = met.fClassificaSecao(vot);
                break;

                case 3: met.fGravaVotacao(vot);
                break;

                case 4: ind.menuIndicadores(vot);
                break;

                case 9: JOptionPane.showMessageDialog(null,"Finalizado.");
                break;

                default: JOptionPane.showMessageDialog(null,"Opção inválida\nRetornando ao menu");
            }
            
        } while (opc != 9);
     
    }
    
}