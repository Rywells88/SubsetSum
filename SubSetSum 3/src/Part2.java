import java.util.*;
//Ryley Wells, 20068388
public class Part2 {

private static Random rand = new Random();

private static ArrayList<ArrayList<Integer>> S = new ArrayList<ArrayList<Integer>>();

private static int BFISetAvg = 0;

private static int HSSetAvg = 0;

private static int totalBFI = 0;

private static int totalHS = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test();
	}
	
	public static int getTotalBFI()
	{
		return totalBFI;
	}
	public static int getTotalHS()
	{
		return totalHS;
	}
	public static void setTotalBFISum(int Bsum)
	{
		totalBFI = Bsum;
	}
	public static void setTotalHSSum(int Hsum)
	{
		totalHS = Hsum;
	}
	
public static void Test()
{
	int len = 0;
	
	for(int n = 4; n<15;n++)
	{
		ArrayList<Integer> subset = new ArrayList<Integer>(n);
		int m =0;
		while (m < n)
		{
			int s = rand.nextInt(12);// generating random integers for the set
			subset.add(s);
			m++;
		}
		S.add(subset);
		
		
		
		for (int i=0; i<10;i++)
		{
			
			
			ArrayList<Integer> target = new ArrayList<Integer>();
			
			int j = rand.nextInt(20);// generating random integers for the target
			target.add(j);
			
			
			Iterator iter = target.iterator();		// for each target value k
			
			
			
			while (iter.hasNext() && len < S.size())
			{
				int [] convertedList = convertIntegers(S.get(len));
				
				//System.out.println("converted list is " + S.get(len));
				
				int currentK = (int) iter.next();
				
				SubsetSum returnedSubSum = new SubsetSum(convertedList, currentK);
				
				HS_Subset_Sum returnedHSSubSum = new HS_Subset_Sum(convertedList, currentK);
				
				totalBFI += totalBFI + returnedSubSum.getSum();
				System.out.println("This is returnedSubsum " + returnedSubSum.getTheSumArray());
				returnedSubSum.setSum(0);
				BFISetAvg = computeAverage(returnedSubSum.getTheSumArray());
				
				totalHS += totalHS + returnedHSSubSum.getHSSum();	
				System.out.println("This is returnedHSubsum " + returnedHSSubSum.getHSSumArray());
				returnedHSSubSum.setHSSum(0);
				returnedHSSubSum.setSortSum(0);
				returnedHSSubSum.setPSum(0);
				HSSetAvg = computeAverage(returnedHSSubSum.getHSSumArray());
				
				len++;
				
			}
			
			
		}
		System.out.println("BFI average is " + BFISetAvg + "\n" + "HS average is " + HSSetAvg);
		
	}
	

}

public static int computeAverage(ArrayList<Integer> nums)
{
	int count = 0;
	
	for( int i = 0; i<nums.size(); i ++)
	{
		count = count + nums.get(i);
	}
	
	return (count/nums.size());
	
}

public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}
	

}
