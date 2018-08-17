
/**
 * contains the TTT board and methods to modify it
 *
 * @author (Madeline Holda, Shane Fisher)
 * @version (01/29/2018)
 */
import java.lang.Math;
public class TTT_Board{
    private int[][] board;
    private int row, column;
    private String marker1, marker2;
    
    //creates a 3x3 board with all spaces set to 0
    public TTT_Board(){
        board = new int[3][3];
        row = -1;
        column = -1;
        marker1 = "X";
        marker2 = "O";
    }
    
    //changes board
    public void doTurn(int r, int c, int num){
        board[r][c] = num;
    }
    
    //sets a marker to each player
    public void setMarker(int player, int choice){
        if(player == 1){
            switch (choice){
                case 1: marker1 = "X"; break;
                case 2: marker1 = "☺"; break;
                case 3: marker1 = "☻"; break;
                case 4: marker1 = "♥"; break;
                case 5: marker1 = "♫"; break;
                case 6: marker1 = "▒"; break;
                case 7: marker1 = "§"; break;
                case 8: marker1 = "☼"; break;
                default: System.out.println("Invalid. Reverting to default");
            }
        } else if (player == 2){
            switch (choice){
                case 1: marker2 = "O"; break;
                case 2: marker2 = "☺"; break;
                case 3: marker2 = "☻"; break;
                case 4: marker2 = "♥"; break;
                case 5: marker2 = "♫"; break;
                case 6: marker2 = "▒"; break;
                case 7: marker2 = "§"; break;
                case 8: marker2 = "☼"; break;
                default: System.out.println("Invalid. Reverting to default");
            }
        }
        if(marker1.equals(marker2)){
            System.out.println("Marker taken. Reverting to default");
            marker2 = "O";
        }
    }
    
    //gives p1 character
    public String getMarker1(){
        return marker1;
    }
    
    //gives p2 character
    public String getMarker2(){
        return marker2;
    }
    
    //returns true if a space is open
    public boolean isOpen(int r, int c){
        if((r>2||r<0)||(c>2||c<0)){
            return false;
        } else if(board[r][c]==0){
            return true;
        } else{
            return false;
        }
    }
    
    //returns true if there is a winner
    public boolean hasWon(){
        boolean winner = false;
        for(int i=0; i<board.length; i++){
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]!=0){
                winner = true;
            }
        }
        for(int i=0; i<board[0].length; i++){
            if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[0][i]!=0){
                winner = true;
            }
        }
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!=0){
            winner = true;
        }
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]!=0){
            winner = true;
        }
        return winner;
    }
    
    //resets all spaces to 0
    public void clearBoard(){
        board = new int[3][3];
    }
    
    //sets row and column to a smart move for the AI to make
    public void getPlace(){
        row = -1;
        column = -1;
        int CM = 2;
        while(CM>0&&row<0&&column<0){
            if(isOpen(1, 1)){
                row = 1;
                column = 1;
            } else{
                for(int i=0; i<board.length; i++){
                    if((board[i][0]==board[i][1]&&board[i][0]==CM)||(board[i][1]==board[i][2]&&board[i][1]==CM)||(board[i][2]==board[i][0]&&board[i][2]==CM)){
                        for(int j=0; j<board.length; j++){
                            if(isOpen(i, j)){
                                row = i;
                                column = j;
                            }
                        }
                    }
                }
                for(int i=0; i<board.length; i++){
                    if((board[0][i]==board[1][i]&&board[0][i]==CM)||(board[1][i]==board[2][i]&&board[1][i]==CM)||(board[2][i]==board[0][i]&&board[2][i]==CM)){
                        for(int j=0; j<board.length; j++){
                            if(isOpen(j, i)){
                                row = j;
                                column = i;
                            }
                        }
                    }
                }
                if((board[0][0]==board[1][1]&&board[0][0]==CM)||(board[1][1]==board[2][2]&&board[1][1]==CM)||(board[2][2]==board[0][0]&&board[2][2]==CM)){
                    for(int i=0; i<board.length; i++){
                        if(isOpen(i, i)){
                            row = i;
                            column = i;
                        }
                    }
                }
                if((board[0][2]==board[1][1]&&board[0][2]==CM)||(board[1][1]==board[2][0]&&board[1][1]==CM)||(board[0][2]==board[2][0]&&board[2][0]==CM)){
                    for(int i=0; i<board.length; i++){
                        if(isOpen(i, 2-i)){
                            row = i;
                            column = 2-i;
                        }
                    }
                }
            }
            CM--;
        }
        if(row<0&&column<0){
            row = (int)(Math.random()* 3);
            column = (int)(Math.random()* 3);
        }
    }
    
    //return the smart move row (see above)
    public int getRow(){
        return row;
    }
    
    //returns the smart move column (see 2 above)
    public int getCol(){
        return column;
    }
    
    //prints the board (w/ special characters)
    public String toString(){
        String result = "";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                result += "[";
                switch(board[i][j]){
                    case 0: result += "-"; break;
                    case 1: result += marker1; break;
                    case 2: result += marker2; break;
                }
                result += "]";
            }
            result += "\n";
        }
        return result;
    }
}
