import java.util.ArrayList;
import java.util.Collections;
import java.util. *;
//Ryley Wells, 20068388

public class SubsetSum extends Set {

	private static int theSum = 0;
	
	private static ArrayList<Integer> theSums = new ArrayList<Integer>();
	public SubsetSum(int [] arr, int K) {
		// TODO Auto-generated constructor stub
		BFI_Subset_Sum(arr, K);
		theSums.add(getTheSum());
	}

	static Set empty_Set = new Set();
	
	public int getTheSum()
	{
		return theSum;
	}
	public ArrayList<Integer> getTheSumArray()
	{
		return theSums;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		int [] s = {3,5,3,9,18,4,5,6};
		int k = 28;
		
//		int [] s = {10,20,30,2};
//		int k = 40;
		
		int size = s.length;
		
		BFI_Subset_Sum(s, k);
	

	}
	
	public static void BFI_Subset_Sum(int [] S, int k)
	{
		
		ArrayList<Set> subSets = new ArrayList<Set>();
		
		subSets.add(empty_Set); 
		theSum++;		//moving data

		
		int l = S.length; // length of 8
		
	
		for (int i = 0; i<l; i++)		// loop to 8
		{
					
			ArrayList<Set> new_Subset = new ArrayList<Set>();	// empty list of Set objects 

			Iterator <Set> iter = subSets.iterator();
			
			theSum++;	//accessing data
			theSum++; 	// moving data
				
				
		while(iter.hasNext ()){
			
			Set new_u = new Set(); 		// new set object 
			
			Set old_u = iter.next();
			//iter.next().appendElements(S[i]);
			
			new_u.setElements(old_u.getElements());
			theSum++;
			new_u.appendElements(S[i]);
		
			theSum++;
			new_u.setSum(old_u.getSum() + S[i]);	// get the old subset, and add S[i]
			
			if (new_u.getSum() == k)
			{
				System.out.println("The solution is " + new_u.getElements());
				System.out.println("\n");
				theSum++;
				return;
			}
			else 
			{
				new_Subset.add(old_u);
				new_Subset.add(new_u);
				theSum++;
			}
			
		}
		subSets.clear();
		
		subSets.addAll(new_Subset);
		theSum++; // moving data
			

			
			
		}
		
		System.out.println("No solution found");
		System.out.println("\n");
		
	}

}
