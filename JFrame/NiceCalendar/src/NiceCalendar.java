
/*
    感谢 NiceCalendar的作者@lofone于Git上开源的代码，
    本人利用现有框架和所学java知识重构了30—40%的代码来
    重新实现这个软件

    __Name__ : NiceCalendar 6.0
    __Term__ : 2023-11-26 - 2023-12-24
    __Authr__ : Wyu
    __Major__ : Informationand Computing Science

*/


import java.awt.*;

public class NiceCalendar{                                
    public static void main(String[] args){
        NiceFrame NF = new NiceFrame();       
        NF.setBounds(200,200,1200,800);
        Image image = Toolkit.getDefaultToolkit().createImage("logo.jpg");   //设置icon图标                   
        NF.setIconImage(image);                                 
        NF.setTitle("NiceCalendar");          
        NF.setVisible(true);                   
     };          
} 