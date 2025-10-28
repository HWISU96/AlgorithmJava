import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int cnt0 = 0;
		int cnt1 = 0;
		
		for(int i=0; i<str.length()-1; i++) {
			if (str.charAt(i) != str.charAt(i+1)) {
				if (str.charAt(i) == '0') {
					cnt0++;
				}
				else {
					cnt1++;
				}
			}
			
		}
		
		if (str.charAt(str.length()-1) == '0') {
			cnt0++;
		}
		else {
			cnt1++;
		}
		
		int ans = Math.min(cnt0, cnt1);
		System.out.println(ans);
		
	} // main
}