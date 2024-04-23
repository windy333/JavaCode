import javax.swing.*;
import java.awt.*;



class BinaryTreeDraw extends JPanel {
    private BinaryTree tree;
    private final int nodeRadius = 30;
    private final int levelGap = 50;

    public BinaryTreeDraw(BinaryTree tree) {
        this.tree = tree;
    }

    // 重写paintComponent进行自定义绘制
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tree.root != null) {
            drawTree(g, tree.root, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    // 递归方法绘制二叉树
    private void drawTree(Graphics g, TreeNode node, int x, int y, int hGap) {
        if (node == null) {
            return;
        }

        // 绘制左子树
        if (node.left != null) {
            int leftX = x - hGap;
            int leftY = y + levelGap;
            g.drawLine(x, y, leftX, leftY);
            drawTree(g, node.left, leftX, leftY, hGap / 2);
        }

        // 绘制右子树
        if (node.right != null) {
            int rightX = x + hGap;
            int rightY = y + levelGap;
            g.drawLine(x, y, rightX, rightY);
            drawTree(g, node.right, rightX, rightY, hGap / 2);
        }

        // 绘制当前节点
        g.setColor(Color.WHITE);
        g.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
        g.drawString(Integer.toString(node.value), x - 6, y + 4);
    }

    // 显示二叉树的图像
    public static void display(BinaryTree tree, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new BinaryTreeDraw(tree));
        frame.pack();
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*单个作图
    public static void display(BinaryTree tree) {
        JFrame frame = new JFrame("Binary Tree Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BinaryTreeDraw(tree));
        frame.pack();
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
*/
    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // 显示删除节点前的二叉树图像
        BinaryTreeDraw.display(tree, "Binary Tree Before Deletion");

        try {
            Thread.sleep(3000); // 等待3秒，优先级问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n删除值为50的节点");
        tree.deleteNode(tree.root, 50);

        // 显示删除节点后的二叉树图像
        BinaryTreeDraw.display(tree, "Binary Tree After Deletion");
    }


}






