package com.GraphDataStructure;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class CloneAGraph {
    public static void main(String[] args) {


        GraphNode n1 = new GraphNode(1, new ArrayList<>());
        GraphNode n2 = new GraphNode(2, new ArrayList<>());
        GraphNode n3 = new GraphNode(3, new ArrayList<>());
        GraphNode n4 = new GraphNode(4, new ArrayList<>());

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n2.neighbors.add(n4);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        n1.displayGraphNode();
        n2.displayGraphNode();
        n3.displayGraphNode();
        n4.displayGraphNode();

        cloneGraph(n1);
//        bfsGraphOriginal();
    }


    /*
    Not working having some logical error in the below Method
     */
    public static GraphNode cloneGraph(GraphNode node){
        Map<GraphNode, Boolean> map_visited1 = new HashMap<>();
        Queue<GraphNode> queue1 = new LinkedList<>();

        GraphNode node_copy = new GraphNode(node.value);
        Map<GraphNode, Boolean> map_visited2 = new HashMap<>();
        Queue<GraphNode> queue2 = new LinkedList<>();


        if(!map_visited1.containsKey(node)){
            map_visited1.put(node, false);
        }
        if(!map_visited2.containsKey(node)){
            map_visited1.put(node_copy, false);
        }

        queue1.offer(node);
        queue2.offer(node_copy);

        while(!queue1.isEmpty()){
            GraphNode temp1 = queue1.poll();
            System.out.println(temp1.value+" "+temp1);
            List<GraphNode> neighbourstemp1 = temp1.neighbors;
            int length1 = neighbourstemp1.size();
            map_visited1.put(temp1, true);


            GraphNode temp2 = queue2.poll();
            List<GraphNode> neighbourstemp2 = temp2.neighbors;


            for(int i=0;i<length1;i++){
                if(!map_visited1.containsKey(neighbourstemp1.get(i))){
                    map_visited1.put(neighbourstemp1.get(i), false);
                    queue1.offer(neighbourstemp1.get(i));
                }

                temp2.neighbors.add(neighbourstemp2.get(i));

//                if(!map_visited2.containsKey(neighbourstemp2.get(i))){
//                    map_visited2.put(neighbourstemp2.get(i), false);
//                    queue2.offer(neighbourstemp2.get(i));
//                }
            }

        }

        return node_copy;
    }

    public static void bfsGraphOriginal(GraphNode node){
        Map<GraphNode, Boolean> map_visited1 = new HashMap<>();
        Queue<GraphNode> queue1 = new LinkedList<>();

        if(!map_visited1.containsKey(node)){
            map_visited1.put(node, false);
        }

        queue1.offer(node);

        while(!queue1.isEmpty()){
            GraphNode temp1 = queue1.poll();
            System.out.println(temp1.value+" "+temp1);
            List<GraphNode> neighbourstemp1 = temp1.neighbors;
            int length1 = neighbourstemp1.size();
            map_visited1.put(temp1, true);


            for(int i=0;i<length1;i++){
                if(!map_visited1.containsKey(neighbourstemp1.get(i))){
                    map_visited1.put(neighbourstemp1.get(i), false);
                    queue1.offer(neighbourstemp1.get(i));
                }

            }


        }

    }
}
