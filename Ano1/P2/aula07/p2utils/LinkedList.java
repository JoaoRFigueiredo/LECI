package p2utils;

/** This class implements a List abstract data type using a linked list.
 * Please note that this is p2utils.LinkedList.
 * It is NOT the java.util.LinkedList class in the standard Java library!
 */
public class LinkedList<E> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /** {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /** Adds the given element to the start of the list.
   * @param e the element to add
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /** Adds the given element to the end of the list.
   * @param e the element to add
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
  }

  /** Checks if the given element exists in the list.
   * @param e an element
   * @return {@code true} if the element exists and {@code false} otherwise
   */
  public boolean contains(E e) { 
    return contains(first, e); 
  }
  private boolean contains(Node<E> n, E e) {
    if (n == null) return false;
    if (n.elem==null) return e==null; //dispensável, se impedirmos elem==null
    if (n.elem.equals(e)) return true; 
    return contains(n.next, e);
  }

  /** Prints all elements, one per line. */
  public void print() {
    print(first);
  }
  private void print(Node<E> n) {
    if (n != null) {
      System.out.println(n.elem);
      print(n.next);
    }
  }
  //cria uma lista igual à existente.
  public LinkedList<E> clone(){
    
    LinkedList<E> copy = new LinkedList();
		copy.add(first, copy);
		return copy;

  }

  public void add(Node <E> n, LinkedList A)
	{
		if (n!= null)
		{
			A.addLast(n.elem);
			add(n.next, A);
    }
  }

  public void addRev(Node <E> n, LinkedList A)
	{
		if (n!= null)
		{
			A.addFirst(n.elem);
			addRev(n.next, A);
    }
  }
	
  //inverte a lista
  public LinkedList<E> reverse()
	{
		LinkedList<E> copy = new LinkedList();
		copy.addRev(first, copy);
		return copy;
	}

  // faz return do elemento na posiçao dada como argumento(variando entre 1 e size-1)
  public E get(int pos){
    int i = 0;
    return get(first, pos, i);

  }
  
  public E get (Node <E> atual, int pos, int i)
	{
		if (pos == i)
			return atual.elem;
		i++;
		return get (atual.next, pos, i);
  }
  
  //devolve uma nova lista com os elementos da lista seguidos dos elementos da lista dada no argumento.
	public LinkedList<E> concatenate (LinkedList<E> lista)
	{
		LinkedList<E> nova = clone();
		nova.add(lista.first, nova);
		return nova;
		
  }
  
  public void remove(E n)
	{
		first = remove(n, first);
		if (isEmpty())
			last=null;
	}
	
	public Node <E> remove(E n, Node <E> atual)
	{
		if (atual.elem.equals(n))  //se o atual for igual, tromos o atual como o seguinte, diminuimos o valor do tamanho, e fazemos o teste para o novo atual
			{   
				atual=atual.next;
				size--;
				return atual;
			}
		
		atual.next= remove(n,atual.next);
		if (atual.next==null)
			last=atual;
		return atual;
	
	}
	


	

  // funções adicionais pedidas no guião...
  

}
