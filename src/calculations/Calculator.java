package calculations;

import java.time.ZonedDateTime;

public class Calculator 
{
	double N, i , w, a, e, M;
	static double UT, d, E_0, E_1, E;
	double x, xh, y, yh, zh, v, r, rh, rMI, rhMI, longitudeLh, latitudeBh;
	
	public Calculator(double N_, double i_, double w_, double a_, double e_, double M_)
	{
		N = N_;
		i = i_;
		w = w_;
		a = a_;
		e = e_;
		M = M_;
	}
	
	public void CalculateData()
	{
	
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
		
		
		System.out.println("w: " + w );
		System.out.println("M: " + M );
	
		// Get initial eccentricity
		E_0 = M + e * Math.sin(Math.toRadians(M)) * (1.0 + e * Math.cos(Math.toRadians(M)));
		// Get post eccentricity to solve for Kepler's Law
		
			while(true)
   			{
   					
   				E_1 = E_0 - (E_0 - e * Math.sin(E_0) - M) / (1 - e * Math.cos(E_0));
   				   				
   				E = Math.abs(E_1 - E_0);
   				E_0 = E_1;
   			
   				if(E <=	0.001)
   				{
   					break;
   				}		
   			}
			
			//System.out.println("E_0: " + E_0);
			//System.out.println("E_1: " + E_1);

		x = a * (Math.cos(Math.toRadians(E_1)) - e);
		y = a * Math.sqrt(1.0 - e*e) * Math.sin(Math.toRadians(E_1));
		v = Math.toDegrees(Math.atan2(y, x)); //* (180/Math.PI);
		if(v < 0.0)
		{
			v += 360.0;
		}
		
		r = Math.sqrt(x * x + y * y);
		
		rMI = Math.round(r *  92955807.26743);
		
		// Heliocentric Ecliptic Rectangular Coordinates
		xh = r * (Math.cos(Math.toRadians(N)) * Math.cos(Math.toRadians(v+w)) - Math.sin(Math.toRadians(N)) * 
				Math.sin(Math.toRadians(v+w)) * Math.cos(Math.toRadians(i)));
				
	    yh = r * (Math.sin(Math.toRadians(N)) * Math.cos(Math.toRadians(v+w)) + Math.cos(Math.toRadians(N)) * 
				Math.sin(Math.toRadians(v+w)) * Math.cos(Math.toRadians(i)));
				
	    zh = r * (Math.sin(Math.toRadians(v+w)) * Math.sin(Math.toRadians(i)));
		
	    rh = Math.sqrt(xh * xh + yh * yh + zh * zh);
	    
	    rhMI = Math.round(rh *  92955807.26743);
	    
	    longitudeLh = Math.toDegrees(Math.atan2(yh, xh));
	    if(longitudeLh < 0.0)
		{
			longitudeLh += 360.0;
		}
	    
	    
	    latitudeBh = Math.toDegrees(Math.atan2(zh, Math.sqrt(xh*xh+yh*yh)));
	    if(latitudeBh < 0.0)
		{
			latitudeBh += 360.0;
		}
	    
	}
	
	public double getR()
	{
		return r;
	}
	
	public double getRMiles()
	{
		return rMI;
	}
	
	public double getRHMiles()
	{
		return rhMI;
	}
	
	public double getE_0()
	{
		return E_0;
	}

	public double getN() 
	{
		return N;
	}

	public double getI() 
	{
		return i;
	}

	public double getW() 
	{
		return w;
	}

	public double getA() 
	{
		return a;
	}

	public double getM() 
	{
		return M;
	}

	public static double getUT() 
	{
		return UT;
	}

	public static double getD() 
	{
		return d;
	}

	public static double getE_1() 
	{
		return E_1;
	}

	public static double getE() 
	{
		return E;
	}

	public double getX() 
	{
		return x;
	}

	public double getXh() 
	{
		return xh;
	}

	public double getY() 
	{
		return y;
	}

	public double getYh() 
	{
		return yh;
	}

	public double getZh() 
	{
		return zh;
	}

	public double getV() 
	{
		return v;
	}

	public double getRh() 
	{
		return rh;
	}

	public double getrMI() 
	{
		
		return rMI;
	}
	
	public double getrhMI() 
	{
		return rhMI;
	}

	public double getLogitudeLh() 
	{
		return longitudeLh;
	}

	public double getLatitudeBh() {
		return latitudeBh;
	}
	
	
	
}
