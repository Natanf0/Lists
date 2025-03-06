package queue;

import entities.Node;
import exceptions.InvalidIDException;
import exceptions.OverFlowException;
import exceptions.UnderFlowException;

public interface Queue<T extends Node<T>> {
    void enqueue(T node) throws InvalidIDException, OverFlowException;
    void dequeue() throws UnderFlowException;
    T[] getQueue();
    T getFront();
    T getRear();
}
