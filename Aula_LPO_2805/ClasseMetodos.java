import javax.swing.JOptionPane;

public class ClasseMetodos {

public void CalcLoja(){
  int i;
  double tot_geral = 0, tot_vend, comissao;
  double qnt[] = new double [5];
  double preco[] = new double [5];
  //processamento de dados:
  for (i = 0; i < 5; i++)
  {
    qnt[i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a quantidade vendida do " + (i+1) + "o produto"));
    preco[i] = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o preco unitário do " + (i+1) + "o produto"));
  } // for
  
  for (i = 0; i < 5; i++)
  {
    tot_vend = qnt [i] * preco [i];
    JOptionPane.showMessageDialog(null, "Produto nº " + (i+1) + "\nPreço unitário: " + preco[i] + "\nQuantidade vendida: " + qnt[i] + "\nTotal geral da venda: " + tot_vend);
    tot_geral = tot_geral + tot_vend;
  } // for

  comissao = (tot_geral*0.05);
  JOptionPane.showMessageDialog(null, "Valor total das vendas: " + tot_geral + "\nValor da comissão: " + comissao);
  }

  public double[] MedAlunos(double m[][]){
    int x, y;
    double aux;
    double vetMedia[] = new double[3];
    for (x = 0; x < 3; x++)
    {
      aux = 0;
      for (y = 0; y < 2; y++)
      {
        aux = aux + m[x][y];
      }
      vetMedia [x] = aux / 2;
    }
    return vetMedia;
  }
}