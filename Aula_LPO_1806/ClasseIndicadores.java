package app;
import javax.swing.JOptionPane;
import java.io.*;


public class ClasseIndicadores {

    //Variaveis globais
    int vNS[] = new int [11];
    int mNC[][] = new int [301][2];
    int i;

    //Chamada da função de leitura e menu de indicadores
    public void menuIndicadores (Votacao[] vot) throws IOException{
        //Variaveis
        int opc;

        //Chamada do procedimento de leitura e armazenagem
        pLeituraeArmazenagem(vot);

        //Menu de indicadores
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Indicadores:\n\n1 - Quant. de eleitores por seção\n2 - Seção com maior e menor número de eleitores\n3 - Quantidade de votos por candidato\n4 - 10 primeiros colocados (nro. do cand. e qntd. de votos)\n9 - Retornar ao menu principal\n\nObs.: Os resultados serão demonstrados através do terminal."));
            switch (opc)
            {
                case 1: pQntEleitorespSecao();
                break;

                case 2: pMaioreMenorSecao();
                break;

                case 3: pQntVotospCandidato();
                break;

                case 4: pCandidadosMaisVotados();
                break;

                case 9: JOptionPane.showMessageDialog(null,"Retornando ao menu principal");
                break;

                default: JOptionPane.showMessageDialog(null,"Opção inválida\nRetornando ao menu");
            }
        } while (opc != 9);
    }

        //Procedimento para leitura do banco de dados e armazenagem em vetores.
    public void pLeituraeArmazenagem (Votacao[] vot) throws IOException{
        //Declaração do arquivo e da variavel de leitura
        String nomeArquivo = "Votacao.txt";
        BufferedReader leitura = new BufferedReader(new FileReader(nomeArquivo));

        //Método construtor
        for(i = 0; i < 100; i++){
            vot[i] = new Votacao();
        }
        for(i = 0; i < 11; i++){
            vNS[i] = 0;
        }
        for(i = 0; i < 301; i++){
            mNC[i][0] = i;
        }

        //Leitura e processamento dos dados
        for(i = 0; i < 100; i++)
        {
            vot[i].NumeroCandidato = Integer.parseInt(leitura.readLine());
            vot[i].NumeroSecao = Integer.parseInt(leitura.readLine());

            mNC[vot[i].NumeroCandidato][1] = mNC[vot[i].NumeroCandidato][1] + 1;
            vNS[vot[i].NumeroSecao] = vNS[vot[i].NumeroSecao] + 1;
        }
        leitura.close();
    }
    

    //Opção 1 - Procedimento para exibição da quantidade de eleitores por seção
    public void pQntEleitorespSecao () {
        //Demonstração dos resultados
        System.out.println("\nNúmero de votos por seção:");
        for(i = 0; i < 11; i++)
        {
            System.out.println("Seção " + i + " - " + vNS[i] + " votos.");
        }

    }


    //Opção 2 - Procedimento para exibição das seções com maior e menor números de eleitores.
    public void pMaioreMenorSecao () {
        //Variaveis locais
        int men, mai;
        int aMen = 0, aMai = 0;

        //Processamento de dados
        men = vNS[0];
        mai = vNS[0];

        for (i = 0; i < 11; i++)
        {
            if(vNS[i] > mai)
            {
                mai = vNS[i];
                aMai = i;
            }
            if(vNS[i] < men)
            {
                men = vNS[i];
                aMen = i;
            }
        }

        //Demonstração dos resultados
        System.out.println("\nRanking das seções:");
        System.out.println("A seção com maior número de votos foi a: Seção " + aMai + " com total de: "+ mai + " votos.");
        System.out.println("A seção com menor número de votos foi a: Seção " + aMen + " com total de: "+ men + " votos.");
    }


    //Opção 3 - Procedimento para exibição dos votos por candidatos
    public void pQntVotospCandidato () {
        //Variaveis locais
        int aux = 0;

        //Demonstração dos resultados
        System.out.println("\nNúmero de votos por candidato:");
        for(i = 0; i < 301; i++)
        {
            if(mNC[i][1] == 0)
            {
                aux = aux + 1;
            }
            else
            {
                System.out.println("Candidato " + mNC[i][0] + " - " + mNC[i][1] + " votos.");
            }
        }

        System.out.println(aux + " candidatos não obtiveram votos.");
    }


    //Opção 4 - Procedimento para demonstrar os 10 primeiros colocados
    public void pCandidadosMaisVotados () {
        //Variaveis locais
        int j, aCan = 0, aVts = 0;

        //Organização da matriz
        for (i = 0; i < 301; i++)
        {
            for (j = 0; j < 300; j++)
            {
                if(mNC[i][1] > mNC[j][1])
                {
                    aCan = mNC[i][0];
                    aVts = mNC[i][1];

                    mNC[i][0] = mNC[j][0];
                    mNC[i][1] = mNC[j][1];

                    mNC[j][0] = aCan;
                    mNC[j][1] = aVts;
                }
            }
        }

        //Demonstração dos resultados
        System.out.println("\nRanking - 10 mais votados:");
        for (i = 0; i < 10; i++)
        {
            System.out.println((i+1) + "º colocado: candidato " + mNC[i][0] + " com " + mNC[i][1] + " votos.");
        }
    }
    
}