import javax.swing.JOptionPane;

public class ClasseMetodos {
  double Media;

  //Função de cadastro de estatistica
  public Estatistica[] fCadastraEstatistica(Estatistica[] est){
    //Variaveis
    int i;

    //Cadastro dos dados
    for(i = 0; i < 10; i++){
      est[i].codigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Insira o código da " + (i+1) + "º cidade:\nObs.: máximo 9 dígitos"));
      est[i].nomeCidade = JOptionPane.showInputDialog("Insira o nome da " + (i+1) + "º cidade:");
      est[i].qtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de acidentes:"));
    }
    return est;
  }

  //Procedimento para consultar cidades com quantidade de acidentes entre 100 e 500
  public void pQtdAcidentes(Estatistica[] est){
    //Variaveis
    int i;

    //Processamento de dados
    for(i = 0; i < 10; i++){
      if (est[i].qtdAcidentes > 100 && est[i].qtdAcidentes < 500){
        JOptionPane.showMessageDialog(null,"Cidades com número de acidentes entre 100 e 500:\n\n" + est[i].nomeCidade + " (Cód. "+ est[i].codigoCidade +") teve " + est[i].qtdAcidentes + " acidentes.");
      }
    }
  }

  public void pConsultaMaiorMenor(Estatistica[] est){
    //Variaveis
    int men, man, i;
    int aMan = 0, aMen = 0;
    Media = 0;
    
    //Processamento de dados
      men = est[0].qtdAcidentes; //menor
      man = est[0].qtdAcidentes; //maior
    
      for (i = 0; i < 10; i++){
        Media = Media + est[i].qtdAcidentes;

        if (est[i].qtdAcidentes > man){
          man = est[i].qtdAcidentes;
          aMan = i;
        }
        if (est[i].qtdAcidentes < men){
          men = est[i].qtdAcidentes;
          aMen = i;
        }
      }

      //Exibição dos dados processados
      JOptionPane.showMessageDialog(null,"Entre as cidades listadas, " + est[aMan].nomeCidade + " (Cód. "+ est[aMan].codigoCidade +") teve o maior indice de acidentes.\nTotal de acidentes: " + est[aMan].qtdAcidentes);
      JOptionPane.showMessageDialog(null,"Entre as cidades listadas, " + est[aMen].nomeCidade + " (Cód. "+ est[aMen].codigoCidade +") teve o menor indice de acidentes.\nTotal de acidentes: " + est[aMen].qtdAcidentes);
  }

  public void pConsultaEstatistica(Estatistica[] est){
    //Variaveis
    int i;

    //Processamento de dados
    Media = Media / 10;

    //Exibição de dados
    for (i = 0; i < 10; i++){
      if(est[i].qtdAcidentes > Media){
        JOptionPane.showMessageDialog(null,"A quantidade de acidentes em " + est[i].nomeCidade + " (Cód. "+ est[i].codigoCidade +") foi maior que a média das demais cidades.\nAcidentes: " + est[i].qtdAcidentes + "\nMedia: " + Media);
      }

    }
  }

}