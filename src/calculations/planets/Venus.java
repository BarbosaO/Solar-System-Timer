package calculations.planets;

public class Venus
{	
	
	double N = 76.67993699; 
	double i = 3.39460004;
	double w = 54.89102076; 
	double a = 0.723330;
	double e = 0.006773; 
	double M = 50.40839534;

	double N_ = 2.46590E-5;
	double i_ = 2.75E-8;
	double w_ = 1.38374E-5;
	double e_ = 1.302E-9;
	double M_ = 1.6021302244;
	
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
	
	public void setVenusData(double N, double i,double a, double e, double M)
	{
		N = getN() + getN_();
    	i = getI() + getI_();
    	w = getW() + getW_();
    	a = getA();
    	e = getE() + getE_();
    	M = getM() + getM_();
	}
}