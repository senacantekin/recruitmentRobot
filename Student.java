class Student {	
	
	private double social;
	private double gpa;
	private double age;
	private double algorithm;
	private double y;
	private int index; // to save the default order of the student
	
	public Student(	double social,	double gpa,	double age,	double algorithm,double y,int index) {
		this.social = social;
		this.gpa = gpa;
		this.age = age;
		this.algorithm = algorithm;
		this.y = y;
		this.index = index;
	}
	
	
    @Override
    public String toString() { 
       
    	return this.social + " "+this.gpa+" "+this.age+" "+this.algorithm+" "+this.y+" "+this.index; 
    } 
    
    
	public double getEuclid(Student student) {
    	double sum = ((this.social-student.social)*(this.social-student.social))+((this.gpa-student.gpa)*(this.gpa-student.gpa))+
    			((this.age-student.age)*(this.age-student.age))+((this.algorithm-student.algorithm)*(this.algorithm-student.algorithm));
		return squareRoot(sum);
		}
	
		public static double squareRoot(double sum) {
			double temp;

			double sr = sum / 2;

			do {
				temp = sr;
				sr = (temp + (sum / temp)) / 2;
			} while ((temp - sr) != 0);

			return sr;
		    }
	
public int getIndex() { return this.index;}
	public double getY() {
		return this.y;
	}
		}
