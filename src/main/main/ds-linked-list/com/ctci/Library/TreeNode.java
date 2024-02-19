/**
 * Cracking-The-Coding-Interview
 * TreeNode.java
 */
package com.ctci.Library;

/**
 * Class for Tree Node. Keeping this generic
 *
 * @param <T>
 * @author Deepak
 */
public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T data) {
        this.data = data;
    }

}
