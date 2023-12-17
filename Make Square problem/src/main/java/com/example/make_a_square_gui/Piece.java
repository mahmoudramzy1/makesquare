package com.example.make_a_square_gui;
public class Piece {
    private int row , col;
    private int[][] piece;
    
    public Piece(int[][] piece){
        this.row = piece.length;
        this.col = piece[0].length;
        this.piece = piece;
    }
    
    public int[][] getPiece(){
        return this.piece.clone();
    }
    
    public int[][] getPieceAfterRotation(int moveID) {

        switch(moveID){
            case 0:
                return this.move0();
            case 1:
                return this.move1();
            case 2:
                return this.move2();
            case 3:
                return this.move3();
        }
        throw new IndexOutOfBoundsException();
    }
    
    private int[][] move0(){
            //this time I returned a clone not the object reference itself.
            return this.piece.clone();
    }
    
    private int[][] move1(){
            /*
            it's like rotating it 90 degree clock-wise.
            */
            int id = this.row - 1;
            int[][] newPiece = new int[col][row];
            for(int i = 0; i < this.row; i++){
                for(int j = 0; j < this.col; j++){
                    //System.out.print(piece[i][j]);
                    newPiece[j][id] = this.piece[i][j];
                }
                id--;
            }
            return newPiece;
    }
    
    private int[][] move2(){
            int[][] newPiece = new int[row][col];
            for(int i=0; i< this.row; i++){
                for(int j=0; j< this.col; j++){
                    int t= this.col -(j+1);
                    int r= this.row -(i+1);
                    newPiece[r][t]= this.piece[i][j];
                }
            }
            return newPiece;
    }
    
    private int[][] move3(){
            int[][] newPiece = new int[col][row];
            for (int i=0; i< this.row; i++){
                for(int j=0 ; j < this.col; j++){
                    int t= this.col -(j+1);
                    newPiece[t][i] = this.piece[i][j]; 
                }
            } 
            return newPiece;
    }
    @Override
    public String toString(){
        StringBuffer ret = new StringBuffer();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ret.append(this.piece[i][j]);
            }
            ret.append('\n');
        }
        return ret.toString();
    }
}
