package util;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NotepadMainFrame extends JFrame {
    private JTextArea textArea;//文本编辑区域
    private FileOperations fileOperations;//文件操作
    private Clipboard clipboard;//剪切板
    private StatusBar statusBar;//状态栏

    //构造函数
    public NotepadMainFrame() {

        textArea = new JTextArea();
        //设置字体
        Font textAreaFont = new Font("Monospaced", Font.PLAIN, 20);
        textArea.setFont(textAreaFont);
        // 设置自动换行
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        fileOperations = new FileOperations(this);
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();


        statusBar = new StatusBar();
        add(statusBar.createStatusBar(), BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new JScrollPane(textArea));
        this.setVisible(true);

        // 设置字号
        JMenuBar menuBar = new JMenuBar();
        Font menuFont = new Font("SansSerif", Font.BOLD, 20);

        // 文件操作
        JMenu fileMenu = new JMenu("文件");
        fileMenu.setFont(menuFont); // 设置字体
        JMenuItem newMenuItem = new JMenuItem("新建");
        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem saveMenuItem = new JMenuItem("保存");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

      //文件操作的事件监听
       openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileOperations.openFile();
            }
        });


        newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileOperations.newFile();
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileOperations.saveFile();
            }
        });


        // 编辑操作
        JMenu editMenu = new JMenu("编辑");
        editMenu.setFont(menuFont); // 设置字体
        JMenuItem cutMenuItem = new JMenuItem("剪切");
        JMenuItem copyMenuItem = new JMenuItem("复制");
        JMenuItem pasteMenuItem = new JMenuItem("粘贴");
        JMenuItem searchMenuItem = new JMenuItem("查找");
        JMenuItem replaceMenuItem = new JMenuItem("替换");

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.addSeparator();
        editMenu.add(searchMenuItem);
        editMenu.add(replaceMenuItem);


        //编辑事件的监听
        cutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });

        copyMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });

        pasteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });

        searchMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FindAndReplaceDialog findDialog = new FindAndReplaceDialog(NotepadMainFrame.this, textArea);
                findDialog.setVisible(true);
            }
        });

        replaceMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FindAndReplaceDialog replaceDialog = new FindAndReplaceDialog(NotepadMainFrame.this, textArea);
                replaceDialog.setVisible(true);
            }
        });


        // 创建关于菜单
        JMenu aboutMenu = new JMenu("关于");
        aboutMenu.setFont(menuFont); // 设置字体
        menuBar.add(aboutMenu);

        // 创建Readme菜单项
        JMenuItem readMenuItem = new JMenuItem("Readme");
        aboutMenu.add(readMenuItem);

        // 为Readme菜单项添加事件监听器
        readMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(NotepadMainFrame.this,
                        "<html><span style='font-size:18px;'>这是一款作为java作业由我本人设计的<br>" +
                                "类windows记事本，希望你能喜欢^.^<br>" +
                                "功能设计上只保留了最基本的编辑功能<br><br>" +
                                "<p style='text-align:right;'>—— design by Wy</p></span></html>",
                        "Readme", // 对话框标题
                        JOptionPane.PLAIN_MESSAGE); // 对话框类型，不显示图标
            }
        });



        //菜单项UI设置
        UIManager.put("Menu.font", menuFont);
        UIManager.put("MenuItem.font", menuFont);

        //添加到菜单项
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);


        // 设置菜单
        setJMenuBar(menuBar);

        // 状态栏
        statusBar = new StatusBar();
        getContentPane().add(statusBar.createStatusBar(), BorderLayout.SOUTH);
        // 状态栏事件监听
        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try {
                    int row = textArea.getLineOfOffset(pos) + 1;
                    int col = pos - textArea.getLineStartOffset(row - 1) + 1;
                    statusBar.updatePosition(row, col);
                } catch (Exception ex) {
                    statusBar.updatePosition(0, 0);
                }
            }
        });


        // 其它设置
        setTitle("Notepad");
        setSize(700, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ... 功能用法 ...
    public JTextArea getTextArea() {
        return textArea;
    }

    public FileOperations getFileOperations() {
        return fileOperations;
    }

    public Clipboard getClipboard() {
        return clipboard;
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    // 主函数
    public static void main(String[] args) {

        //设置类windows的UI界面
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotepadMainFrame();
            }
        });



    }


}








