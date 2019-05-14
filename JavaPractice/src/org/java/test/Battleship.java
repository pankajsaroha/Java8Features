package org.java.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Battleship {

	public static void main(String args[]) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		String filePath = b.readLine();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.substring(0, filePath.lastIndexOf("\\")+1)+"output.txt"));
		String bg[] = br.readLine().split(" ");
		int battleGroundFirstSize = Integer.parseInt(bg[0]);
		int battleGroundSecondSize = (int)bg[1].charAt(0) - 64;
		
		int noOfBattleship = Integer.parseInt(br.readLine().trim());
		
		/*
		 * Battle Grounds
		 */
		int battleGround1[][] = new int[battleGroundFirstSize][battleGroundFirstSize];
		int battleGround2[][] = new int[battleGroundSecondSize][battleGroundSecondSize];
		
		/*
		 * Arrays to put the starting cordinates and size of battleships for both players.
		 * These arrays will be used to track the battleship condition.
		 */
		int player1Battleships[][] = new int[noOfBattleship][4];
		int player2Battleships[][] = new int[noOfBattleship][4];
		
		for(int i=0; i<noOfBattleship; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String type = st.nextToken();
			
			/*
			 * dimension of battleships
			 */
			int dx1 = Integer.parseInt(st.nextToken());
			int dy1 = Integer.parseInt(st.nextToken());
			
			/*
			 * position on battleship 1
			 */
			String position = st.nextToken();
			int px1 = (((int)position.charAt(0) - 64))-1;
			int py1 = ((Character.getNumericValue(position.charAt(1))))-1;
			
			player1Battleships[i][0] = px1;
			player1Battleships[i][1] = py1;
			player1Battleships[i][2] = px1+dy1-1;
			player1Battleships[i][3] = py1+dx1-1;
			
			/*
			 * position on battleship 2
			 */
			String position2 = st.nextToken();
			int px2 = ((int)position2.charAt(0) - 64)-1;
			int py2 = (Character.getNumericValue(position2.charAt(1)))-1;
			
			player2Battleships[i][0] = px2;
			player2Battleships[i][1] = py2;
			player2Battleships[i][2] = px2+dy1-1;
			player2Battleships[i][3] = py2+dx1-1;
			
			/*
			 * battleships on battleground1
			 */
			if("Q".equals(type)) {
				for(int j=0; j<dx1; j++) {
					for(int k=0; k<dy1; k++) {
						battleGround1[k+px1][j+py1] = 2;
					}
				}
			} else {
				for(int j=0; j<dx1; j++) {
					for(int k=0; k<dy1; k++) {
						battleGround1[k+px1][j+py1] = 1;
					}
				}
			}
			
			/*
			 * battleships on battleground2
			 */
			if("Q".equals(type)) {
				for(int j=0; j<dx1; j++) {
					for(int k=0; k<dy1; k++) {
						battleGround2[k+px2][j+py2] = 2;
					}
				}
			} else {
				for(int j=0; j<dx1; j++) {
					for(int k=0; k<dy1; k++) {
						battleGround2[k+px2][j+py2] = 1;
					}
				}
			}
			
		}
		
		/*
		 * Missiles for both the players 
		 */
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				
		while(true) {
			boolean flag1 = true;
			boolean flag2 = true;
			boolean result = false;
			while(flag1) {
				if (st1.hasMoreElements()) {
					String missile = st1.nextToken();
					flag1 = hitTargetByPlayer1(missile, battleGround2, bw);
					if (flag1) {
						result = checkBattleShipsForPlayer1(player2Battleships, noOfBattleship, battleGround2);
						if (result) {
							//System.out.println("Player-1 won the battle");
							bw.write("Player-1 won the battle");
							bw.newLine();
							bw.close();
							return;
						}
					}
				} else {
					flag1 = false;
					//System.out.println("Player-1 has no more missiles left to launch");
					bw.write("Player-1 has no more missiles left to launch");
					bw.newLine();
				}
			}
			while(flag2) {
				if(st2.hasMoreElements()) {
					String missile = st2.nextToken();
					flag2 = hitTargetByPlayer2(missile, battleGround1, bw);
					if (flag2) {
						result = checkBattleShipsForPlayer2(player1Battleships, noOfBattleship, battleGround1);
						if (result) {
							//System.out.println("Player-2 won the battle");
							bw.write("Player-2 won the battle");
							bw.newLine();
							bw.close();
							return;
						}
					}
				} else {
					flag2 = false;
					//System.out.println("Player-2 has no more missiles left to launch");
					bw.write("Player-2 has no more missiles left to launch");
					bw.newLine();
				}
			}
			if(st1.hasMoreElements() == false && st2.hasMoreElements() == false) {
				//System.out.println("Match drawn");
				bw.write("Match drawn");
				bw.newLine();
				bw.close();
				return;
			}
		}
	}
	
	/*
	 * To check the missile was hit or miss by player 1
	 */
	public static boolean hitTargetByPlayer1(String target, int battleGround2[][], BufferedWriter bw) throws IOException {
		int tx1 = ((int)target.charAt(0) - 64)-1;
		int ty1 = (Character.getNumericValue(target.charAt(1)))-1;
		if(battleGround2[tx1][ty1] != 0) {
			battleGround2[tx1][ty1]--;
			//System.out.println("Player-1 fires a missile with target "+target+" which got hit");
			bw.write("Player-1 fires a missile with target "+target+" which got hit");
			bw.newLine();
			return true;
		}
		//System.out.println("Player-1 fires a missile with target "+target+" which got miss");
		bw.write("Player-1 fires a missile with target "+target+" which got miss");
		bw.newLine();
		return false;
	}
	
	/*
	 * To check the missile was hit or miss by player 2
	 */
	public static boolean hitTargetByPlayer2(String target, int battleGround1[][], BufferedWriter bw) throws IOException {
		int tx1 = ((int)target.charAt(0) - 64)-1;
		int ty1 = (Character.getNumericValue(target.charAt(1)))-1;
		if(battleGround1[tx1][ty1] != 0) {
			battleGround1[tx1][ty1]--;
			//System.out.println("Player-2 fires a missile with target "+target+" which got hit");
			bw.write("Player-2 fires a missile with target "+target+" which got hit");
			bw.newLine();
			return true;
		}
		//System.out.println("Player-2 fires a missile with target "+target+" which got miss");
		bw.write("Player-2 fires a missile with target "+target+" which got miss");
		bw.newLine();
		return false;
	}
	
	/*
	 * To check whether all the battleships of player-1 have been destroyed by player-2
	 */
	public static boolean checkBattleShipsForPlayer2(int player1Battleships[][], int num, int battleGround1[][]) {
		for(int n=0; n<num; n++) {
			int px1 = player1Battleships[n][0];
			int py1 = player1Battleships[n][1];
			int px2 = player1Battleships[n][2];
			int py2 = player1Battleships[n][3];
			
			for(int i=px1; i<=px2; i++) {
				for(int j=py1; j<=py2; j++) {
					if(battleGround1[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/*
	 * To check whether all the battleships of player-2 have been destroyed by player-1
	 */
	public static boolean checkBattleShipsForPlayer1(int player2Battleships[][], int num, int battleGround2[][]) {
		for(int n=0; n<num; n++) {
			int px01 = player2Battleships[n][0];
			int py01 = player2Battleships[n][1];
			int px02 = player2Battleships[n][2];
			int py02 = player2Battleships[n][3];
			for(int i=px01; i<=px02; i++) {
				for(int j=py01; j<=py02; j++) {
					if(battleGround2[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
