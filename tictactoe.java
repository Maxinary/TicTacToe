package ticTacToe;
import java.util.Scanner;
public class tictactoe {
	char[][] table;
	boolean xTurn;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//intro
		System.out.print("Use the numpad(make sure you're in num-lock) to choose the\n"
				+ "position of your placement on the board(7->top left, 5-> center, etc.)\n"
				+ "ok(Y/N)?");
		if(sc.nextLine().toUpperCase().equals("Y")){
			System.out.println("");
			//end intro
			tictactoe tr = new tictactoe();
			tr.print();
			String trun;
			String valid = "";
			do{
				System.out.println(valid);
				valid = 
						tr.turn(
								formatIn(new char[] {'O','X'}[tr.xTurn?1:0])
						)
					;
				System.out.print("\n\n\n");
				tr.print();
				trun=tr.checkWin();
			}while(trun=="No current win");
			System.out.println("\n"+tr.checkWin());
		}
	}
	public tictactoe(){
		this.table = new char[][] {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		this.xTurn = true;
	}
	public String turn(int value){
		char sar;
		if(xTurn){
			sar ='X'; 
		}else{
			sar='O';
		}
		if(value>-1 && value<9){
			if(table[value/3][value%3] == ' '){
				table[value/3][value%3] = sar;
				xTurn = !xTurn;
			}else{
				return "That spot's already been used!";
			}
		}else{
			return "That's not an actual spot!";
		}
		return "";
	}
	public void print(){
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[i].length;j++){
				System.out.print(' ');
				System.out.print(table[i][j]);
				System.out.print(' ');
				if(j!=2){
					System.out.print('|');
				}
			}
			if(i!=2){
				System.out.print("\n-----------\n");
			}
		}
	}
	public String checkWin(){
		char[] pos = {'X','O'};
		for(int j=0;j<pos.length;j++){
			for(int i=0;i<3;i++){
				if(table[0][i]==table[1][i] && table[1][i]==table[2][i] && table[1][i]==pos[j]){
					return ""+table[0][i]+" wins!";
				}
				if(table[i][0]==table[i][1] && table[i][1]==table[i][2] && table[i][1]==pos[j]){
					return ""+table[i][0]+" wins!";
				}
			}
			if(table[0][0]==table[1][1] && table[1][1]==table[2][2] && table[1][1]==pos[j]){
				return ""+table[2][2]+" wins!";
			}
			if(table[2][0]==table[1][1] && table[1][1]==table[0][2] && table[1][1]==pos[j]){
				return ""+table[1][1]+" wins!";
			}
		}
		int l=0;
		for(int i=0;i<9;i++){
			if(table[i/3][i%3]!=' '){
				l++;
			}
		}
		if(l==9){
			return "Cat's Game";
		}
		return "No current win";
	}
	public static int formatIn(char turn){
		System.out.println(turn+"'s Turn");
		int a = sc.nextInt();
		int out = a;
		switch(a){
			case 1:
				out = 7;
				break;
			case 2:
				out = 8;
				break;
			case 3:
				out = 9;
				break;
			case 7:
				out = 1;
				break;
			case 8:
				out = 2;
				break;
			case 9:
				out = 3;
				break;
			default:break;
		}
		return --out;
	}
}