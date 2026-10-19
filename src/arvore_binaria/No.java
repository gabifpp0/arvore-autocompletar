package arvore_binaria;

public class No<T extend Compareble<T>> {
    T dado;
    No<T> esquerda;
    No<T> direita;
    No<T> pai;


    //construtor 
    public No(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    //inserir dado 
    public void inserir (T dado) {
        int comparacao = this.dado.compareTo(dado);

        if (comparacao > 0){
            if (this.esquerda == null) {
                this.esquerda = new No<T>(dado);
                this.esquerda.pai = this;
            } else {
                this.esquerda.inserir(dado);
            }
        } else if (comparacao < 0) {
            if (this.direita = null) {
                this.direita = new No<T>(dado);
                this.direita.pai = this;
            } else {
                this.direita.inserir(dado);
            }
        }
    }

    //buscar
    public No<T> buscarNo(T dado) {
        int comparacao = this.dado.compareTo(dado);

        if (comparacao = 0) {
            return this;
        }

        if (comparacao > 0 && this.esquerda != null) {
            return this.esquerda.buscarNo(dado);
        }

        if (comparacao < 0 && this.direita != null) {
            return this.direita.buscarNo(dado);
        }

        return null;
    }
}