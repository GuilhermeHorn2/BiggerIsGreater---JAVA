package misc;

public class main_misc2 {

	public static void main(String[] args) {
		// 
		String s  = "aacb";
		String r = big_perm(s);
		System.out.println(r);
		//System.out.println(reverse(s));
		
		}
	private static void swap(char[]c,int i,int j) {
		//
		char d = c[i];
		c[i] = c[j];
		c[j] = d;
	}
	/*
	 * I want to find the first element from right to left and save the index as j when i found a c[i] > c[i-1]
	 * the i search from j to v.length the smallest element that is bigger than c[j-1](if j == 0 -->null)
	 * after that i guarantee that the array from i to v.lenght-1 is sorted from max to min
	 * so i just have to invert this part of the array then i have to concatenate both
	 */
	private static String reverse(String s) {
		//
		char[] c = s.toCharArray();
		String r = "";
		for(int i = s.length()-1;i >= 0;i--){
			//
			r += c[i];
		}
		return r;
	}
	private static String big_perm(String s) {
		char[] c = s.toCharArray();
		
		//1st step:find a permutation that is bigger than s and olny cost 1 swap
		int j = 0;
		for(int i = c.length-1;i >= 0;i--) {
			if(i != 0 && c[i] > c[i-1]) {
				//
				//swap(c,i,i-1);
				j = i;
				break;
			}
		}
		if(j == 0) {
			return null;
		}
		//find the smallest element that is bigger than c[j-1]
		if(j != 0) {
			char m = ' ';
			int k = 0;
			for(int i = j;i < c.length;i++) {
				//
				if(i == j) {
					m = c[j];
					k = i;
				}
				else if(c[i] > c[j-1] && m >= c[i]) {
					m = c[i];
					k = i;
				}
			}
			swap(c,k,j-1);
		}
		//2st step:from the swap term to right invert the array
		String a = "";
		String b = "";
		for(int i = 0;i < c.length;i++) {
			if(i >= j) {
				a += c[i];
			}
			if(i < j) {
				b += c[i];
			}
		}
		a = reverse(a);
		//
		return b+a;
		
	}
		
	
	}
	
	
