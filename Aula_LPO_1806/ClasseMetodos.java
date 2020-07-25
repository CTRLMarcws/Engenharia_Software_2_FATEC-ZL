package app;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

public class ClasseMetodos {
    Random aleatorio = new Random();

    //Função para cadastro do voto dos 100 eleitores de forma aleatoria
    public Votacao[] fCadastraVotacao(Votacao[] vot){
        //Variaveis
        int i;

        //Método construtor
        for (i = 0; i < 100; i++)
        {
            vot[i] = new Votacao();
        }

        //Cadastro dos dados
        for (i = 0; i < 100; i++)
        {
            vot[i].NumeroSecao = aleatorio.nextInt(11);
            vot[i].NumeroCandidato = aleatorio.nextInt(301);
        }

        //Confirmação da operação
        JOptionPane.showMessageDialog(null,"Votação Concluída.");
        return vot;
    }

    //Função para classificar os votos armazenados no vetor vot
    public Votacao[] fClassificaSecao(Votacao[] vot){
        //Variaveis
        int i, j, auxSec = 0, auxCan = 0;

        //Organização dos dados
        for (i=0; i < 100; i++)
        {
            for (j = 0; j < 99; j++)
            {
                if(vot[i].NumeroSecao > vot[j].NumeroSecao)
                {
                    auxSec = vot[j].NumeroSecao;
                    auxCan = vot[j].NumeroCandidato;

                    vot[j].NumeroSecao = vot[i].NumeroSecao;
                    vot[j].NumeroCandidato = vot[i].NumeroCandidato;

                    vot[i].NumeroSecao = auxSec;
                    vot[i].NumeroCandidato = auxCan;
                }
            }
        }

        //Confirmação da operação
        JOptionPane.showMessageDialog(null,"Dados Classificados.");
        return vot;
    }

    //Função para gravar os valores salvos no vetor vot em um arquivo de texto.
    public Votacao[] fGravaVotacao (Votacao[] vot) throws IOException {
    // Variaveis
    int i;

    //Declaração do arquivo + método de escrita
    String nomeArquivo = "Votacao.txt";
    BufferedWriter escrita = new BufferedWriter(new FileWriter(nomeArquivo));

    //Gravação dos dados
    for(i = 0; i < 100; i++)
    {
        escrita.write(Integer.toString(vot[i].NumeroCandidato));  	
        escrita.newLine();
        escrita.write(Integer.toString(vot[i].NumeroSecao));  	
        escrita.newLine();
    }

    //Confirmação da operação
    JOptionPane.showMessageDialog(null,"Gravação bem sucedida.\nDados Armazenados no arquivo " + nomeArquivo + ".");
    escrita.close();
    return vot;
    }
}