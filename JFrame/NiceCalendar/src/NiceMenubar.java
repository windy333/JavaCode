//面板菜单选项功能

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NiceMenubar extends JMenuBar implements ActionListener{
    private static final long serialVersionUID = 1L;
    
    NicePanel NP = new NicePanel();                           
    NiceClock NC;                                             

    JMenu Menu_Start = new JMenu("Start(S)   ");               //menu Start
    JMenu Menu_Function = new JMenu("Function(F)");            //menu Function
    JMenu Menu_Help = new JMenu("    Help(H)");                 //menu help

        
    JMenu Item_changeSkin = new JMenu("Skin");                   //item change skin
    JMenuItem Item_Exit = new JMenuItem("Exit");                 //finish system

    JMenuItem Item_Alarm = new JMenuItem("Alarm");              //item alarm
    JMenuItem Item_Skip = new JMenuItem("Skip");                //item skip to anywhere
    JMenuItem Item_lastYear = new JMenuItem("LastYear");        //skip to last year
    JMenuItem Item_nextYear = new JMenuItem("NextYear");        //skip to next year
    JMenuItem Item_lastMonth = new JMenuItem("LastMonth");      //skip to last month
    JMenuItem Item_nextMonth = new JMenuItem("NextMonth");      //skip to next month
        
    JMenuItem Item_Readme = new JMenuItem("Readme");            //show readme
    JMenuItem Item_About = new JMenuItem("About");              //show about
    
    //skin
    JMenuItem Item_whiteSkin = new JMenuItem("QuietWhite");     
    JMenuItem Item_blackSkin = new JMenuItem("PureBlack");
    JMenuItem Item_darkSkin = new JMenuItem("VesperalDark");
    JMenuItem Item_yellowSkin = new JMenuItem("SoftYellow");
        
    NiceMenubar(NiceClock NC){
        this.NC = NC;
        
        /*add items to menu*/
        Menu_Start.add(Item_changeSkin);
        Menu_Start.add(Item_Exit);
        
        Menu_Function.add(Item_Alarm);
        Menu_Function.add(Item_Skip);
        Menu_Function.add(Item_lastYear);
        Menu_Function.add(Item_nextYear);
        Menu_Function.add(Item_lastMonth);
        Menu_Function.add(Item_nextMonth);
        
        Menu_Help.add(Item_Readme);
        Menu_Help.add(Item_About);    
        
        Item_changeSkin.add(Item_whiteSkin);
        Item_changeSkin.add(Item_yellowSkin);
        Item_changeSkin.add(Item_blackSkin);
        Item_changeSkin.add(Item_darkSkin);
        
        /*add action listener */
        Item_changeSkin.addActionListener(this);
        Item_Exit.addActionListener(this);

        Item_Alarm.addActionListener(this);
        Item_Skip.addActionListener(this);
        Item_lastYear.addActionListener(this);
        Item_nextYear.addActionListener(this);
        Item_lastMonth.addActionListener(this);
        Item_nextMonth.addActionListener(this);
        
        Item_Readme.addActionListener(this);
        Item_About.addActionListener(this);
        
        Item_blackSkin.addActionListener(this);
        Item_whiteSkin.addActionListener(this);
        Item_darkSkin.addActionListener(this);
        Item_yellowSkin.addActionListener(this);

        add(Menu_Start);
        add(Menu_Function);
        add(Menu_Help);  
        changeSkin(Color.WHITE); //默认皮肤
    }      

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == Item_Exit){
            System.exit(0);                         //exit(0)
        }
        
        else if(e.getSource() == Item_Alarm){
            new NiceAlarm(NP.NL);
        }
        
        else if(e.getSource() == Item_whiteSkin){
            getComponent().setBackground(Color.WHITE);
            changeSkin(Color.WHITE);
            NC.I = new ImageIcon("WHITE.jpg");
            NC.repaint();
        }
        else if(e.getSource() == Item_blackSkin){
            getComponent().setBackground(Color.BLACK);
            changeSkin(Color.BLACK);
            NC.I = new ImageIcon("BLACK.jpg");
            NC.repaint();
        }
        else if(e.getSource() == Item_darkSkin){
            getComponent().setBackground(Color.DARK_GRAY);
            changeSkin(Color.DARK_GRAY);
            NC.I = new ImageIcon("DARK.jpg");
            NC.repaint();
        }
        else if(e.getSource() == Item_yellowSkin){
            getComponent().setBackground(Color.YELLOW);
            changeSkin(Color.YELLOW);
            NC.I = new ImageIcon("YELLOW.jpg");
            NC.repaint();
        }
        
        else if(e.getSource() == Item_Skip){
            new NiceSkip(NP);
        }
        else if(e.getSource() == Item_lastYear){
            NP.NB.setYear(NP.NB.getYear()-1);           
            NP.refresh();
        }
		else if(e.getSource() == Item_nextYear){
            NP.NB.setYear(NP.NB.getYear()+1);
            NP.refresh(); 
        }
        
        else if(e.getSource() == Item_lastMonth){
            NP.NB.setMonth(NP.NB.getMonth() - 1);
            NP.refresh();
        }
        else if(e.getSource() == Item_nextMonth){
            NP.NB.setMonth(NP.NB.getMonth() + 1);
            NP.refresh();
        }
        else if(e.getSource() == Item_Readme){                      //readme
            JOptionPane.showMessageDialog(this, 
            "这是一款名为NiceCalendar的小软件，希望你能喜欢\n"
            +"感谢作者@lofone于Git上开源的代码\n"
            +"本人利用现有框架重构30—40%的代码完成这个项目\n"
            +"\t\t\t\t@ ^ . ^ @   Christmas Happy "
            ,"Readme",
            JOptionPane.CLOSED_OPTION);
        }
        else if(e.getSource() == Item_About){                       //about
            JOptionPane.showMessageDialog(this, 
            "Name: Windy\nMajor: Informationand Computing Science\nEmail:rainy3wei@outlook.com ",
            "About", JOptionPane.CLOSED_OPTION);
        }
    }
   
    public void changeSkin(Color C){        
        NP.NL.setBackground(C);
        NP.Button_Current.setBackground(C);
        NP.Button_Current.setBackground(C);
        NP.Button_lastYear.setBackground(C);
        NP.Button_nextYear.setBackground(C);
        NP.Button_lastMonth.setBackground(C);
        NP.Button_nextMonth.setBackground(C);
        NP.Panel_South.setBackground(C);
        NP.Panel_North.setBackground(C);
        NP.Panel_Center.setBackground(C); 
        NP.Label_Year.setBackground(C);
        NP.Label_Month.setBackground(C);
        NP.Label_Calendar.setBackground(C);
        
        for(int i = 0; i < 42; i ++){
            NP.Button_Day[i].setBackground(C);
        }
    } 
} 