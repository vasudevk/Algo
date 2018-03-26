package exampleBtree;

import java.util.ArrayList;
import java.util.List;

public class TreeModel<T> {

    private T data = null;
    private List<TreeModel> children = new ArrayList<>();
    private TreeModel parent = null;

    public TreeModel(T data) {
        this.data = data;
    }

    public void addChild(TreeModel child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        TreeModel<T> newChild = new TreeModel<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<TreeModel> children) {
        for (TreeModel t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(TreeModel parent) {
        this.parent = parent;
    }

    public TreeModel getParent() {
        return parent;
    }
}