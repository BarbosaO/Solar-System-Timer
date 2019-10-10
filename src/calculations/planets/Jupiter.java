package calculations.planets;

public class Jupiter
{	
	
	double N = 100.45424153; 
	double i =  1.30299977;
	double w = 273.87772468; 
	double a = 5.202560;
	double e = 0.04849801; 
	double M = 20.01962795;

	double N_ = 2.76854E-5;
	double i_ = 1.557E-7;
	double w_ = 1.64505E-5;
	double e_ = 4.469E-9;
	double M_ = 0.0830853001;
	
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
	
	public void setJupiterData(double N, double i,double a, double e, double M)
	{
		N = getN() + getN_();
    	i = getI() + getI_();
    	w = getW() + getW_();
    	a = getA();
    	e = getE() + getE_();
    	M = getM() + getM_();
	}
}