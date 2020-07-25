package app;

class Votacao {
    int NumeroSecao;
    int NumeroCandidato;

    //Método construtor
    Votacao(){
        this (0,0);
    }

    //Método Procedimento
    Votacao(int varNumeroSecao, int varNumeroCandidato){
        NumeroSecao = varNumeroSecao;
        NumeroCandidato = varNumeroCandidato;
    }
}