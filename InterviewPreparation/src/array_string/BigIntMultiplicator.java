package array_string;

public class BigIntMultiplicator {
	
	public static void main (String[] args) {
		multiply("14215","3479");
	}
	
	public static String multiply (String a, String b) {
		
		String previous = "";
		int shift = -1;
		
		for (int i=a.length(); i>0; i--) {
			
			// Multiplication
			int rest = 0;
			String current = "";
			
			for (int j=b.length(); j>0; j--) {
				int m = Integer.parseInt(a.substring(i-1,i));
				int n = Integer.parseInt(b.substring(j-1,j));
				int mult = m * n + rest;
				if (mult>9) {
					String mult_s = mult + "";
					rest = Integer.parseInt(mult_s.substring(0,1));
					mult = Integer.parseInt(mult_s.substring(1,2));
				} else {
					rest = 0;
				}
				current = mult + current;				
			}
			if (rest > 0) {
				current = rest + current;
				rest = 0;
			}
			System.out.println(current);
			shift++;
			System.out.println(shift);
			
			// Summation
			int rest2 = 0;
			if (previous=="") {
				previous = current;
			} else {
				String interm = "";
				for (int x=1; x<=shift && x<previous.length(); x++) {
					interm = previous.substring(previous.length()-x,previous.length()-x+1) + interm;
				}
				int k=previous.length()-shift;
				int l=current.length();
				while (k>0 || l>0) {
					int m2 = (k>0) ? Integer.parseInt(previous.substring(k-1,k)) : 0;					 
					int n2 = (l>0) ? Integer.parseInt(current.substring(l-1,l)) : 0;
					int sum = m2 + n2 + rest2;					
					if (sum>9) {
						String sum_s = sum + "";
						rest2 = Integer.parseInt(sum_s.substring(0,1));
						sum = Integer.parseInt(sum_s.substring(1,2));
					} else {
						rest2 = 0;
					}
					interm = sum + interm;
					k--;
					l--;
				}
				previous = interm;			
			}
			System.out.println(previous + "\n");
		}
		
		return previous;		
	}
}
