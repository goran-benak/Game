/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rosenkranz
 */
public class Maze {
    private int hight_of_the_maze;
    private int width_of_the_maze;
    
    private Cell[][] maze;

    public Maze(){
    
    }
  
    public Maze(String name_of_file) {
        List<String> lines;
        lines = loadMazeFromFile(name_of_file);

        hight_of_the_maze = lines.size();
        width_of_the_maze = lines.get(0).toCharArray().length;
        maze = new Cell[hight_of_the_maze][width_of_the_maze];

        createMazeCells(lines);
        linkMazeCells();

    }

    private void linkMazeCells() {
        for (int i = 0; i < hight_of_the_maze; i++) {
            for (int j = 0; j < width_of_the_maze; j++) {
                if (maze[i][j].isCorridor()) {
                    if (j+1!=width_of_the_maze && maze[i][j+1].isCorridor()){
                    maze[i][j].setRight_cell(maze[i][j+1]);
                    maze[i][j+1].setLeft_cell(maze[i][j]);
                    }
                    

                }
            }
        }
    }

    private void createMazeCells(List<String> lines) {
        String line;
        Iterator iter = lines.iterator();
        char[] row;
        int i = 0, j;

        while (iter.hasNext()) {
            line = (String) iter.next();
            row = line.toCharArray();

            for (j = 0; j < row.length; j++) {
                maze[i][j] = new Cell(row[j]);
            }
            i++;
        }
    
    }
    private List<String> loadMazeFromFile(String name_of_file) {

        List<String> lines = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(name_of_file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    } 
    
    public int getHight() {
        return hight_of_the_maze;
    }

   
    public int getWidth() {
        return width_of_the_maze;
    }

    
    public Cell[][] getMaze() {
        return maze;
    }
    
    @Override
    public String toString(){
        String out = new String();
        for(int i= 0; i<hight_of_the_maze;i++){
            for(int j=0;j<width_of_the_maze;j++){
            out = out+maze[i][j].toString();}
        out=out + "\n";
        }
    return out;
    }
    
    
}
