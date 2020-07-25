import javax.swing.JOptionPane;

class ClasseMenu {
    public static void main(String[] args) {
        //Instância da classe abstrata com 3 registros tipo vetor
        Estatistica [ ] est = new Estatistica[10];

        //Instância da ClasseMetodos
        ClasseMetodos met = new ClasseMetodos();

        //Variaveis
        int i;
        int opc = 0;

        //Execução do método construtor
        for (i = 0; i < 10; i++){
            est[i] = new Estatistica();
        }

        //Menu de opções
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("              MENU ESTATÍSTICA\nEstatísticas de acidentes em 2020\n\n1 - Cadastrar cidades\n2 - Consultar por quantidade de acidentes\n3 - Consultar o maior e menor índice\n4 - Consultar índice de média\n9 - Finalizar\n"));
            switch (opc){
                case 1: est = met.fCadastraEstatistica(est);
                break;
                case 2: met.pQtdAcidentes(est);
                break;
                case 3: met.pConsultaMaiorMenor(est);
                break;
                case 4: met.pConsultaEstatistica(est);
                break;
                case 9: JOptionPane.showMessageDialog(null,"Finalizado.");
                break;
                default: JOptionPane.showMessageDialog(null,"Opção inválida\nRetornando ao menu.");
            }
        }
        while (opc != 9);
    }
}