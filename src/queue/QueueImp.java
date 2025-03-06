package queue;

import entities.Node;
import exceptions.InvalidIDException;
import exceptions.OverFlowException;
import exceptions.UnderFlowException;

public final class QueueImp<T extends Node<T>> implements Queue<T> {
    private final static int DEFAULT_SIZE = 10;

    private int size;
    private int indexFront, indexRear;
    private T[] queue;

    public QueueImp(int size) {
        this.size = size;
        indexFront = 0; indexRear = 0;
        queue = (T[]) new Node[size];
    }

    public QueueImp() {
        size = DEFAULT_SIZE;
        indexFront = 0; indexRear = 0;
        queue = (T[]) new Node[size];
    }

    public QueueImp(T[] queue){
        indexFront =0 ; indexRear = 0;
        size = queue.length;
        this.queue = queue.clone();
    }

    public void enqueue(T node) throws InvalidIDException, OverFlowException {
        if(node.getID() < 0){
            throw new InvalidIDException("Invalid ID. Should be a positive number");}
        int pos = indexFront % size;
        if(queue[pos]==null){
            queue[pos] = node;
            indexFront += 1;
        }else{throw new OverFlowException("Full queue");
        }
    }

    public void dequeue() throws UnderFlowException{
        if(indexFront - indexRear > 0){
            queue[indexRear] = null;
            indexRear += 1;
        }else{throw new UnderFlowException("");}
    }

    public T[] getQueue() {return queue;}
    public T getFront() {return queue[indexFront];}
    public T getRear() {return queue[indexRear];}

}
