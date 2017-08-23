package org.szeged.tree;

public class BinTreeJava {




    public BinTreeNode search(BinTreeNode root, Integer searchValue) {

        while (root != null && root.getValue() != searchValue) {
            if (searchValue < root.getValue()) {
                root = root.getRightNode();
            } else {
                root = root.getLeftNode();
            }
        }

        return root;
    }

    public BinTreeNode printTree(BinTreeNode root) {
        if (root == null) {
            System.out.println("A fa ures.");
            return root;
        } else {
            if (root.getRightNode() != null) {
                return printTree(root.getRightNode());
            }
            //System.out.println(root);
            if (root.getLeftNode() != null) {
                return printTree(root.getLeftNode());
            }
        }
        return root;
    }


    public BinTreeNode preOrderPrintTree(BinTreeNode root) {
        if (root == null) {
            return root;
        } else {
            System.out.println(root);
            if (root.getRightNode() != null) {
                return printTree(root.getRightNode());
            }
            if (root.getLeftNode() != null) {
                return printTree(root.getLeftNode());
            }
        }
        return root;
    }

    public void delete(BinTreeNode root) {
        if (root == null) {

            System.out.println("A fa üres!");
        } else {
            if (root.getLeftNode() != null) {
                delete(root.getLeftNode());
            }
            if (root.getRightNode() != null) {
                delete(root.getRightNode());
            }

            root.setLeftNode(null);
            root.setRightNode(null);
            root.setValue(0);
        }

    }

    public Integer numberOfElements(BinTreeNode root) {
        if (root == null) {
            return 0;

        } else {
            return numberOfElements(root.getRightNode()) + numberOfElements(root.getLeftNode()) + 1;
        }
    }

    public Integer numberOfLeafs(BinTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.getRightNode() == null && root.getLeftNode() == null) {
            return 1;

        } else {
            return numberOfLeafs(root.getRightNode()) + numberOfLeafs(root.getLeftNode());
        }
    }


    public Integer numberOfElementInLevel(BinTreeNode root, Integer level) {
        if (root == null) {
            return 0;
        } else if (level == 0) {
            return 1;

        } else {
            return numberOfElementInLevel(root.getRightNode(), level - 1) + numberOfElementInLevel(root.getLeftNode(), level - 1);
        }

    }


    public BinTreeNode insertNode(BinTreeNode root, Integer value) {

        if (root == null) {
            return new BinTreeNode(value, null, null);
        } else if (root.getValue() < value) {
            root.setLeftNode(insertNode(root.getLeftNode(), value));
            return root;
        } else if (root.getValue() > value) {
            root.setRightNode(insertNode(root.getRightNode(), value));
            return root;
        } else {
            return root;
        }

    }


}
