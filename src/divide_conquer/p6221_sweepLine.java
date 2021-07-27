package divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
 
public class p6221_sweepLine {
 
	private static Point[] p;
	
	private static class Point {	// ��ǥ Ŭ����
		int x;
		int y;
 
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
 
	}
 
	// �� Point�� �Ÿ��� ��ȯ�ϴ� �޼ҵ�
	private static int dist(Point o1, Point o2) {
		return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
	}
	
	private static Comparator<Point> Xcomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x - o2.x;
		}
	};
	
	/*
	 * ������������ �޸� ��� x, y�� ���� ���
	 * �ߺ� ����Ʈ�� ���ֱ� ���� y�� ���ٸ� x���� ���ؼ���
	 * �񱳸� ���ֵ��� �ؾ��Ѵ�.
	 */
	private static Comparator<Point> Ycomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o1.y - o2.y;
		}
	};
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		p = new Point[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		// X�࿡ ���� p�迭�� �����Ѵ�.
		Arrays.sort(p, Xcomp);
		
		// x�࿡ ���� �ĺ������� ���� set�̸� �ش� �ĺ������� y�࿡ ���� ���ĵȴ�. 
		TreeSet<Point> set = new TreeSet<Point>(Ycomp);
		
		/*
		 * ù ��° Point�� �� ��° Point�� �ּҰŸ���� �����ϰ�
		 * �����Ѵ�.
		 */
		int minDist = dist(p[0], p[1]);
		
		// Ž���� p[2]���� �����ϹǷ� p[0], p[1]�� �ĺ����̶� �����ϰ� TreeSet�� �ִ´�.
		set.add(p[0]);
		set.add(p[1]);
		
		int lowestIdx = 0;	// ���� ����
		for(int i = 2; i < N; i++) {
			
			Point benchPoint = p[i];
			
			/*
			 * [���� ȸ�� ���� �ĺ��� ���͸�]
			 * 
			 * ���� �������� p[i] ���� ���ҵ鿡 ���Ͽ� midDist���� 
			 * �ָ� ������ ���ҵ��� �����Ѵ�.
			 */
			while(lowestIdx < i) {
				Point targetPoint = p[lowestIdx];
				
				int xDist = benchPoint.x - targetPoint.x;
				
				/*
				 *  x��ǥ�� ���� minDist���� ũ�� �ĺ������� �����Ѵ�.
				 *  
				 *  �� �� ���ܵ� ���Ҵ� �ٽ� �ĺ����� �� ���� �����Ƿ�
				 *  ���� ������ �� ĭ �̵���Ų��.
				 */
 
				if(xDist * xDist > minDist) {
					set.remove(targetPoint);
					lowestIdx++;
				}
				
				/*
				 * x�࿡ ���� ���ĵ� �����̱� ������
				 * ó�� �����ϴ� �ĺ����� ����ġ�� �� ���� �ĺ�������
				 * x�࿡ ���� ��� �����ϹǷ� break�Ѵ�.
				 */
				else {
					break;
				}
			}
			
			/*
			 * [���� ȸ�� ���� �ĺ��� ���͸�]
			 * 
			 * p[(-100000, ������ - root(minDist)) : 100000, ������ + root(minDist)] ���̿� �ִ�
			 * ���ҵ鿡 ���� subTree�� ���, �ش� ���ҵ鿡 ���� ���������� �Ÿ��� �����Ѵ�.
			 */
			int sqrtMinDist = (int)Math.sqrt(minDist) + 1;
			TreeSet<Point> ySub = (TreeSet<Point>) set.subSet(new Point(-100000, benchPoint.y - sqrtMinDist), new Point(100000, benchPoint.y + sqrtMinDist));
			for(Point v : ySub) {
				minDist = Math.min(minDist, dist(benchPoint, v));
			}
			
			set.add(benchPoint);
 
		}
		
		System.out.println(minDist);
		
		
	}
 
}
