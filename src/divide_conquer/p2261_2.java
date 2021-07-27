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
	//������ �Ÿ� ���ϱ�
	private static int dist(Point o1, Point o2) {
		return (o1.x-o2.x)*(o1.x-o2.x) + (o1.y-o2.y)*(o1.y-o2.y);
	}
	//x��ǥ �������� �͸�ü
	private static Comparator<Point> Xcomp = new Comparator<Point>(){
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x-o2.x;
		}
	};
	//y��ǥ �������� �͸�ü
	private static Comparator<Point> Ycomp = new Comparator<Point>(){
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y-o2.y;
		}
	};
//pointŬ���� ��-----------------------------------------------------------------------------------
//main����
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
	
//���Ʈ���� ��� ----------2�� 3�� ������ ��쿡. �ּҰŸ� ��ȯ
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
	
//���� ����� �Ÿ� ����--------------------------
	private static int closest(int start, int end) {
		// p[start] ~ p[end] ���Ұ� 3�� ���϶�� ���Ʈ������ �Ÿ� ��ȯ 
		if (end - start + 1 < 4) {
			return brute(start, end);
		}

		int mid = (start+end)/2;
		
		int left = closest(start, mid);
		int right = closest(mid+1, end);
		
		int minDist = Math.min(left, right);
		
		
		// �߰� ������ �ּ� �Ÿ�---middleBand ���ؼ�
		int band = middleBand(start, mid, end, minDist);
		return Math.min(minDist, band);	// �� �� ���� ���� ��ȯ
	}
	
//��� ������ �ּ��� �Ÿ� ���ϱ�------------------------------------------------------
	private static int middleBand(int start, int mid, int end, int minDist) {
		int xDist;
 
		// index ������ �����Ƿ� ArrayList�� Ȱ��
		ArrayList<Point> list = new ArrayList<Point>();
		
		// �ĺ��� �����ϱ�
		int midX = p[mid].x;	// mid�ε����� x��ǥ��
		for (int i = start; i <= end; i++) {
			xDist = p[i].x - midX;	// x��ǥ ����	
			
			/*
			 * midDist�� �������̹Ƿ�, x��ǥ�Ÿ��� �������� ������ش�.
			 * xDist^2 < midDst ��� �ĺ������� ����Ʈ�� �ִ´�.
			 */
			if (xDist * xDist < minDist) {
				list.add(p[i]);
			}
		}
		
		// �ĺ������� y��ǥ �������� ����
		Collections.sort(list, Ycomp);
		
		// �ĺ������� ��ȸ�ϸ鼭 y��ǥ ���̰� midDist���� �ִ� ���ҵ鸸 �Ÿ� ����
		int yDist;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				
				/*
				 * i��° ���� j��° ���� ���Ͽ� y��ǥ�Ÿ��� �����Ѵ�.
				 * ������ y��ǥ�Ÿ��� minDist���� �۴ٸ�
				 * i, j ���� �Ÿ��� �����Ͽ� midDist�� ������ �Ÿ� ��
				 * ���� ������ �����Ѵ�.  
				 */
				yDist = list.get(i).y - list.get(j).y;
				if (yDist * yDist < minDist) {
					minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
				}
				
				
				/*
				 *  �� �ܴ� y��ǥ ���̰� midDist���� ũ�ٴ� �ǹ̷� i��° ���ҿ� ����
				 *  ������ ���߰� ���� ������ �Ѿ��. 
				 */
				else {
					break;
				}
			}
		}
		return minDist;
	}

}
