package org.szeged.tree

/**
 * Created by istvan on 7/10/17.
 */


data class BinTreeNode(var value: Int, var left: BinTreeNode?, var right: BinTreeNode?)


class BinTree {

    fun search(root: BinTreeNode?, searchValue: Int): BinTreeNode? {
        var moveNode: BinTreeNode? = root

        while (moveNode != null && moveNode.value != searchValue) {
            if (searchValue < moveNode.value) {
                moveNode = moveNode.right
            } else {
                moveNode = moveNode.left
            }
        }
        return moveNode
    }

    fun printTree(root: BinTreeNode?): BinTreeNode? {

        return if (root == null) {
            root

        } else {

            root.right ?: printTree(root.right)
            println(root)
            root.right ?: printTree(root.left)
        }
    }

    fun preOrderPrintTree(root: BinTreeNode?) : BinTreeNode? {
        return if (root == null) {
            root

        } else {
            println(root.value)
            root.right ?: preOrderPrintTree(root.left)
            root.right ?: preOrderPrintTree(root.right)

        }
    }

    fun delete(root: BinTreeNode?) {

        if (root == null) {


        } else {
            root.left ?: delete(root.left)
            root.right ?: delete(root.right)
            root.left =null
            root.right = null
            root.value = 0
        }
    }

    fun numberOfElements(root: BinTreeNode?) : Int {
       return  if (root == null) {
0

        } else {
            numberOfElements(root.right) + numberOfElements(root.left) +1
        }
    }

    fun numberOfLeafs(root: BinTreeNode?) : Int {
        return if (root == null) {
            0
        } else if (root.right == null && root.left == null ){
            1

        } else {
            numberOfLeafs(root.left) + numberOfLeafs(root.right)
        }
    }

    fun numberOfElementInLevel(root: BinTreeNode?, level : Int) : Int {
        return if (root == null){
            0
        } else if (level == 0){
1

        } else {
            numberOfElementInLevel(root.left, level -1) + numberOfElementInLevel(root.right, level -1)
        }

    }

    fun insertNode(root: BinTreeNode?, value: Int) : BinTreeNode?{

        return if (root == null){
            BinTreeNode(value,null, null)
        } else if (root.value < value){
            root.left = insertNode(root.left, value)
            root
        } else if (root.value > value){
            root.right = insertNode(root.right,value)
            root
        } else {
            root
        }

    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val binTree = BinTree()

            var root = binTree.insertNode(null, 5)

            binTree.insertNode(root,6)
            binTree.printTree(root)
            binTree.insertNode(root,7)
            binTree.printTree(root)
            binTree.insertNode(root,8)
            binTree.printTree(root)
            binTree.insertNode(root,4)
            binTree.printTree(root)
            binTree.insertNode(root,3)
            binTree.printTree(root)
            binTree.insertNode(root,2)
            binTree.printTree(root)
            binTree.insertNode(root,89)
            binTree.printTree(root)
            binTree.insertNode(root,66)
            binTree.printTree(root)
            binTree.insertNode(root,62)
            binTree.printTree(root)
            binTree.insertNode(root,61)
            binTree.insertNode(root,60)

            binTree.printTree(root)


val level = 0
            println("Number of elements at level $level: \t" + binTree.numberOfElementInLevel(root,level))

            println("Number of elements: \t " + binTree.numberOfElements(root))

            println("number of leafs:\t" + binTree.numberOfLeafs(root))

            println(binTree.search(root,62))


        }
    }
}

