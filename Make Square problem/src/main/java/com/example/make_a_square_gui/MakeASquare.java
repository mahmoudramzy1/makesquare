package com.example.make_a_square_gui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MakeASquare {
    public static int[][] Square(HashMap<Integer, int[][]> sendPieces) throws InterruptedException {
        


        //pass pieces to the slaves area...
        Paralleling.allPieces = sendPieces;
        Paralleling.foundBoard = false;


        //preparing the slaves.
        Paralleling masterSlave = new Paralleling();
        ArrayList<Thread> slaves = new ArrayList<Thread>();
        for(int i = 0; i < constants.numberOfThreads; i++){
            Thread tmp = new Thread(masterSlave , Integer.toString(i));
            slaves.add(tmp);
        }
        
        //go slaves....
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).start();
        }
        //wait slaves to finish...
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).join();
        }
        if(Paralleling.foundBoard) return Paralleling.finallyBoard;
        else return null;
    }
}