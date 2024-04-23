class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTree{
    TreeNode root;

    public BinaryTree() {
        root=null;
    }

    // 1、前序遍历
    // 首先访问当前节点，然后递归地对左子树进行前序遍历，最后递归地对右子树进行前序遍历。
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // 2、中序遍历
    // 先递归地对左子树进行中序遍历，然后访问当前节点，最后递归地对右子树进行中序遍历。
    // 对于二叉搜索树，中序遍历可以按升序访问所有节点。
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    // 3、后序遍历
    // 首先递归地对左子树进行后序遍历，然后递归地对右子树进行后序遍历，最后访问当前节点。
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    // 4、插入节点
    public TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // 5、删除节点
    public TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            // 节点有一个子节点或没有子节点
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 节点有两个子节点：获取右子树的最小值节点
            root.value = minValue(root.right);
            // 删除右子树的最小值节点
            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }

    // 获取以给定节点为根的树中的最小值节点
    int minValue(TreeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // 6、获取节点的高度
    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1; // 空节点的高度定义为-1
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // 7、获取树的高度
    public int getTreeHeight() {
        return getHeight(root);
    }


    // 主函数，用于测试
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("前序遍历:");
        tree.preOrderTraversal(tree.root);
        System.out.println("\n中序遍历:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n后序遍历:");
        tree.postOrderTraversal(tree.root);
        System.out.println("\n树的高度是: " + tree.getTreeHeight());

        // 删除节点
        System.out.println("\n删除值为50的节点");
        tree.deleteNode(tree.root, 50);

        System.out.println("\n前序遍历:");
        tree.preOrderTraversal(tree.root);
        System.out.println("\n中序遍历:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n后序遍历:");
        tree.postOrderTraversal(tree.root);
        System.out.println("\n树的高度是: " + tree.getTreeHeight());


    }

}

/*

平衡二叉树（Balanced Binary Tree）：
    一棵二叉树，如果每个节点的左右子树的高度差不超过1，则称为平衡二叉树。

二叉搜索树（Binary Search Tree, BST）：
    一棵二叉树，如果对于任意节点，其左子树中的所有节点的值都小于该节点的值，
    其右子树中的所有节点的值都大于该节点的值，则称为二叉搜索树。
*/
