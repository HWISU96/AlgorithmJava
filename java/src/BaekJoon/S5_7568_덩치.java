import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 덩치 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] people = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int rank = 1; // 기본 등수는 1
            
            for (int j = 0; j < N; j++) {
                
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++; // 덩치 큰 사람 수만큼 등수가 밀려남
                }
            }
            
            sb.append(rank).append(' '); 
        }
        
        System.out.println(sb);
    }
}