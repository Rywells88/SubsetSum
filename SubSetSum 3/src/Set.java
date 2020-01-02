import java.util.ArrayList;
//Ryley Wells, 20068388
public class Set {
	
	private ArrayList<Integer> elements = new ArrayList<Integer>();		//list of elements in the set
	private int sum;				// sum of all the elements in the set
	
	
	public Set () {
		sum = 0;
	}
	public Set(int i)
	{
		elements.add(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getSum() {
		return sum;
	}
	
	public ArrayList<Integer> getElements()
	{
		return elements;
	}
	
	public void setElements(ArrayList<Integer> k)
	{
		elements.addAll(k);
	}
	public void setSum(int s)
	{
		sum = s;
	}

	public void appendElements(int i) {
		
		elements.add(i);
	}
	
	

}
