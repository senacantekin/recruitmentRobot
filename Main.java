import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
	
	public static void main(String args[]) {
		
		
		 String csvFile = "data.csv";// placed the data.csv above 'src' folder
		 BufferedReader br = null;
		 int rowCount = 0;
		 String line = "";
		 String [] lineValues = new String[5]; // array for values in each row
		 Student [] inputArray = null; // student array 
	    
		 
		 try {	    	
	    	br = new BufferedReader(new FileReader(csvFile));
	    	
	    	// get the total number of rows.
			while ((line = br.readLine()) != null) { rowCount++;}			
			
			inputArray = new Student[rowCount-1];
			rowCount = 0;			
	    	br = new BufferedReader(new FileReader(csvFile));
	    	
			while ((line = br.readLine()) != null) {
				if(rowCount>0) {
					lineValues = line.split(",");
					
					inputArray[rowCount-1] = new Student(Double.parseDouble(lineValues[0]),
														Double.parseDouble(lineValues[1]),
														Double.parseDouble(lineValues[2]),
														Double.parseDouble(lineValues[3]),
														Double.parseDouble(lineValues[4]),
														rowCount-1); // default order of the current student in the array.
					}
				rowCount++;
			}
		}	
	    catch (Exception e) {
		}	
		
		 
        

		 	// read input from the user
	        // enter the values with comma(,)
			Scanner sc = new Scanner(System.in);
	        
	        double[] x= new double[4];
	        int K = 0;
	        System.out.print("Enter social: ");
	        x[0]=sc.nextDouble();
	        System.out.print("Enter algorithm: ");
	        x[1]=sc.nextDouble();
	        System.out.print("Enter gpa: ");
	        x[2]=sc.nextDouble();
	        System.out.print("Enter age: ");
	        x[3]=sc.nextDouble();
	        
	        
	        System.out.print("Enter K for NN: ");
	        K=sc.nextInt();

		 
	        System.out.println("");
	    
	    // create new student for comparison
	        Student inputStudent = new Student(x[0],x[1],x[2],x[3],-1,-1);
        QuickSortStudent ob = new QuickSortStudent(); 
        Student []sortedStudents = ob.sortStudents(inputArray,inputStudent); 
        // count the number of sums for each 0 and 1 for predicting
        int [] totalSum = new int[2];
        for(int i = 0;i<K;++i) {
        	if(sortedStudents[i].getY() > 0 )        		
        		totalSum[1]+=1; 
        	 else
        		 totalSum[0]+=1;
        }
             
        
                
        System.out.println("Predicted Nearest number of samples \nwith output 0: " +totalSum[0]+ "\nwith output 1:  "+totalSum[1]); 

        System.out.println("");
        
        if(totalSum[0]>totalSum[1])
        	System.out.println("Not hired");
        else if(totalSum[1]>totalSum[0])
        	System.out.println("Hired");
        else
        	System.out.println(" equal number of 0 and 1 are predicted for the new candidate");
        
        System.out.println("");
        System.out.println("Shortest Distances for the Input: ");

        
        for (int i=0; i<K; ++i) {        	
        	double num=sortedStudents[i].getEuclid(inputStudent);
        	System.out.printf("%.3f" + " ", num);
        	
       }
       System.out.println();
        

        
	}


}
