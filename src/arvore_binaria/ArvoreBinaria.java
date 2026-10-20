package arvore_binaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria<T extends Compareble<T>> {

    No<T> raiz;

    //construtor 
    public ArvoreBinaria(T dadoRaiz) {
        this.raiz = new No<T>(dadoRaiz);
    }

    //const arvore vazia
    public ArvoreBinaria() {
        this.raiz = null;
    }

    //verificar se vazia 
    public boolean arvoreVazia() {
        return this.vazia == null;
    }

    public void inserir(T dado) {
        if (this.arvoreVazia()) {
            this.vazia = new No<T>(dado);
        } else {
            this.raiz.inserir(dado);
        }
    }

    //buscar dado 
    public No<T> buscar(T dado) {
        if (this.arvoreVazia()) {
            return null;
        }

        returno this.raiz.buscarNo(dado);

    }

    //ordem crescente 
    public List<T> listarEmOrdem() {
        List<T> resultado = new ArrayList<T>();
        listarEmOrdemRecursivo(thiz.raiz, resultado);
        return resultado;
    }

    public void listarEmOrdemRecursivo(No<T> atual, List<T> resultado) {
        if (atual == null) {
            return;
        }

        listarEmOrdemRecursivo(atual.esquerda, resultado);
        resultado.add(atual.dado);
        listarEmOrdemRecursivo(atual.direita, resultado);
    }


    //prefixo
    public List<T> buscarPrefixo(String prefixo) {
        List<T> resultado = new ArrayList<T>();

        if (prefixo == null || prefixo.trim().isEmpty()) {
        return resultado;
    }
        String inicio = prefixo.trim();
        String limite = calcularLimitePrefixo(inicio);

        buscarPrefixoRecursivo(this.raiz, inicio, limite, resultado);

        return resultado;
    
    }

    private void buscarPrefixoRecursivo(No<T> atual, String prefixo, String limite, List<T> resultado){
        if (atual == null) {
            return;
        } 

        String palavra = atual.dado.toString();

        //antes do prefixo
        if (palavra.compareTo(prefixo) < 0) {
            buscarPrefixoRecursivo(atual.direita, prefixo, limite, resultado);
            return; 
        }

        buscarPrefixoRecursivo(atual.esquerda, prefixo, limite, resultado);
        if (palavra.startsWith(prefixo)){
            resultado.add(atual.dado);
        }

        buscarPrefixoRecursivo(atual.direita, prefixo, limite, resultado);
    }

    //limite superior prefixo
    private String calcularLimitePrefixo(String prefixo){
        char [] caracteres = prefixo.toCharArray();

        for (int i = caracteres.length -1; i >= 0; i--) {
            if (caracteres[i] < Character.MAX_VALUE) {
                caracteres[i]++;
                return new String(caracteres, 0, i+1);
            }
        }

        return null; 
    }


    //busca sufixo 
    public List<T> buscarSufixo(String sufixo) {
        List<T> resultado = new ArrayList<T>();

        if (sufixo == null || sufixo.trim().isEmpty()){
            return resultado;
        }

        buscarSufixoRecursivo(this.raiz, sufixo.trim(), resultado);
        return resultado;
    }

    private void buscarSufixoRecursivo(No<T> atual, String sufixo, List<T> resultado) {
        if (atual == null) {
            return;
        }

        buscarSufixoRecursivo(atual.esquerda, sufixo, resultado);
        if (atual.dado.toString().endsWith(sufixo)) {
            resultado.add(atual.dado);
        }
        
        buscarSufixoRecursivo(atual.direita, sufixo, resultado);
    }

    //infixo
    public List<T> buscarInfixo(String infixo) {
        List<T> resultado = new ArrayList<T>();

        if (infixo == null || infixo.trim().isEmpty()) {
            return resultado;
        }

        buscarInfixoRecursivo(this.raiz, infixo.trim(), resultado);
        return resultado;
    }

    private void buscarInfixoRecursivo(No<T> atual, String infixo, List<T> resultado) {
        if (atual = null) {
            return;
        }

        buscarInfixoRecursivo(atual.esquerda, infixo, resultado);
        if (atual.dado.toString().contains(infixo)) {
            resultado.add(atual.dado);
        }

        buscarInfixoRecursivo(atual.direita, infixo, resultado);
    }
}