package com.example.make_a_square_gui;
public class PiecesModel {

    private int id;
    private int [][] matrix;
    private int count;
    private String textField;
    private static int [][][] pieces;
    //static
    public PiecesModel()
    {
        pieces = new int[7][][];
        pieces[0] = new int[][]{{1, 0}, {1, 0}, {1, 1}};
        pieces[1] = new int[][]{{1, 1, 0}, {0, 1, 1}};
        pieces[2] = new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
    }
    int [][] retrievePiece(Character character)
    {
        if(character=='L') return pieces[0].clone();
        else  if(character=='Z') return pieces[1].clone();
        else  if(character=='T') return pieces[2].clone();
        throw new IndexOutOfBoundsException();
    }
}
