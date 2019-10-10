package launcher;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.util.Locale;

import javax.swing.Timer;

import calculations.Calculations;
import calculations.Calculator;
import calculations.Planet;
import calculations.planets.Mars;
import calculations.planets.Mercury;
import calculations.planets.Venus;
import calculations.planets.Jupiter;
import calculations.planets.Saturn;
import display.Display;

public class Launcher
{
	
	public static void main(String[] args)
	{
		new Launcher();
		
	}
	

	double Nj, ij, wj, aj, ej, Mj, rMIj;
	double Ns, is, ws, as, es, Ms, rMIs;
	
	double rh, rhmi;
	
	public Launcher()
	{
		EventQueue.invokeLater(new Runnable()
		{
			 public void run() 
		     {
				 Timer timer = new Timer(1000, new ActionListener() 
				 {
		                
		                Display display = new Display();
		                @Override
		                public void actionPerformed(ActionEvent e) 
		                {
		                    tickTock();
		                    display.setLabelText(NumberFormat.getNumberInstance(Locale.US).format(rhmi) + "mi");
		                }
		            });
				 
		            timer.setRepeats(true);
		            timer.setCoalesce(true);
		            timer.setInitialDelay(0);
		            timer.start();
		        }

		        public void tickTock() 
		        {
		        			        
		        	double UT = (ZonedDateTime.now().getHour() + (ZonedDateTime.now().getMinute() / 60.0 + (ZonedDateTime.now().getSecond() / 3600.0)));
		        	//System.out.println("UT: " + UT);
		        	

		        	int year = ZonedDateTime.now().getYear();
		        	int month = ZonedDateTime.now().getMonthValue();
		        	int day = ZonedDateTime.now().getDayOfMonth();
		        	
		        	double d =  367*year - (7*(year + ((month+9)/12)))/4 + (275*day)/9 + day - 730530;
		        	//double d =  367*2018 - (7*(2018 + ((11+9)/12)))/4 + (275*11/9) + ZonedDateTime.now().getDayOfMonth() - 730530;
		        	d += UT/24;
		        	
		        	//Mars marsObject = new Mars();
		        
		        	//N = marsObject.getN() + marsObject.getN_() * d;
		        	//i = marsObject.getI() + marsObject.getI_() * d;
		        	//w = marsObject.getW() + marsObject.getW_() * d;
		        	//a = marsObject.getA();
		        	//e = marsObject.getE() + marsObject.getE_() * d;
		        	//M = marsObject.getM() + marsObject.getM_() * d;
		        	
		        	//Calculator marsCalculator = new Calculator(N, i, w, a, e, M);
		        	
		        	//marsCalculator.CalculateData();
		        	//System.out.println(NumberFormat.getNumberInstance(Locale.US).format(marsCalculator.getRMiles()) + " mi");
		        	//rMI = marsCalculator.getRMiles();
		        	
		        	//Mercury mercuryObject = new Mercury();
			        
		        	//N = mercuryObject.getN() + mercuryObject.getN_() * d;
		        	//i = mercuryObject.getI() + mercuryObject.getI_() * d;
		        	//w = mercuryObject.getW() + mercuryObject.getW_() * d;
		        	//a = mercuryObject.getA();
		        	//e = mercuryObject.getE() + mercuryObject.getE_() * d;
		        	//M = mercuryObject.getM() +mercuryObject.getM_() * d;
		        	
		   
		        	//Calculator mercuryCalculator = new Calculator(N, i, w, a, e, M);
		        	
		        	//mercuryCalculator.CalculateData();
		        	
		        	//Venus venusObject = new Venus();
		        	
		        	//N = venusObject.getN() + venusObject.getN_() * d;
		        	//i = venusObject.getI() + venusObject.getI_() * d;
		        	//w = venusObject.getW() + venusObject.getW_() * d;
		        	//a = venusObject.getA();
		        	//e = venusObject.getE() + venusObject.getE_() * d;
		        	//M = venusObject.getM() + venusObject.getM_() * d;
		        	
		        	
		        	//Calculator venusCalculator = new Calculator(N, i, w, a, e, M);
		        	
		        	//venusCalculator.CalculateData();
		        	
		        	
		        	//System.out.println(NumberFormat.getNumberInstance(Locale.US).format(marsCalculator.getRMiles()) + " mi");
		        	
		        	 
		        	//rMI = venusCalculator.getRMiles();
		        	
		        	
		        	Saturn saturnObject = new Saturn();
		        	
		        	Ns = saturnObject.getN() + saturnObject.getN_() * d;
		        	is = saturnObject.getI() + saturnObject.getI_() * d;
		        	ws = saturnObject.getW() + saturnObject.getW_() * d;
		        	as = saturnObject.getA();
		        	es = saturnObject.getE() + saturnObject.getE_() * d;
		        	Ms = saturnObject.getM() + saturnObject.getM_() * d;
		        	
		        	
		        	Calculator saturnCalculator = new Calculator(Ns, is, ws, as, es, Ms);
		        	saturnCalculator.CalculateData();
		        	
		        	//System.out.println(NumberFormat.getNumberInstance(Locale.US).format(marsCalculator.getRMiles()) + " mi");
		        	rMIs = saturnCalculator.getRMiles();
		        	
		       
		        	Jupiter jupiterObject = new Jupiter();
		        	
		        	Nj = jupiterObject.getN() + jupiterObject.getN_() * d;
		        	ij = jupiterObject.getI() + jupiterObject.getI_() * d;
		        	wj = jupiterObject.getW() + jupiterObject.getW_() * d;
		        	aj = jupiterObject.getA();
		        	ej = jupiterObject.getE() + jupiterObject.getE_() * d;
		        	Mj = jupiterObject.getM() + jupiterObject.getM_() * d;
		        	
		        	
		        	Calculator jupiterCalculator = new Calculator(Nj, ij, wj, aj, ej, Mj);
		        	jupiterCalculator.CalculateData();
		        	
		        	//System.out.println(NumberFormat.getNumberInstance(Locale.US).format(marsCalculator.getRMiles()) + " mi");
		        	rMIj = jupiterCalculator.getRHMiles();
		        	double r = jupiterCalculator.getR();
		        	//double rh = jupiterCalculator.getRh();
		        	
		        	System.out.println("r " + r);
		        	
		        	 double j1 = 0.332 * Math.sin(Math.toRadians(2*Mj - 5*Ms - 67.6));
		        	 double j2 = -0.056 * Math.sin(Math.toRadians(2*Mj - 2*Ms + 21));
		        	 double j3 = +0.042 * Math.sin(Math.toRadians(3*Mj - 5*Ms + 21));
		        	 double j4 = -0.036 * Math.sin(Math.toRadians(Mj - 2*Ms));
		        	 double j5 = +0.022 * Math.cos(Math.toRadians(Mj - Ms));
		        	 double j6 = +0.023 * Math.sin(Math.toRadians(2*Mj - 3*Ms + 52));
		        	 double j7 = -0.016 * Math.sin(Math.toRadians(Mj - 5*Ms - 69));
		        	 
		        	 double totalCorrections = j1 + j2 + j3 + j4 + j5 + j6 + j7;
		        	 
		        	 System.out.println("totalCorrections: " + totalCorrections);
		        	 System.out.println("Original Longitude:" + jupiterCalculator.getLogitudeLh());
		        	 
		        	 
		        	 
		        	 double correctedLongitude = jupiterCalculator.getLogitudeLh() + totalCorrections;
		        	 
		        	 System.out.println("Corrected Longitude: " + correctedLongitude);
		        	 
		        	 double xh = r * Math.cos(Math.toRadians(correctedLongitude)) * Math.cos(Math.toRadians(jupiterCalculator.getLatitudeBh()));
		        	 double yh = r * Math.sin(Math.toRadians(correctedLongitude)) * Math.cos(Math.toRadians(jupiterCalculator.getLatitudeBh()));
		        	 double zh = r * Math.sin(Math.toRadians(jupiterCalculator.getLatitudeBh()));
		        	 
		        	 rh = Math.sqrt(xh * xh + yh * yh + zh * zh);
		        	 rhmi = Math.round(rh *  92955807.26743);
		        	 
		        	 System.out.println("rh " + rh);
	        	
		        }
		});
	}		        

}
