import java.util.*;
//Ryley Wells, 20068388
public class HS_Subset_Sum extends Sort{

	private static int HSSum = 0;
	private static ArrayList<Integer> HSSumArray = new ArrayList<Integer>();
	
	public HS_Subset_Sum(int p1, int p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}
	
	public HS_Subset_Sum(int [] arr, int K)
	{
		super();
		
		HS_Subset_sum(arr,K);
		HSSumArray.add(getHSSum());
	}
	public int getHSSum()
	{
		return HSSum;
	}
	public void setHSSum()
	{
		HSSum++;
	}
	public void setHSSum(int k)
	{
		HSSum = k;
	}
	public ArrayList<Integer> getHSSumArray()
	{
		return HSSumArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] s = {3,5,3,9,18,4,5,6};
		int k = 14;
		
		
		
		HS_Subset_sum(s, k);
		

	}
	
	static Set empty_Set = new Set();
	
	public static void HS_Subset_sum(int []s, int k)
	{
		int length = s.length;
		
		System.out.println("k value is " + k);
		
		int [] left = Arrays.copyOfRange(s, 0, length/2);
		int [] right = Arrays.copyOfRange(s, length/2, length);
		HSSum++;	
		
		ArrayList<Set> SetsLeft = new ArrayList<Set>();
		ArrayList<Set> SetsRight = new ArrayList<Set>();
		
		SetsLeft = BFI_Subset_Sum(left);		// return subsets and their sums 
		SetsRight = BFI_Subset_Sum(right);
		
		// make left lists
		ArrayList<ArrayList<Integer>> Subsets_Left = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> Sums_Left = new ArrayList<Integer>();
		
		// make Right lists 
		ArrayList<ArrayList<Integer>> Subsets_Right = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> Sums_Right = new ArrayList<Integer>();
		
		// make 2 lists for unSorted sums, this will come in handy later
		ArrayList<Integer> UnsortedRightSum = new ArrayList<Integer>();
		ArrayList<Integer> UnsortedLeftSum = new ArrayList<Integer>();

	// append subsets and sums into their own lists
		for(int i = 0; i<SetsLeft.size(); i++)
		{
			Subsets_Left.add(SetsLeft.get(i).getElements());
			Sums_Left.add(SetsLeft.get(i).getSum());
			UnsortedLeftSum.add(SetsLeft.get(i).getSum());
			HSSum++;
			//System.out.println(Subsets_Left.get(i));
		}
		for(int i =0; i<SetsRight.size(); i++)
		{
			Subsets_Right.add(SetsRight.get(i).getElements());
			Sums_Right.add(SetsRight.get(i).getSum());
			UnsortedRightSum.add(SetsRight.get(i).getSum());
			HSSum++;
			//System.out.println(Sums_Right.get(i));
		}
		
		int j = 0;
		
		while (j < Sums_Right.size() && j < Sums_Left.size())
		{
			if(Sums_Right.get(j) == k && Sums_Right.get(j) != null)
			{
				System.out.println("The corresponding right side set that sums to k is " + Subsets_Right.get(j));
				HSSum++;
			}
			if(Sums_Left.get(j) == k && Sums_Left.get(j) != null)
			{
				System.out.println("The corresponding left side set that sums to k is " + Subsets_Left.get(j));
				HSSum++;
			}
			j++;
		}
		
		
		
		
		
		
		
		
		 mergeSort(Sums_Right);
		 HSSum = 3*(HSSum + getSortSum());
		 HSSum = (int) Math.log(HSSum);
		 //System.out.println("This is sortSum " + getSortSum());
		 mergeSort(Sums_Left);
		 HSSum = 3*(HSSum + getSortSum());
		 HSSum = (int) Math.log(HSSum);
	
		Integer [] arrSRight = convertIntegers(Sums_Right);
		Integer [] arrSLeft = convertIntegers(Sums_Left);
		

		Psum n = Pair_Sum(arrSRight, arrSLeft, k);
		HSSum = HSSum + getPSum();
		
		
		if(n != null)
		{		
			int ind1 = UnsortedRightSum.indexOf(arrSRight[n.getP1()]);
			int ind2 = UnsortedLeftSum.indexOf(arrSLeft[n.getP2()]);
			// Pair sum is returning the 2 elements that sum to k. I need to find those elements in SubSets_Left and SubSets_right and print the set
			HSSum++;
			
			
			System.out.println("This is the corresponding subsetLeft " + Subsets_Left.get(ind2));
			System.out.println("This is the corresponding subsetRight " + Subsets_Right.get(ind1));
			System.out.println();

		}
		else
		{
			System.out.println("No subset sums to the target value");
			System.out.println();
			HSSum++;
		}
		
		

	}
	
	
	
	
	
	public static Integer[] convertIntegers(List<Integer> integers)
	{
	    Integer[] ret = new Integer[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	        HSSum++;
	    }
	    return ret;
	}
	
	
	
	public static ArrayList<Set> BFI_Subset_Sum(int [] S)
	{
		
		ArrayList<Set> subSets = new ArrayList<Set>();
		
		subSets.add(empty_Set);

		
		int l = S.length; // length of 8
		
	
		for (int i = 0; i<l; i++)		// loop to 8
		{
					// empty list of Set objects 
			ArrayList<Set> new_Subset = new ArrayList<Set>();

			Iterator <Set> iter = subSets.iterator();
		HSSum++;

				
				
		while(iter.hasNext ()){
			
			Set new_u = new Set(); 		// new set object 
			
			Set old_u = iter.next();
			//iter.next().appendElements(S[i]);
			
			new_u.setElements(old_u.getElements());
			
			new_u.appendElements(S[i]);
		
			
			new_u.setSum(old_u.getSum() + S[i]);	// get the old subset, and add S[i]
			
		
				new_Subset.add(old_u);
				new_Subset.add(new_u);
		HSSum++;
			
		}
		subSets.clear();
		
		subSets.addAll(new_Subset);
				
		}
		
		//System.out.println("No solution found");
		return subSets;
		
	}

}
