package org.szeged.treeKotlin

/**
 * Created by istvan on 7/11/17.
 */
data class WordStatNode(var word: String?, var freq: Int, var right: WordStatNode?, var left: WordStatNode?)

class BinTreeWordStat {

    fun search(root: WordStatNode?, searchValue: String): WordStatNode? {
        var moveNode: WordStatNode? = root

        while (moveNode != null && moveNode.word != searchValue) {
            val diff = moveNode.word?.compareTo(searchValue) ?: 0

            if (diff < 0) {
                moveNode = moveNode.left
            } else {
                moveNode = moveNode.right
            }
        }
        return moveNode
    }

    fun printTree(root: WordStatNode?): WordStatNode? {

        return if (root == null) {
            root

        } else {

            root.right ?: printTree(root.right)
            println(root)
            root.right ?: printTree(root.left)
        }
    }




    fun insertNode(root: WordStatNode?, word: String): WordStatNode? {

        return if (root == null) {
            WordStatNode(word, 1, null, null)
        } else {
            val diff = root.word!!.compareTo(word)
            if (diff < 0) {
                root.left = insertNode(root.left, word)
                root
            } else if (diff > 0) {
                root.right = insertNode(root.right, word)
                root
            } else {
                root.freq++
                root
            }
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {

//val text = "this is my laptop. I prefer mac , than laptop. My favorite laptop is lenovo. mac mac mac"
  val text = "egy ketto ketto harom harom harom negy negy negy negy"
            val tree = BinTreeWordStat()

            val root = WordStatNode("",0,null,null)

            text.split(" ").forEach { token ->
                tree.insertNode(root,token)
            }

            tree.printTree(root)
        }
    }
}

