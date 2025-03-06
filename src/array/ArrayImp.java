package array;
import entities.Node;
import exceptions.*;

public class ArrayImp<T extends Node<T>> implements Array<T> {

    private T[] nodes;
    private int size;
    private final static int SIZE_DEFAULT=10;

    public ArrayImp() {
        this.size=SIZE_DEFAULT;
        this.nodes=(T[])new Node[size];
    }

    public ArrayImp(int size){
        this.nodes= (T[])new Node[size];
        this.size=size;
    }

    public ArrayImp(T[] nodes){
        this.size=nodes.length;
        this.nodes = nodes.clone();
    }

    public int busca(T node) throws EmptyListException, InvalidIDException {
        if(size==0){throw new EmptyListException("Empty list");}
        if(node.getID()<0){throw new InvalidIDException("Invalid ID. Should be positive number");}

        int index; // Se o objeto existir no array, retorna seu índice. Se não, retorna o índice (negativo) referente a posição onde seve ser inserido um novo objeto
        for(index = 0; nodes[index] != null && index < size-1; index++){
            if(nodes[index].equals(node)){ break; } // Encontrou!
        }

        if(nodes[index]==null) {
            index *= -1;
            throw new NotFoundException(index); // Não encontrou, mas retorna a posição que deve se inserir o novo objeto
        }

        return index;
    }

    public void insert(T node) throws InvalidIDException, AlreadyExistsException, OverFlowException {
        // Insere na ordem crescente pelo ID
        // ID inválido e OverFlow devem ser administrado por quem chama a função
        int index = 0;
        try {
            index = busca(node);
            if(index==size-1){throw new OverFlowException("Full");}
            if(index>=0){throw new AlreadyExistsException("node already exists");}
        }catch(NotFoundException nfe){
            index = nfe.getIndex()*(-1); // Se não encontrar, calcula o índice a inserir
        }catch(EmptyListException ignore){
            // Lista vazia --> insere no index = 0, ja inicializado
        }
        nodes[index] = node;
    }

    public void remove(T node) throws InvalidIDException, NotFoundException, UnderFlowException {
        int index;
        try{
            index = busca(node);
            for(; nodes[index] != null && index < size-1; index++){
                nodes[index] = nodes[index+1];
            }
        }catch (NotFoundException nfe){throw new NotFoundException("node not found");}
        catch (EmptyListException ele){throw new UnderFlowException("Empty list");}

    }

    public void insertionSort() {
        try {
            for (int index = 1; index < nodes.length; index++) {
                int key = nodes[index].getID();
                int j = index - 1;
                while (j >= 0 && nodes[j].getID() > key) {
                    nodes[j + 1].setID(nodes[j].getID());
                    j -= 1;
                }
                nodes[j + 1].setID(key);
            }
        }catch (NullPointerException ignored){/* Chegou na parte vazia da lista */}
    }
}