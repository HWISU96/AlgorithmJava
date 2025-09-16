import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2231_분해합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int i = 0;
 		int ans = 0;
		
 		while (i <= num) {
			int sum = 0; 
			String len = Integer.toString(i);
			sum += i;
			for (int j=0; j<len.length(); j++) {
				sum += len.charAt(j)-'0';
			}
			if (sum == num) {
				ans = i;
				break;
			}
			i++;
		} // while
		System.out.println(ans);
	}

}