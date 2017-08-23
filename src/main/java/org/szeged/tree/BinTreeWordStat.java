package org.szeged.tree;

/**
 * Created by istvan on 8/10/17.
 */
public class BinTreeWordStat {


    public WordFreqNode serch(WordFreqNode root, String searchValue) {

        while (root != null && !root.getWord().equals(searchValue)) {
            int diff = root.getWord().compareTo(searchValue);

            if (diff < 0) {
                root = root.getLeftNode();
            } else {
                root = root.getRighNode();
            }
        }
        return root;
    }

    public WordFreqNode printTree(WordFreqNode root) {

        if (root == null) {
            return root;

        } else {

            if (root.getRighNode() != null) {
                return printTree(root.getRighNode());
            }
            System.out.println(root);
            if (root.getLeftNode() != null) {
                return printTree(root.getLeftNode());
            }

        }
        return root;
    }


    public WordFreqNode insertNode(WordFreqNode root, String word) {

        if (root == null) {
            return new WordFreqNode(word, 1, null, null);
        } else {
            int diff = root.getWord().compareTo(word);
            if (diff < 0) {
                root.setLeftNode(insertNode(root.getLeftNode(), word));
                return root;
            } else if (diff > 0) {
                root.setRighNode(insertNode(root.getRighNode(), word));
                return root;
            } else {
                root.setFreq(root.getFreq() + 1);
                return root;
            }
        }
    }

}
