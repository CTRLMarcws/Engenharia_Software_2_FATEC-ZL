class Estatistica {
  int codigoCidade;
  String nomeCidade;
  int qtdAcidentes;
  
  //Método Construtor
  Estatistica(){
    this (0, "", 0);
  }

  //Método Procedimento
  Estatistica ( int varCodigoCidade, String varNomeCidade, int varQtdAcidentes){
    codigoCidade = varCodigoCidade;
    nomeCidade = varNomeCidade;
    qtdAcidentes = varQtdAcidentes;
  }
}