package company.twillio.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Skills_Twillio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String skills = "pcmbzpcmbz";
//		System.out.println(pteam(skills));
		List<Integer> red = new ArrayList<>();
		List<Integer> blue = new ArrayList<>();
		red.add(2);
		red.add(3);
		red.add(4);
		blue.add(3);
		blue.add(1);
		blue.add(1);
		System.out.println(minCost(red, blue, 2));

	}
	public static int pteam(String skills) {
		int p=0,c=0,m=0,b=0,z=0;
		for(int i=0;i<skills.length();i++) {
			char temp = skills.charAt(i);
			if(temp == 'p')
				p++;
			else if(temp =='c')
				c++;
			else if(temp =='m')
				m++;
			else if(temp =='b')
				b++;
			else if(temp =='z')
				z++;
		}
		
		int min1 = Math.min(p, c);
		int min2 = Math.min(m, b);
		int min = Math.min(Math.min(min2, min1),z);
		return min;
	}
	public static List<Long> minCost(List<Integer> red,List<Integer> blue, int blueCost){
		List<Long> res = new ArrayList<>();
		for(int i=0;i<blue.size();i++) {
			res.add(Long.MAX_VALUE);
		}
		res.set(0, 0L);
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.dis-b.dis);
		boolean vis[] = new boolean[red.size()];
		vis[0]=true;
		pq.add(new Pair(1,red.get(0),'r'));
		pq.add(new Pair(1,blue.get(0)+blueCost,'b'));
		while(!pq.isEmpty()) {
			Pair front = pq.remove();
			if(front.index>blue.size()-1)
				break;
			if(vis[front.index])
				continue;
			res.set(front.index, front.dis*1L);
			if(front.type=='b') {
				pq.add(new Pair(front.index+1,front.dis+blue.get(front.index),'b'));
				pq.add(new Pair(front.index+1,front.dis+red.get(front.index),'r'));
			}
			else {
				pq.add(new Pair(front.index+1,front.dis+red.get(front.index),'r'));
				pq.add(new Pair(front.index+1,front.dis+blue.get(front.index)+blueCost,'b'));
			}
			vis[front.index] = true;
		}
		
		return res;
	}
}

class Pair {
	Integer index,dis;
	char type;
	Pair(Integer index, Integer dis, char type){
		this.index = index;
		this.dis =dis;
		this.type = type;
	}
}