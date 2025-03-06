package entities;

public abstract class Node<T> {
    private int ID;

    public Node(int id){this.ID=id;}

    public int getID(){return ID;}
    public void setID(int ID){this.ID = ID;}
}
