package ListasDobles;

public class CircularDoubleList<T> {
    private Node<T> cabeza;
    private Node<T> cola;
    // Hagan el codigo!!! PRACTIQUEN
    
     //Nombres de metodos similares al resto de las clases para mantener orden
    
    private Boolean isEmpty(){
        return this.cabeza == null;
    }
    
    public int size(){
        if(isEmpty()){
            return 0;
        }else{
            Node<T> aux = this.cabeza;
            int i = 0;
            do{
                aux = aux.getNext();
                i++;
            }while(aux != this.cabeza);
            return i;
        }
    }
    
    public void addFirst(T dato){
        Node<T> n = new Node<>(dato);
        if(isEmpty()){
            this.cabeza = this.cola = n;
            this.cabeza.setNext(this.cola);
            this.cabeza.setPrev(this.cola);
            this.cola.setNext(this.cabeza);
            this.cola.setPrev(this.cabeza);
        }else{
            n.setNext(this.cabeza);
            this.cabeza.setPrev(n);
            n.setPrev(this.cola);
            this.cola.setNext(n);
            this.cabeza = n;
        }
    }
    
    public void addFinal(T dato){
        Node<T> n = new Node<>(dato);
        if(isEmpty()){
            this.cola = this.cabeza = n;
            this.cabeza.setNext(this.cola);
            this.cabeza.setPrev(this.cola);
            this.cola.setNext(this.cabeza);
            this.cola.setPrev(this.cabeza);
        }else{
            n.setPrev(this.cola);
            n.setNext(this.cabeza);
            this.cola = n;
        }
    }
    
    public void add(T dato, int i){
        if(isEmpty() || i == 0){
            this.addFirst(dato);
        }else if(i == this.size()-1){
            this.addFinal(dato);
        }else if(i < 0){
            this.add(dato, this.size()+i);
        }else if(i > this.size()){
            System.out.println("Error");
        }else{
            Node<T> n = new Node<>(dato);
            Node<T> aux = this.cabeza;
            int count = 0;
            while(count < i-1){
                aux = aux.getNext();
                count++;
            }
            n.setNext(aux.getNext());
            aux.getNext().setPrev(n);
            aux.setNext(n);
            n.setPrev(aux);
        }
    }
    
    public T deleteFirst(){
        if(isEmpty()){
            return null;
        }else{
            Node<T> temp = this.cabeza;
            this.cabeza = this.cabeza.getNext();
            this.cabeza.setPrev(this.cola);
            this.cola.setNext(this.cabeza);
            return temp.getDato();
        }
    }
    
    public T deleteLast(){
        if(isEmpty()){
            return null;
        }else{
            Node<T> temp = this.cola;
            this.cola = this.cola.getPrev();
            this.cola.setNext(this.cabeza);
            this.cabeza.setPrev(this.cola);
            temp.setNext(null);
            return temp.getDato();
        }
    }
    
    public T delete(int i){
        if(isEmpty()){
            return null;
        }else if(i == 0){
            return this.deleteFirst();
        }else if(i == size()-1){
            return this.deleteLast();
        }else if(i < 0){
            return this.delete(this.size()+i);
        }else if(i > this.size()){
            System.out.println("Error");
            return null;
        }else{
            Node<T> aux = this.cabeza;
            int count = 0;
            while(count < i-1){
                aux = aux.getNext();
                count++;
            }
            Node<T> temp = aux.getNext();
            aux.setNext(temp.getNext());
            temp.getNext().setPrev(aux);
            temp.setNext(null);
            return temp.getDato();
        }
    }
}
