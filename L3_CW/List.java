package L3_CW;

public class List {
    Node head;
    Node tail;

    // public Node find(int value) {
    // Node currentNode = head;
    // while (currentNode != null) {
    // if (currentNode.value == value) {
    // return currentNode;
    // }
    // currentNode = currentNode.next;
    // }
    // return null;
    // }

    // // вставка в конец связанного списка
    // public void add(int value) {
    // Node node = new Node();
    // node.value = value;
    // // проверка на наличие элементов в списке или это первая нода
    // if (head == null) {
    // head = node;
    // // не допускаем того что head заполнен, а tail нет
    // tail = node;
    // } else {
    // // добавили в конец новую ноду
    // tail.next = node;
    // node.previous = tail;
    // tail = node;
    // }
    // }

    // public void add(int value, Node node) {
    // Node next = node.next; // то на что ссылается текущая нода
    // Node newNode = new Node();
    // newNode.value = value;
    // node.next = newNode; // следующее значение текущей ноды равно newNode
    // newNode.previous = node;
    // if (next == null) {
    // tail = newNode;
    // } else {
    // next.previous = newNode;
    // newNode.next = next;
    // }
    // }

    // public void delete(Node node) {
    // Node previous = node.previous;
    // Node next = node.next;
    // if (previous == null) {
    // next.previous = null;
    // head = next;
    // } else {
    // if (next == null) {
    // previous.next = null;
    // tail = previous;
    // } else {
    // previous.next = next;
    // next.previous = previous;
    // }
    // }
    // }

    // // разворот списка
    // public void revert(){
    // Node currentNode = head;
    // while(currentNode!= null){
    // Node next = currentNode.next;
    // Node previous = currentNode.previous;
    // currentNode.next = previous;
    // currentNode.previous = next;
    // if(previous == null){
    // tail = currentNode;
    // }
    // if(next == null){
    // head = currentNode;
    // }
    // currentNode = next;
    // }
    // }

    // разворот односвязного списка
    public void revertOne() {
        if (head != null && head.next != null) {
            Node temp = head;
            revertOne(head.next, head);
            temp.next = null;
        }
    }

    private void revertOne(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revertOne(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    // Стек и очередь на примере односвязного списка
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node; // для очереди
        head = node;
    }

    // для стека
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    // для очереди
    public Integer peek(){
        Integer result = null;
        if(tail!= null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public class Node {
        int value; // значение ноды
        Node next; // следующий элемент списка

        Node previous; // предыдущий элемент, нужен для очереди

    }

}
