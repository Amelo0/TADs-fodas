package ED1.TADsNotaveis;

public class StackInt {
    //atributos
    private int[] dados;
    private int quant;//quantidade de posições preenchidas

    public StackInt() {
        dados = new int[10];
    }

    public StackInt(int tam) {
        dados = new int[tam];
        quant = 0;
    }

    //metodos
    public void push(int valor) {//inserir o final
        if (!Full()) {
            dados[quant] = valor;
            quant++;
        } else {
            System.out.println("A pilha está cheia.");
        }
    }

    public int pop() {//remover e retornar o ultimo
        if (!Empty()) {
            quant--;
            return dados[quant];
        } else {
            System.out.println("A pilha está vazia.");
            return -1; // Valor de erro
        }
    }

    public boolean Empty() {//testa se esta vazio
        return quant == 0;
    }

    public boolean Full() {//testa se esta cheio
        return quant == dados.length;
    }

    public int top() {//retorna o topo, ultimo
        if (!Empty()) {
            return dados[quant - 1];
        } else {
            System.out.println("A pilha está vazia.");
            return -1; // Valor de erro
        }
    }
}

//    public static void main(String[] args) {
//        StackInt minhaPilha = new StackInt(5);
//
//        minhaPilha.push(10);
//        minhaPilha.push(20);
//
//        System.out.println("Topo: " + minhaPilha.top());
//
//        while (!minhaPilha.Empty()) {
//            System.out.println("Valor desempilhado: " + minhaPilha.pop());
//        }
//
//        System.out.println("A pilha está vazia?! " + minhaPilha.Empty());
//    }