package stack;

import entities.Node;
import exceptions.InvalidIDException;
import exceptions.OverFlowException;
import exceptions.UnderFlowException;

public final class StackImp<T extends Node<T>> implements Stack<T> {
    private final static int DEFAULT_SIZE = 10;

    private int size;
    private int indexTopo; // representa o índice do topo da pilha
    private T[] stack;

    public StackImp(int size) {
        this.size = size;
        this.indexTopo = size-1;
        stack = (T[]) new Object[size];
    }
    public StackImp() {
        size = DEFAULT_SIZE;
        indexTopo = size-1;
        stack = (T[]) new Node[size];
    }
    public StackImp(T[] stack) {
        indexTopo = stack.length-1;
        this.stack = stack;
    }

    public void push(T node) throws InvalidIDException, OverFlowException{
        if(node.getID()<0){throw new InvalidIDException("Invalid ID");}
        if(indexTopo >= 0){
            this.stack[indexTopo] = node; // Insere o objeto
            this.decreaseIndexTopo(); // atualiza o topo da pilha;
        }else{throw new OverFlowException("Stack overflow");}
    }
    public void pop() throws UnderFlowException {
        if(indexTopo < 0){
            this.increaseIndexTopo(); // Atualiza o topo da pilha
            this.stack[indexTopo]=null; // free
        }else{throw new UnderFlowException("Stack underflow");}
    }


    public T peek() {return stack[indexTopo];}
    public T[] getStack() {return stack;}

    public void increaseIndexTopo(){ indexTopo += 1;}
    public void decreaseIndexTopo(){ indexTopo -= 1;}
}
