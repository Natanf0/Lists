package stack;

import entities.Node;
import exceptions.InvalidIDException;
import exceptions.OverFlowException;
import exceptions.UnderFlowException;

public interface Stack<T extends Node<T>> {
    void push(T node) throws InvalidIDException, OverFlowException;
    void pop() throws UnderFlowException;
    T peek();
    T[] getStack();
}
