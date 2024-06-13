//提醒功能与桌面标签

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.Random;

public class NiceLabels extends JPanel{
	private static final long serialVersionUID = 1L;
    
    Color C = Color.WHITE;
    Random R = new Random();
    JLabel Label_Alarm = new JLabel("Alarm: 00 : 00");
    JLabel Label_Remind = new JLabel("Reminds: 愿你每天都有一个好心情");
    JLabel Label_Tips = new JLabel("Tips: ^  .  ^");
    

    NiceLabels(){
        Label_Alarm.setFont(new Font("Arove", 1, 30));
        Label_Alarm.setForeground(Color.BLUE);
        
        Label_Remind.setFont(new Font("Arove", 1, 30));
        Label_Remind.setForeground(Color.BLUE);
        
        Label_Tips.setFont(new Font("Arove", 1, 30));
        Label_Tips.setForeground(Color.BLUE);
      
        setLayout(new GridLayout(3, 1));   
       // setBackground(C); 
        
        add(Label_Remind);
        add(Label_Tips);
        add(Label_Alarm);
    }

    String getTips(){
        int i = R.nextInt(10);
        String S[] = new String[10];
        S[0] = "Tips: 猜猜今天会发生什么";
        S[1] = "Tips: 不宜喝酒|宜出行|宜葬礼";
        S[2] = "Tips: 宜拜访|宜交易/宜理发|宜出行";
        S[3] = "Tips: 宜结婚|宜洗澡";
        S[4] = "Tips: 不宜祈祷|宜建造|宜种植";
        S[5] = "Tips: 不宜做任何事";
        S[6] = "Tips: 宜祈祷|宜结婚|宜洗澡|宜旅行";
        S[7] = "Tips: 不宜结婚|不宜游泳|不宜装饰";
        S[8] = "Tips: 不宜建造|不宜交易|不宜砍伐";
        S[9] = "Tips: 恭祝您事事顺利";

        return S[i];
    }
    
    //针对部分时间设置提醒
    void getRemind(int num){
        switch(num){
            case 11: Label_Remind.setText("Reminds: Jan.1st NewYear's Day");break;
            case 214: Label_Remind.setText("Reminds: Feb.14th Valentine's Day");break;
            case 38: Label_Remind.setText("Reminds: Mar.8th Women's Day");break;
            case 41: Label_Remind.setText("Reminds: Apr.1st April Fool's Day");break;
            case 422: Label_Remind.setText("Reminds: Apr.22th Earth Day");break;
            case 51: Label_Remind.setText("Reminds: May 1st Labour Day");break;
			case 54: Label_Remind.setText("Reminds: May 4th Youth Day");break;
            case 61: Label_Remind.setText("Reminds: June.1st Children's Day");break;
            case 71: Label_Remind.setText("Reminds: July 1st CPC Founding Day");break;
			case 81: Label_Remind.setText("Reminds: Aug.1st Army Day");break;
            case 910: Label_Remind.setText("Reminds: Sept.10th Teacher's Day");break;
            case 101: Label_Remind.setText("Reminds: Oct.1st National Day");break;
            case 1128: Label_Remind.setText("Reminds: Nov.28th Thanksgiving Day");break;
            case 1224: Label_Remind.setText("Reminds: Dec.24th Christmas Eve");break;
            case 1225: Label_Remind.setText("Reminds: Dec.25th Christmas Day");break;
            default: Label_Remind.setText("Reminds: NULL");
        }
    }
}