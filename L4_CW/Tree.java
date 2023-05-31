package L4_CW;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root; // начало дерева

    // Обход в глубину - 2 функции (поиск ноды, отображение найденной/не найденной
    // ноды)
    // public boolean exist(int value) {
    //     if (root != null) {
    //         Node node = find(root, value);
    //         if (node != null) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private Node find(Node node, int value) {
    //     if (node.value == value) {
    //         return node;
    //     } else {
    //         for (Node child : node.children) {
    //             Node result = find(child, value);
    //             if (result != null) {
    //                 return result;
    //             }
    //         }
    //     }
    //     return null;
    // }

    // Обход в ширину
    private Node find(int value){
        List<Node> line = new ArrayList<>(); // список линий
        line.add(root);
        while(line.size() > 0){ // пока у узла есть дети, выполняется цикл
            List<Node> nextLine = new ArrayList<>();
            for(Node node : line){
                if(node.value == value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    // класс Node, напримере работы с цифрами
    public class Node {
        int value; // значение узла дерева
        List<Node> children; // список детей
    }

}
