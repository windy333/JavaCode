//闹钟计时结束功能

public class NiceTimer{                                       
    
    NiceLabels NL;                                              
    int goalHour;      //目标时间
    int goalMinute;

    
    NiceTimer(int goalHour, int goalMinute, NiceLabels NL) {    
        this.goalHour = (goalHour-8)%24;                         //时间差
        this.goalMinute = goalMinute;
        this.NL = NL;
    }
    
    //计时器主要逻辑
    public void run() {
        int currentSecond;
        int currentMinute;
        int currentHour;

        // 使用do-while循环，至少执行一次，直到达到指定的时间点  
        do{
            long currentTime = System.currentTimeMillis();         

            currentTime = currentTime / 1000;
            currentSecond = (int) (currentTime % 60);            
            currentTime = currentTime / 60;
            currentMinute = (int) (currentTime % 60);              
            currentTime = currentTime / 60;      
            currentHour = (int) (currentTime % 24);             
            
            if (goalMinute-currentMinute > 0)
            System.out.println("Alarm: "+ (goalHour-currentHour) +" : "+
            (goalMinute-currentMinute-1) +" : "+ (59-currentSecond));
            
            try {
                Thread.sleep(1000);                            
            }
            catch (InterruptedException e){
                e.toString();
            }  
        }while (goalHour*100+goalMinute > currentHour*100+currentMinute);
        
        NL.Label_Alarm.setText("Alarm: 时间到! "); 
    }
}