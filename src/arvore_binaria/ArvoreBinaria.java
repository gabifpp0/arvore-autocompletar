package arvore_binaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria<T extends Comparable<T>> {

    No<T> raiz;

    // Construtor
    public ArvoreBinaria(T dadoRaiz) {
        this.raiz = new No<T>(dadoRaiz);
    }

    // Construtor de árvore vazia
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // Verificar se vazia
    public boolean arvoreVazia() {
        return this.raiz == null;
    }

    public void inserir(T dado) {
        if (this.arvoreVazia()) {
            this.raiz = new No<T>(dado);
        } else {
            this.raiz.inserir(dado);
        }
    }

    // Buscar dado
    public No<T> buscar(T dado) {
        if (this.arvoreVazia()) {
            return null;
        }
        return this.raiz.buscarNo(dado);
    }

    // Remover dado da árvore
    public boolean remover(T dado) {
        No<T> atual = buscar(dado);
        
        if (atual == null) {
            return false;
        }
        if (atual.esquerda != null && atual.direita != null) {
            No<T> sucessor = atual.direita;
            while (sucessor.esquerda != null) {
                sucessor = sucessor.esquerda;
            }
            atual.dado = sucessor.dado;
            atual = sucessor;
        }

        No<T> filho = atual.esquerda != null ? atual.esquerda : atual.direita;
        
        if (filho != null) {
            filho.pai = atual.pai;
        }
        if (atual.pai == null) {
            this.raiz = filho;
        }
        else if (atual.pai.esquerda == atual) {
            atual.pai.esquerda = filho;
        }
        else {
            atual.pai.direita = filho;
        }
        return true;
    }

    // Ordem crescente
    public List<T> listarEmOrdem() {
        List<T> resultado = new ArrayList<T>();
        listarEmOrdemRecursivo(this.raiz, resultado);
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

    // Busca por prefixo
    public List<T> buscarPrefixo(String prefixo) {
        List<T> resultado = new ArrayList<T>();
        if (prefixo == null || prefixo.trim().isEmpty()) {
            return resultado;
        }
        buscarPrefixoRecursivo(this.raiz, prefixo.trim(), resultado);
        return resultado;
    }

    private void buscarPrefixoRecursivo(No<T> atual, String prefixo, List<T> resultado) {
        if (atual == null) {
            return;
        }
        String palavra = atual.dado.toString();
        if (palavra.compareTo(prefixo) < 0) {
            buscarPrefixoRecursivo(atual.direita, prefixo, resultado);
            return;
        }
        buscarPrefixoRecursivo(atual.esquerda, prefixo, resultado);
        if (palavra.startsWith(prefixo)) {
            resultado.add(atual.dado);
        }
        buscarPrefixoRecursivo(atual.direita, prefixo, resultado);
    }

    // Remover todas as palavras que começam com o prefixo
    public int removerPorPrefixo(String prefixo) {
        List<T> palavras = buscarPrefixo(prefixo);
        for (T palavra : palavras) {
            remover(palavra);
        }
        return palavras.size();
    }

    // Busca sufixo
    public List<T> buscarSufixo(String sufixo) {
        List<T> resultado = new ArrayList<T>();
        if (sufixo == null || sufixo.trim().isEmpty()) {
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

    // Busca infixo
    public List<T> buscarInfixo(String infixo) {
        List<T> resultado = new ArrayList<T>();
        if (infixo == null || infixo.trim().isEmpty()) {
            return resultado;
        }
        buscarInfixoRecursivo(this.raiz, infixo.trim(), resultado);
        return resultado;
    }

    private void buscarInfixoRecursivo(No<T> atual, String infixo, List<T> resultado) {
        if (atual == null) {
            return;
        }
        buscarInfixoRecursivo(atual.esquerda, infixo, resultado);
        if (atual.dado.toString().contains(infixo)) {
            resultado.add(atual.dado);
        }
        buscarInfixoRecursivo(atual.direita, infixo, resultado);
    }

    // Remover todas as palavras que terminam com o sufixo
    public int removerPorSufixo(String sufixo) {
        List<T> palavras = buscarSufixo(sufixo);
        for (T palavra : palavras) {
            remover(palavra);
        }
        return palavras.size();
    }

    // Remover todas as palavras que contêm o infixo
    public int removerPorInfixo(String infixo) {
        List<T> palavras = buscarInfixo(infixo);
        for (T palavra : palavras) {
            remover(palavra);
        }
        return palavras.size();
    }

    // Remover todas as palavras da árvore
    public int removerTodas() {
        int quantidade = contarNos(this.raiz);
        this.raiz = null;
        return quantidade;
    }

    private int contarNos(No<T> atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNos(atual.esquerda) + contarNos(atual.direita);
    }

    // Consultar se a palavra existe na árvore
    public boolean consultar(T dado) {
        return buscar(dado) != null;
    }
}
