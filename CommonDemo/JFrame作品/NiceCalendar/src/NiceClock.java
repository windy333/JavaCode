//实现界面的时钟

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class NiceClock extends JPanel{
    private static final long serialVersionUID = 1L; 
	ImageIcon I;
	
    public void paintComponent(Graphics G){ //绘制组件
        Graphics2D G2D = (Graphics2D)G;
        G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		G2D.setColor(Color.RED);
		
        G2D.drawImage(I.getImage(), 0, 0, getWidth(), getHeight(), I.getImageObserver()); //set background
		 

    	int x_Wideth = this.getWidth() / 2;  //获取面板宽度
        int y_Wideth = this.getHeight() / 2;  //获取面板高度

		//计算时钟界面的半径
        int radius = (int) (Math.min(this.getWidth(), this.getHeight()) * 0.8 * 0.5);  //calculate the radius of clock

        for(int i = 0; i < 12; i++){  
            double angle = Math.PI / 180 * i * (360 / 12); 
            int x = (x_Wideth - 4) + (int)((radius - 12) * Math.cos(angle));  
            int y = (y_Wideth + 4) + (int)((radius - 12) * Math.sin(angle));  

            int j = i + 3;
            if (j > 12)  
                j = j - 12;  

            G2D.drawString(Integer.toString(j), x, y);  //将1-12添加到时钟上             
        }
   
        AffineTransform old = G2D.getTransform(); 		//保存当前的坐标转换

        for (int i = 0; i < 60; i++){  
            int w = i % 5 == 0 ? 6 : 3;  
   
        	G2D.fillRect(x_Wideth - 2, 28, w, 3);
			G2D.rotate(Math.toRadians(6), x_Wideth, y_Wideth);
		} // 在时钟上添加标记

		G2D.setTransform(old);

		Calendar C = Calendar.getInstance();
		
		//获取当前时间
		int hour = C.get(Calendar.HOUR_OF_DAY);
		int minute = C.get(Calendar.MINUTE);
		int second = C.get(Calendar.SECOND);
		
		//计算时针的角度
		double hour_angle = (hour - 12 + minute / 60d) * 360d / 12d;
		G2D.rotate(Math.toRadians(hour_angle), x_Wideth, y_Wideth);
		int x_hour_array[] = { x_Wideth, x_Wideth + 9, x_Wideth, x_Wideth - 9 };
		int y_hour_array[] = { 65, y_Wideth, y_Wideth + 10, y_Wideth };

		//绘制时针
		G2D.drawPolygon(x_hour_array, y_hour_array, x_hour_array.length);
		G2D.setTransform(old);

		//分针同理
		double minute_angle = (minute + second / 60d) * 360d / 60d;
		G2D.rotate(Math.toRadians(minute_angle), x_Wideth, y_Wideth);
		int x_minute_array[] = { x_Wideth, x_Wideth + 6, x_Wideth, x_Wideth - 6 };
		int y_minute_array[] = { 45, y_Wideth, y_Wideth + 12, y_Wideth };
		G2D.drawPolygon(x_minute_array, y_minute_array, x_minute_array.length);
		G2D.setTransform(old);

		G2D.setBackground(Color.WHITE);
	}
	NiceClock(ImageIcon I){
		this.I = I;
	}
}