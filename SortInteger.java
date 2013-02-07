import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


public class SortInteger {


	public static void main(String[] args) {
		ArrayList<Integer> arrayOfIntegers=new ArrayList<Integer>();
		arrayOfIntegers.add(new Integer(1));
		arrayOfIntegers.add(new Integer(1));
		arrayOfIntegers.add(new Integer(3));
		arrayOfIntegers.add(new Integer(2));
		arrayOfIntegers.add(new Integer(3));
		arrayOfIntegers.add(new Integer(10));
		arrayOfIntegers.add(new Integer(1));
		arrayOfIntegers.add(new Integer(6));
		sortAndPrint(arrayOfIntegers);
	}

	public static void sortAndPrint(ArrayList<Integer> integers){
		HashMap<Integer,Times> map=new HashMap<Integer,Times>();

		for(Integer i:integers){
			if(map.containsKey(i)){
				map.get(i).times++;
			}
			else{
				map.put(i, new Times(1));
			}
		}

		TreeSet<Pair> pairs= new TreeSet<Pair>();
		for(Integer i:map.keySet()){
			pairs.add(new Pair(i,map.get(i)));
		}
		System.out.println("Integer:Times");

		for(Pair p:pairs){
			System.out.println(p.i+":"+p.t.times);
		}

	}	
}

class Times{
	int times;
	public Times(int t){
		times=t;
	}
}

class Pair implements Comparable<Pair>{
	Integer i;
	Times t;
	public Pair(Integer i,Times t){
		this.i=i;
		this.t=t;
	}
	@Override
	public int compareTo(Pair p) {
		if (this.t.times==p.t.times){
			if (i>p.i) return -1;
			else if (i==p.i) return 0;
			else return 1;
		}else{
			if(t.times>p.t.times)
				return -1;
			else
				return 1;
		}
	}

}