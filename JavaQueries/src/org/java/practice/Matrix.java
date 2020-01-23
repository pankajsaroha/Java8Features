package org.java.practice;

import java.util.LinkedList;

public class Matrix {

	public static void main(String[] args) {
		int a[][] = {
				{1, 0, 1, 1, 0},
				{1, 0, 0, 1, 1},
				{1, 0, 2, 0, 1},
				{0, 1, 0, 0, 1},
				{0, 0, 1, 0, 1}
		};
		Matrix m = new Matrix();
		m.shortest(a);
	}
	
	
	/*
	 * int shortest(int a[][], int n, int m, int i, int j, int h) { if (i == 0 || i
	 * == n - 1 || j == 0 || j == m - 1) { return h; } int l = shortest(a, n, m, i -
	 * 1, j, h); return h; }
	 */
	
	class Point {
		int x; int y;
		int dist;
		Point parent;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		Point(int x, int y, int dist, Point parent) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.parent = parent;
		}
		
		public int hashCode(Point p) {
			return p.x + p.y ;
		}
		
		public boolean equals(Point p) {
			return (this.x == p.x) && (this.y == p.y);
		}
	}
	
	int shortest(int arr[][]) {
		LinkedList<Point> queue = new LinkedList<>();
		Point start = new Point(2, 2);
		queue.add(start);
		int dist[][] = new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				dist[i][j] = -1;
			}
		}
		dist[start.x][start.y] = 0;
		/*
		 * while(!queue.isEmpty()) { Point p = queue.removeFirst(); if (p.x > 0 && p.x <
		 * arr.length - 1 && p.y > 0 && p.y < arr.length - 1) { if (arr[p.x - 1][p.y] ==
		 * 0) { if(dist[p.x - 1][p.y] == -1) { dist[p.x - 1][p.y] = dist[p.x][p.y] + 1;
		 * queue.add(new Point(p.x - 1, p.y)); } else if(dist[p.x - 1][p.y] >
		 * dist[p.x][p.y] + 1) {
		 * 
		 * } } if (arr[p.x + 1][p.y] == 0) { dist[p.x + 1][p.y] = dist[p.x][p.y] + 1;
		 * queue.add(new Point(p.x + 1, p.y)); } if (arr[p.x][p.y - 1] == 0) {
		 * dist[p.x][p.y - 1] = dist[p.x][p.y] + 1; queue.add(new Point(p.x, p.y - 1));
		 * } if (arr[p.x][p.y + 1] == 0) { dist[p.x][p.y + 1] = dist[p.x][p.y] + 1;
		 * queue.add(new Point(p.x, p.y + 1)); } } }
		 */
		
		
		while(!queue.isEmpty()) {
			Point p = queue.removeFirst();
			int i = p.x;
			int j = p.y;
			if(i > 0 && i < arr.length && j >= 0 && j < arr.length && arr[i-1][j] == 0) {
				Point up = new Point(i-1, j);
				if(dist[i-1][j] == -1 || dist[i-1][j] > dist[i][j] + 1) {
					dist[i-1][j] = dist[i][j] + 1;
					if(!queue.contains(up)) {
						queue.add(up);
					}
				}
			}
			if(i >= 0 && i < arr.length-1 && j >=0 && j < arr.length && arr[i+1][j] == 0) {
				Point down = new Point(i+1, j);
				if(dist[i+1][j] == -1 || dist[i+1][j] > dist[i][j] + 1) {
					dist[i+1][j] = dist[i][j] + 1;
					if(!queue.contains(down)) {
						queue.add(down);
					}					
				}
			}
			if(i >= 0 && i < arr.length && j > 0 && j < arr.length && arr[i][j-1] == 0) {
				Point left  = new Point(i, j-1);
				if(dist[i][j-1] == -1 || dist[i][j-1] > dist[i][j] + 1) {
					dist[i][j-1] = dist[i][j] + 1;
					if(!queue.contains(left)) {
						queue.add(left);
					}
				}
			}
			if(i >= 0 && i < arr.length && j >= 0 && j < arr.length-1 && arr[i][j+1] == 0) {
				Point right = new Point(i, j+1);
				if(dist[i][j+1] == -1 || dist[i][j+1] > dist[i][j] + 1) {
					dist[i][j+1] = dist[i][j] + 1;
					if(!queue.contains(right)) {
						queue.add(right);
					}
				}
			}
		}
		return -1;
	}
	 
}
