import java.util.Arrays;
//Ryley Wells, 20068388
public class PairSum extends Psum{

	private static int PSum = 0;
	
	public PairSum(int p1, int p2) {
		super(p1, p2, p2, p2);
		// TODO Auto-generated constructor stub
	}

	public PairSum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int getPSum()
	{
		return PSum;
	}
	public void setPSum(int s)
	{
		PSum = s;
	}
	
	public static Psum Pair_Sum(Integer [] Values_1, Integer [] Values_2, int k)
	{
		Psum tmp = new Psum(1,Values_2.length-1, 0, 0);
		if(k<Values_1[Values_1.length-1] || k < Values_2[Values_2.length-1])
		{
		while(tmp.getP1() <= Values_1.length && tmp.getP2() >=1)
		{
			int t = Values_1[tmp.getP1()] + Values_2[tmp.getP2()];
			PSum++;
			if(t == k)
			{
				return(tmp);
			}
			else if (t<k)
			{
				PSum++;
				tmp.setP1(tmp.getP1()+1);
				tmp.setIndex1(Arrays.asList(Values_1).indexOf(tmp.getP1()));
			}
			else
			{
				PSum++;
				tmp.setP2(tmp.getP2() -1);
				tmp.setIndex2(Arrays.asList(Values_2).indexOf(tmp.getP2()));
			}
			}
		}
		return null;
	}

}
