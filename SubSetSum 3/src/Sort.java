import java.util.*;
// MergeSort Algorithm taken from https://repl.it/@StephanieStern/Merge-Sort-with-ArrayList, with some modifications made
public class Sort extends PairSum {
	//Ryley Wells, 20068388
private static int sortSum = 0;

	public Sort(int p1, int p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}


	public Sort() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getSortSum()
	{
		return sortSum;
	}
	public void setSortSum(int k)
	{
		sortSum = k;
	}
	

public static ArrayList<Integer> mergeSort(ArrayList<Integer>numbers){
  return doMergeSort(numbers);
}

static ArrayList<Integer> merged = new ArrayList<Integer>();

private static ArrayList<Integer> doMergeSort(ArrayList<Integer> numbers){
  int middle;
  ArrayList<Integer> left = new ArrayList<>();
  ArrayList<Integer> right = new ArrayList<>();
  
  if (numbers.size() > 1) {
     middle = numbers.size() / 2;
        // copy the left half of numbers into left.
        for (int i = 0; i < middle; i++) 
            left.add(numbers.get(i));
        	sortSum++;
        //copy the right half of numbers into right.
        for (int j = middle; j < numbers.size(); j++)
            right.add(numbers.get(j));
            sortSum++;
     doMergeSort(left);
     doMergeSort(right);
 
   
    
    merged = merge(numbers, left, right);
  }
  return merged;
}
private static ArrayList<Integer> merge(ArrayList<Integer> numbers, ArrayList<Integer> left, ArrayList<Integer> right){
  //set up a temporary arraylist to build the merge list
  ArrayList<Integer> temp = new ArrayList<>(); 
  
  //set up index values for merging the two lists 
  int numbersIndex = 0;    
  int leftIndex = 0;
  int rightIndex = 0;

  while (leftIndex < left.size() && rightIndex < right.size()) {
    if (left.get(leftIndex) < right.get(rightIndex) ) {
            numbers.set(numbersIndex, left.get(leftIndex));
            leftIndex++;
            sortSum++;
        } else {
            numbers.set(numbersIndex, right.get(rightIndex));
            rightIndex++;
        }
        numbersIndex++;
    }
   
    int tempIndex = 0;
    if (leftIndex >= left.size()) {
        temp = right;
        tempIndex = rightIndex;
        sortSum++;
    } 
    else {
        temp = left;
        tempIndex = leftIndex;
    }
 
    for (int i = tempIndex; i < temp.size(); i++) {
        numbers.set(numbersIndex, temp.get(i));
        numbersIndex++;
        sortSum++;
    }
    return numbers;
 }
}
