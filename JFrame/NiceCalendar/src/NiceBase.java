//初始化功能

import java.util.Calendar;

public class NiceBase{
    //private String day[31];                    
    private int year;
    private int month;
    
    NiceBase(){
        year = 2023;
        month = 12;
        /*
            for (int i = 0; i < day.length; i++) {    //这里获取当前日
                day[i] = "";
            }
        */
    
    }
    
    NiceBase(int year, int month){
        setYear(year);
        setMonth(month);
    }
     
    public void setYear(int year){             
        if(year < 2119 && year > 1919)                     
        this.year = year;                                             
    }           
                                                        
    public int getYear(){                                   
        return year;                                                
    }                   
    
    public void setMonth(int month){                   
        if(month < 0)            
        this.month = month + 12;
        else if(month > 12)     
        this.month = month -12;  
        else
        this.month = month;                                    
    } 

    public int getMonth(){                                          
        return month;
    }                                                               

    public String[] getCalendar(){              //calendar画板                    
        String a[] = new String[42];
        Calendar C = Calendar.getInstance();
        C.set(year, month - 1, 1);              //月的基底为0          
        int D = C.get(Calendar.DAY_OF_WEEK)-1;
        
        int day = 0;
        if(month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12)
            day = 31; //1 3 5 7 8 10 12 月份
            
        else if(month == 4||month == 6||month == 9||month == 11)
            day = 30; //4 6 9 11 月份
            
        else if(month == 2){ //2 月份
            if(((year % 4 == 0)&&(year % 100!= 0))||(year % 400 == 0))
                day = 29; 
            else
                day = 28;  
        }
       
        for(int i = D, n = 1; i < D + day; i++){
            a[i] = String.valueOf(n);
            n++;
        }
        
        return a;
    }
}