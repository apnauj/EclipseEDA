
public class ejemploArrayCopy {
	
	public static void main (String[] Args) {
		int[] c = {1,2,3,4};
		int[] d = {0,0,0,0,0,0};
		System.arraycopy(c, 0, d, 3, 3);
		for(int i = 0; i<d.length; i++) {
			System.out.println(d[i]);
		}
	}
}
