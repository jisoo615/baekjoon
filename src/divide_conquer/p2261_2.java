package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2261_2 {
	
	private static Point[] p;
//-----------------------------------------
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	//점사이 거리 구하기
	private static int dist(Point o1, Point o2) {
		return (o1.x-o2.x)*(o1.x-o2.x) + (o1.y-o2.y)*(o1.y-o2.y);
	}
	//x좌표 오름차순 익명객체
	private static Comparator<Point> Xcomp = new Comparator<Point>(){
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x-o2.x;
		}
	};
	//y좌표 오름차순 익명객체
	private static Comparator<Point> Ycomp = new Comparator<Point>(){
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y-o2.y;
		}
	};
//point클래스 끝-----------------------------------------------------------------------------------
//main시작
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
 
		int N = Integer.parseInt(br.readLine());
 
		p = new Point[N];
 
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
 
		Arrays.sort(p, Xcomp);
 
		System.out.println(closest(0, N - 1));
		br.close();

	}
	
//브루트포스 방식 ----------2개 3개 남았을 경우에. 최소거리 반환
	private static int brute(int start, int end) {
		int minDist = Integer.MAX_VALUE;
		
		for(int i=start; i<end; i++) {
			Point x0 = p[i];
			for(int j=i+1; j<=end; j++) {
				minDist = Math.min(minDist, dist(x0, p[j]));
			}
		}
		
		return minDist;
	}
	
//가장 가까운 거리 분할--------------------------
	private static int closest(int start, int end) {
		// p[start] ~ p[end] 원소가 3개 이하라면 브루트포스로 거리 반환 
		if (end - start + 1 < 4) {
			return brute(start, end);
		}

		int mid = (start+end)/2;
		
		int left = closest(start, mid);
		int right = closest(mid+1, end);
		
		int minDist = Math.min(left, right);
		
		
		// 중간 영역의 최소 거리---middleBand 구해서
		int band = middleBand(start, mid, end, minDist);
		return Math.min(minDist, band);	// 둘 중 작은 값을 반환
	}
	
//가운데 영역중 최소인 거리 구하기------------------------------------------------------
	private static int middleBand(int start, int mid, int end, int minDist) {
		int xDist;
 
		// index 참조가 많으므로 ArrayList를 활용
		ArrayList<Point> list = new ArrayList<Point>();
		
		// 후보군 추출하기
		int midX = p[mid].x;	// mid인덱스의 x좌표값
		for (int i = start; i <= end; i++) {
			xDist = p[i].x - midX;	// x좌표 차이	
			
			/*
			 * midDist는 제곱값이므로, x좌표거리고 제곱으로 계산해준다.
			 * xDist^2 < midDst 라면 후보군으로 리스트에 넣는다.
			 */
			if (xDist * xDist < minDist) {
				list.add(p[i]);
			}
		}
		
		// 후보군들을 y좌표 기준으로 정렬
		Collections.sort(list, Ycomp);
		
		// 후보군들을 순회하면서 y좌표 차이가 midDist내에 있는 원소들만 거리 측정
		int yDist;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				
				/*
				 * i번째 점과 j번째 점을 비교하여 y좌표거리를 측정한다.
				 * 측정된 y좌표거리가 minDist보다 작다면
				 * i, j 점의 거리를 측정하여 midDist와 측정한 거리 중
				 * 작은 값으로 갱신한다.  
				 */
				yDist = list.get(i).y - list.get(j).y;
				if (yDist * yDist < minDist) {
					minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
				}
				
				
				/*
				 *  그 외는 y좌표 차이가 midDist보다 크다는 의미로 i번째 원소에 대한
				 *  측정을 멈추고 다음 점으로 넘어간다. 
				 */
				else {
					break;
				}
			}
		}
		return minDist;
	}

}
