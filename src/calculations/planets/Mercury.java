package calculations.planets;

public class Mercury 
{
	double N =  48.3313;
	double i = 7.0047;
	double w =  29.1241;
	double a = 0.387098;
	double e = 0.205635;
	double M = 168.6562;

	double N_ = 3.24587E-5;
	double i_ = 5.00E-8;
	double w_ = 1.01444E-5;
	double e_ =  5.59E-10;
	double M_ = 4.0923344368;
	
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
	
	public void setMercuryData(double N, double i,double a, double e, double M)
	{
		N = getN() + getN_();
    	i = getI() + getI_();
    	w = getW() + getW_();
    	a = getA();
    	e = getE() + getE_();
    	M = getM() + getM_();
	}
}

