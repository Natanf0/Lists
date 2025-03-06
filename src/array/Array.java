package array;

import entities.Node;
import exceptions.*;

public interface Array<T extends Node<T>>{
    int busca(T node) throws EmptyListException, InvalidIDException;
    void insert(T node) throws InvalidIDException, AlreadyExistsException, OverFlowException;
    void remove(T node)  throws InvalidIDException, NotFoundException, UnderFlowException;
    void insertionSort();
}
