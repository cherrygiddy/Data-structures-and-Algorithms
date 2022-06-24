package com.company;

import java.util.*;
import java.util.zip.DeflaterInputStream;

public class WeightedGraph {
    private class Node {
        private String lable;
        private List<Edge> edges = new ArrayList<>();

        public Node(String lable) {
            this.lable = lable;
        }

        @Override
        public String toString() {
            return lable;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node to;
        private Node from;
        private int weights;

        public Edge(Node to, Node from, int weights) {
            this.to = to;
            this.from = from;
            this.weights = weights;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }
    public boolean ContainsNode(String label){
      return nodes.containsKey(label);
    }
    public void addEdgae(String from, String to, int weight) {
        var fromnode = nodes.get(from);
        var toNOde = nodes.get(to);
        if (fromnode == null || toNOde == null)
            throw new IllegalArgumentException();
        fromnode.addEdge(toNOde, weight);
        toNOde.addEdge(fromnode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var target = node.getEdges();
            if (!target.isEmpty())
                System.out.println(node + " is connected " + target);
        }
    }
   private class  NodeEntry{
        private Node node;
         int priority;

       public NodeEntry(Node node, int priority) {
           this.node = node;
           this.priority = priority;
       }
   }
   public Path gettheshortestpath(String from,String to) {
       var fromNode = nodes.get(from);
       var toNode = nodes.get(to);
       if (fromNode == null || toNode == null)
           throw new IllegalArgumentException();
       Map<Node, Integer> distance = new HashMap<>();
       Map<Node, Node> previousNodes = new HashMap<>();
       Set<Node> visited = new HashSet<>();
       PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne->ne.priority));
       for (var node : nodes.values())
           distance.put(node, Integer.MAX_VALUE);
       distance.replace(fromNode, 0);
       queue.add(new NodeEntry(fromNode, 0));
       while (!queue.isEmpty()) {
           var current = queue.remove().node;
           visited.add(current);
           for (var edge : current.getEdges()) {
               if (visited.contains(edge.to))
                   continue;
               var newdistance = distance.get(current) + edge.weights;
               if (newdistance < distance.get(edge.to)) {
                   distance.replace(edge.to, newdistance);
                   previousNodes.put(edge.to, current);
                   queue.add(new NodeEntry(edge.to, newdistance));
               }
           }
       }
       return buildpath(previousNodes,toNode);
   }
   private Path buildpath(Map<Node, Node> previousNodes,Node toNode){
        Stack<Node>stack=new Stack<>();
        stack.push(toNode);
       var previous = previousNodes.get(toNode);
        while (previous!=null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }
       var path=new Path();
        while (!stack.isEmpty()){
            path.add(stack.pop().lable);
        }
         return path;
   }
   public  boolean hasCycle(){
        Set<Node>visited= new HashSet<>();
        for (var node:nodes.values())
            if (!visited.contains(node))
               if (hasCycle(node,null,visited))
                   return true;
        return false;
   }
   private boolean hasCycle(Node node,Node parent,Set<Node>visited){
        visited.add(node);
        for (var edge:node.getEdges()) {
            if (edge.to == parent)
                continue;
            if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
                return true;
        }
        return false;
   }
   public WeightedGraph minimumSpanningTree() {
       var tree= new WeightedGraph();
       PriorityQueue<Edge>queue=new PriorityQueue<>(Comparator.comparingInt(e-> e.weights));
       var startNode=nodes.values().iterator().next();
       queue.addAll(startNode.getEdges());
       tree.addNode(startNode.lable);
       while (tree.nodes.size()<nodes.size()) {
           var minEdge = queue.remove();
           var nextNode = minEdge.to;
           if (tree.ContainsNode(nextNode.lable))
               continue;
           tree.addNode(nextNode.lable);
           tree.addEdgae(minEdge.from.lable, nextNode.lable, minEdge.weights);

           for (var edge : nextNode.getEdges()) {
               if (!tree.ContainsNode(edge.to.lable))
                   queue.add(edge);
           }
       }
       return tree;
   }
}
