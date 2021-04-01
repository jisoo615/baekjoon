package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//해결은 했지만 런타임 에러
public class p2108_2 {

	public static void main(String[] args) {
		try(	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
			int n = Integer.parseInt(br.readLine());
			int[] cnt = new int[8001]; //-4000~4000까지: 인덱스 0~3999은 음수, 4000은 0, 4001~8000은 양수
			int sum = 0; int first=0, last=0; int center=0;
			for(int i=0; i<n; i++) {
				int number = Integer.parseInt(br.readLine());
				cnt[number+4000] +=1;
				sum += number;
			}
			int total=0;int index=0;
			boolean flag =false; int mode=0; int mode_max=0;
			/*flag는 빈도수가 같은게 나왔는지 체크하는거. mode는 최빈값, mode_max는 빈도수*/
			for(int i=0; i<=8000; i++) {
				if(cnt[i]>0) {
					if(cnt[i]>mode_max) {//가장 많이나온 횟수가 같으면 2번쨰로 작은 값(=즉 오름차순에서 두번째)을 최빈값으로 정한다.
						mode_max = cnt[i];
						mode = i-4000;
						flag = true;
					}else if(flag==true && mode_max==cnt[i]){//위 주석 때문에 같은 횟수가 두번째 이후에 나오는건 필요없기에 
						mode_max = cnt[i];
						mode = i-4000;
						flag = false;						//flag를 false로 해주고 더 큰 수를 찾게 한다.
					}
					
					if(index==0) first=i-4000;
					else if(index>0) last=i-4000;
					if(total<(n+1)/2 ) { //중간값을 구하는 법:total이 (n+1)/2번쨰 수가 될때까지 돌리면 그때i-4000가 중간값이 됨.
						center = i-4000;				//왜냐,cnt에 1222가 있었으면 
					}total += cnt[i];//total에 수가 나중에 더해지니까 같거나 작은이 아닌 작을때 를 하면 작거나 같은이 되는 거랑 같음..
					index++;
					if(total>n) break;
				}
			}
			
			bw.write(String.valueOf(Math.round(sum/n))+"\n"//평균
					+String.valueOf(mode)+"\n"//최빈값
					+String.valueOf(center)+"\n"//중간값
					+String.valueOf(last-first)+"\n"//최댓값과 최솟값의 차이
					);
			bw.flush();
	}catch(Exception e) {e.printStackTrace();}
	}
}
