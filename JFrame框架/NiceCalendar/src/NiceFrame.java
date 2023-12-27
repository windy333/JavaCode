//创建窗口界面
import java.awt.*;
import javax.swing.*;

public class NiceFrame extends JFrame{
    private static final long serialVersionUID = 1L;          //default
    
    NiceClock NC = new NiceClock(new ImageIcon("WHITE.jpg")); //背景色
    NiceMenubar NM = new NiceMenubar(NC);                     //链接NiceMenubar

    JPanel Panel_Left = new JPanel(new GridLayout(2, 1));     //设置网格布局

    public NiceFrame(){   

        setVisible(true);                                                               
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);           //窗口关闭时释放资源
 
        Panel_Left.add(NC);                                   
        Panel_Left.add(NM.NP.NL);                              
        
       
        setLayout(new GridLayout(1, 2));                //设置窗口布局为1行2列的网格布局
        setJMenuBar(NM);                                     //添加Menubar到窗口
        add(Panel_Left);                                     //添加Panel_Left到窗口        
        add(NM.NP);                                          //添加NicePanel到窗口
        
        NM.NP.refresh();	                                 //显示默认日历
    } 
} 