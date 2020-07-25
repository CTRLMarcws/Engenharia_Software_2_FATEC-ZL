import javax.swing.JOptionPane;
public class ClassePrincipal {
    public static void main(String args[]){
        ClasseMetodos m = new ClasseMetodos();
        double media[][] = new double[3][2];
        double vetMedia[] = new double[3];
        int opc = 0;
        int opc2 = 0;
        int z;

        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1 - Para calculo de comissão\n2 - Para calculo de média de aluno\n9 - Para sair"));
                switch (opc){
                    case 1: m.CalcLoja();
                    break;
                    case 2: do{
                        opc2 = Integer.parseInt(JOptionPane.showInputDialog("Calculo de média:\n1 - Para carregar notas\n2 - Para calcular as médias\n3 - Exibir as médias\n9 - Para sair"));
                        switch (opc2){
                            case 1: media = CarregaNotas(media);
                            break;
                            case 2: vetMedia = m.MedAlunos(media);
                            JOptionPane.showMessageDialog(null,"Calculo finalizado.");
                            break;
                            case 3: for (z = 0; z < 3; z++)
                            {
                                JOptionPane.showMessageDialog(null,"A média do aluno "+(z+1)+ " é: " + vetMedia[z]);
                            }
                            break;
                            case 9: JOptionPane.showMessageDialog(null,"Voltando ao menu principal...");
                            break;
                            default: JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.");
                        }
                    }while (opc2 != 9);

                    break;
                    case 9: JOptionPane.showMessageDialog(null,"Finalizado.");
                    break;
                    default: JOptionPane.showMessageDialog(null,"Opção inválida, tente novamente.");
                }
        }
        while (opc != 9);
    }

    public static double[][] CarregaNotas(double m[][]){
        int x, y;     
        for (x = 0; x < 3; x++)
        {
            for (y = 0; y < 2; y++)
            {
                m[x][y] = Double.parseDouble(JOptionPane.showInputDialog("Qual a nota do " + (x+1) + "º aluno na " + (y+1) + "ª prova: "));
            }
        }
        return m;
    }  
}