package calculations;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

import javax.swing.Timer;

import display.Display;
import launcher.Launcher;

public class Calculations
{
	
	
	double rKm = 0;
	public Calculations()
	{
		
		EventQueue.invokeLater(new Runnable()
		{
			 public void run() 
		     {
				 Timer timer = new Timer(500, new ActionListener() 
				 {
					 	Display display = new Display();
		                @Override
		                public void actionPerformed(ActionEvent e) 
		                {
		                    tickTock();
		                    display.setLabelText(NumberFormat.getNumberInstance(Locale.US).format(rKm) + " mi");
		                              
		                }
		           });
				 
		            timer.setRepeats(true);
		            timer.setCoalesce(true);
		            timer.setInitialDelay(0);
		            timer.start();
		        }

		        public void tickTock() 
		        {
		        	double UT = (ZonedDateTime.now().getHour() + (ZonedDateTime.now().getMinute() / 60.0 + (ZonedDateTime.now().getSecond()/3600.0)));
		        	System.out.println("UT: " + UT);
		        	
		        	//  d = 367*Y - (7*(Y + ((M+9)/12)))/4 + (275*M)/9 + D - 730530
		        	double d =  367*2018 - (7*(2018 + ((11+9)/12)))/4 + (275*11/9) + ZonedDateTime.now().getDayOfMonth() - 730530;
		        	d = d + UT/24;
		        	
		   		 	System.out.println("d: " + d);
		   			
		   			
		   			//double N = 125.1228 - 0.0529538083  * d ;   //(Long asc. node)
		   		    //double i =   5.1454;                        //(Inclination)
		   		    //double w = 318.0634 + 0.1643573223  * d;    //(Arg. of perigee)
		   		   // double a =  60.2666;                            
		   			//double e = 0.054900;
		   			//double M = 115.3654 + 13.0649929509 *d;
		   			
		   			 //double N =  49.5574 + 2.11081E-5 * d;
		   			 //double i = 1.8497 - 1.78E-8 * d;
		   			 //double w = 286.5016 + 2.92961E-5 * d;
		   			 //double a = 1.523688;
		   			 //double e = 0.093405 + 2.516E-9 * d;
		   			 //double M =  18.6021 + 0.5240207766 * d;
		   			 
		   			 
		   			 double	N = 100.4542 + 2.76854E-5 * d;
		   			 double   i = 1.3030 - 1.557E-7 * d;
		   			 double    w = 273.8777 + 1.64505E-5 * d;
		   			 double    a = 5.20256;
		   			 double    e = 0.048498 + 4.469E-9 * d;
		   			 double  M =  19.8950 + 0.0830853001 * d;
		   			 
		   			 N = 113.6634 + 2.38980E-5 * d;
		   				    i = 2.4886 - 1.081E-7 * d;
		   				    w = 339.3939 + 2.97661E-5 * d;
		   				    a = 9.55475;
		   				    e = 0.055546 - 9.499E-9 * d;
		   				    M = 316.9670 + 0.0334442282 * d;
		   				    
		   				   N =  74.00052097 + 1.39780E-5 * d;
		   					    i = 0.77330003 + 1.9E-8 * d;
		   					    w =  96.66124585 + 3.0565E-5 * d;
		   					    a = 19.18170998 - 1.55E-8 * d;
		   					    e = 0.04731801 + 7.45E-9 * d;
		   					    M = 142.60808871 + 0.011725806 * d;
		   					    
		   					 N =  76.6799 + 2.46590E-5 * d;
		   						    i = 3.3946 + 2.75E-8 * d;
		   						    w =  54.8910 + 1.38374E-5 * d;
		   						    a = 0.723330;
		   						    e = 0.006773 - 1.302E-9 * d;
		   						    M =  48.0052 + 1.6021302244 * d;
		   						    
		   					    
		   	
		   			 
		   		// double N =  48.3313 + 3.24587E-5 * d;
		   		 //double	i = 7.0047 + 5.00E-8 * d;
		   		 //double	w =  29.1241 + 1.01444E-5 * d;
		   		 //double	a = 0.387098;
		   		 //double	e = 0.205635 + 5.59E-10 * d;
		   		 //double	M = 168.6562 + 4.0923344368 * d;
		   			
		   					    
		   			 System.out.println("e: " + e);

		   			//while(true)
		   			///{
		   			////	if(w < 0 && M < 0)
		   				//{
		   			//		w += 360;
		   			///		M += 360;
		   			////	}
		   			//	/	w -= 360;
		   				//	M -= 360;
		   				
		   				//if(w >= 0 && w <= 360)
		   			///{//
		   				//	break;
		   				//}
		   				
		   			//}
		   			
		   			
		   			//System.out.println("Mean anomaly: " + M);
		   			
		   			
		   			//w -= 360;
		   			//int n = (int)(M / 360);
		   			//System.out.println(n);
		   			//M -= 360 * n;
		   			 

		   			// verify that w and M are between 0 - 360
		   			if(w < 0 || w  > 360)
		   			{
		   				int n = (int)(w / 360);
		   				if(w < 0)
		   				{
		   		   			w += 360 * n;
		   				}
		   				else
		   					w -= 360 * n;			
		   			}
		   			
		   			if(M < 0 || M > 360)
		   			{
		   				int k = (int)(M / 360);
		   				if(M < 0)
		   				{
		   		   			M += 360 * k;
		   				}
		   				else
		   					M -= 360 * k;
		   			}

		   			
		   			//System.out.println("N: " + N);
		   			//System.out.println("i: " + i);
		   			System.out.println("w " + w);
		   			//System.out.println("a: " + a);
		   			//System.out.println("e: " + e);
		   			System.out.println("M: "+ M);
		   			
		   			
		   			double E_0, E_1 = 0;
		   			double E = 0;
		   			
		   			E_0 = M + e  * Math.sin(Math.toRadians(M)) * (1.0 + e * Math.cos(Math.toRadians(M)));
		   			System.out.println("First E_0: "+ E_0);
		   			//System.out.println("First E_0 in Degrees " + Math.toDegrees(E_0));
		   			//if(e >= 0.05)
		   			//{
			   			while(true)
			   			{
			   					
			   				E_1 = E_0 - (E_0 - e * Math.sin(E_0) - M) / (1 - e * Math.cos(E_0));
			   				
			   				
			   				E = Math.abs(E_1 - E_0);
			   				E_0 = E_1;
			   				//System.out.println("=====INSIDE LOOP====");
			   				//System.out.println("E_0: " + E_0);
			   				//System.out.prinaln("E_1: " + E_1);
			   				//System.out.println("E: " + E);
			   				//System.out.println("====================");
			   				
			   				
			   				if(E <=	0.001)
			   				{
			   					break;
			   				}
		   						
			   			}
		   			//}
		   			
		   			
		   			System.out.println("E_0: " + E_0);
		   		    System.out.println("E_1: " + E_1);
		   		    System.out.println("E: " + E);
		   		   
		   			
		   			// x, y, and z
		   			double x = a * (Math.cos(Math.toRadians(E_1)) - e);
		   			double y = a * Math.sqrt(1.0 - e*e) * Math.sin(Math.toRadians(E_1));
		   			double v = Math.toDegrees(Math.atan2(y, x)); //* (180/Math.PI);
		   			if(v < 0.0)
		   			{
		   				v += 360.0;
		   			}
		   			
		   			//System.out.println("x: " + x);
		   			//System.out.println("y: "+ y);
		   			//System.out.println("v: " + v);
		   					
		   			// r
		   			double r = Math.sqrt(x*x + y*y);
		   			
		   			//System.out.println("r: " + r);
		   			
		   			//System.out.println("xv: " + r * Math.cos(Math.toRadians(v)));
		   			//System.out.println("yv: "+ y);
		   			//System.out.println("v: " + v);
		   			
		   			rKm = Math.round(r *  92955807.26743);
		 
		   			//System.out.println( "Distance: " + r + " AU");
		   			
		   			System.out.println((rKm) + "mi");
		   			System.out.println();
	
		        }  		 
		});
	}
}
