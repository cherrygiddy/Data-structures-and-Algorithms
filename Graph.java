package com.company;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node=new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNOde = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNOde == null || toNode == null)
            throw new IllegalArgumentException();
        adjacencyList.get(fromNOde).add(toNode);
        // adjacencyList.get(toNode).add(fromNOde);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            throw new IllegalArgumentException("Idiot");
        for(var edge:adjacencyList.keySet())
            adjacencyList.get(edge).remove(node);
        adjacencyList.remove(node);
        nodes.remove(node);
    }
  public void removeEdge(String from,String to){
          var fromNOde = nodes.get(from);
          var toNode = nodes.get(to);
          if (fromNOde == null || toNode == null)
              throw new IllegalArgumentException();
          adjacencyList.get(fromNOde).remove(toNode);
  }
    public void print() {
        for (var source : adjacencyList.keySet()) {
            var target = adjacencyList.get(source);
           if (!target.isEmpty())
                System.out.println(source + " is connected to " + target);
        }
    }
    public void depthfirstTraversalRec(String root){
        depthfirstTraversalRec(nodes.get(root),new HashSet<>());
    }
    private void depthfirstTraversalRec(Node root,Set<Node>visited) {
        System.out.println(root);
        visited.add(root);
        for (var edge : adjacencyList.get(root)) {
            if (visited.contains(edge))
                continue;
            depthfirstTraversalRec(edge, visited);
        }
    }
    public void  depthfirstTraversalIter(String root){
        var node=nodes.get(root);
        Set<Node>visited= new HashSet<>();
        Stack<Node>stack= new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);
            for (var edge : adjacencyList.get(current))
                if (!visited.contains(edge))
                    stack.push(edge);
        }
    }
    public void breadhFirstTraversal(String root) {
        var node = nodes.get(root);
        if (node==null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var startNode = queue.remove();
            if (visited.contains(startNode))
                continue;
            System.out.println(startNode);
            visited.add(startNode);
            for (var edge : adjacencyList.get(startNode)) {
                if (!visited.contains(edge))
                    queue.add(edge);
            }
        }
    }
    public List<Node> topologicalSort(){
        Stack<Node>stack= new Stack<>();
        Set<Node>visited= new HashSet<>();
        for (var node:nodes.values()){
            topologicalSort(node,visited,stack);
        }
        List<Node>list= new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop());
        return list;
    }
    private void topologicalSort(Node node,Set<Node>visited,Stack<Node>stack){
            if (visited.contains(node))
                return;
            visited.add(node);
            for (var edge:adjacencyList.get(node)){
                topologicalSort(edge,visited,stack);
            }
            stack.push(node);
    }
    public boolean  hasCycle(){
        Set<Node>all= new HashSet<>();
        Set<Node>visiting= new HashSet<>();
        Set<Node>visited= new HashSet<>();
        all.addAll(nodes.values());
        while (!all.isEmpty()) {
            var startnode = all.iterator().next();
            if (hasCycle(startnode,all,visiting,visited))
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node node,Set<Node>all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);
        for (var edge:adjacencyList.get(node)) {
            if (visited.contains(edge))
                continue;
            if (visiting.contains(edge)||hasCycle(edge,all,visiting,visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
