import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class 나이순정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Member[] members = new Member[N]; // Member 객체를 담을 배열 생성
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[i] = new Member(age, name); // 입력받은 정보로 Member 객체 생성 후 배열에 저장
		}
		
		Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                // 나이를 기준으로 오름차순 정렬
                return m1.age - m2.age;
            }
        });
		
		StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(' ').append(member.name).append('\n');
        }
        System.out.println(sb);
		
	} // main
}
