package calculations.planets;

public class Mars
{	
	double N =  49.5574; 
	double i = 1.8497;
	double w = 286.5016; 
	double a = 1.523688;
	double e = 0.093405; 
	double M =  18.6021;

	double N_ = 2.11081E-5;
	double i_ = 1.78E-8;
	double w_ = 2.92961E-5;
	double e_ = 2.516E-9;
	double M_ = 0.5240207766;
	
	public double getN() 
	{
		return N;
	}
	
	public double getI() {
		return i;
	}
	public double getW() {
		return w;
	}
	public double getA() {
		return a;
	}
	public double getE() {
		return e;
	}
	public double getM() {
		return M;
	}
	public double getN_() {
		return N_;
	}
	public double getI_() {
		return i_;
	}
	public double getW_() {
		return w_;
	}

	public double getE_() {
		return e_;
	}
	public double getM_() {
		return M_;
	}
	
	public void setMarsData(double N, double i,double a, double e, double M)
	{
		N = getN() + getN_();
    	i = getI() + getI_();
    	w = getW() + getW_();
    	a = getA();
    	e = getE() + getE_();
    	M = getM() + getM_();
	}
}