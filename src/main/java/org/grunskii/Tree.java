package org.grunskii;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tree {
    private final String node;
    private final List<Tree> children;
    // number of last tree in graphviz
    private static int numTree = 0;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
        this.children = List.of();
    }

    public void updateGraphvizLines(List<String> lines, int parent) {
        int currentNum = numTree++;
        if (parent == -1) {
            lines.add("strict graph {");
        }
        lines.add(currentNum + " [label=\"" + node + "\"]");
        if (parent > -1) {
            lines.add(parent + " -- " + currentNum);
        }
        for (Tree child : children) {
            child.updateGraphvizLines(lines, currentNum);
        }
        if (parent == -1) {
            lines.add("}");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (!node.equals(tree.node)) return false;
        return Objects.equals(children, tree.children);
    }

    @Override
    public int hashCode() {
        int result = node.hashCode();
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}


