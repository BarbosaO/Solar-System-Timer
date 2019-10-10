package calculations.planets;

public class Saturn 
{
	
	double N = 113.66343585; 
	double i =  2.48859984;
	double w = 339.39394465; 
	double a = 9.554750;
	double e = 0.05554599; 
	double M = 317.01716634;

	double N_ = 2.38980E-5;
	double i_ = 1.081E-7;
	double w_ = 2.97661E-5;
	double e_ = 9.499E-9;
	double M_ =  0.0334442282;
	
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
	
	public double getE() 
	{
		return e;
	}
	
	public double getM() 
	{
		return M;
	}
	
	public double getN_() 
	{
		return N_;
	}
	
	public double getI_() 
	{
		return i_;
	}
	
	public double getW_() 
	{
		return w_;
	}

	public double getE_() 
	{
		return e_;
	}
	
	public double getM_() 
	{
		return M_;
	}
	
	public void setSaturnData(double N, double i,double a, double e, double M)
	{
		N = getN() + getN_();
    	i = getI() + getI_();
    	w = getW() + getW_();
    	a = getA();
    	e = getE() + getE_();
    	M = getM() + getM_();
	}
}

