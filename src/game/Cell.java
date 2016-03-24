/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rosenkranz
 */
public class Cell {
    private int coordinate[] = new int[2];
    
    private TypeOfTheCell type_of_the_cell;
    private Food food;
    private char cell_character;
    
    private Cell upper_cell;
    private Cell lower_cell;
    private Cell left_cell;
    private Cell right_cell;
    
    
    
    
    /**
     *
     */
    public int relative_distance;
    
    public Cell(TypeOfTheCell type, Food food) {
        this.type_of_the_cell = type;
        this.food = food;
    }

    public Cell(char character, int x, int y) {
        this.coordinate[0] = x;
        this.coordinate[1] = y;
        this.cell_character = character;
        this.upper_cell = null;
        this.lower_cell = null;
        this.left_cell = null;
        this.right_cell = null;
       
        relative_distance = MAXIMAL_DISTANCE;
        
        
        switch (character) {
            case '#':
                this.type_of_the_cell = TypeOfTheCell.WALL;
                this.food = null;
                break;
            case '.':
                this.type_of_the_cell = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.DOT;
                break;
            case '%':
                this.type_of_the_cell = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.CHERRY;
                break;
            case 'O':
                this.type_of_the_cell = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.PIE;
                break;
            case ' ':
                this.type_of_the_cell = TypeOfTheCell.EMPTY_CORRIDOR;
                this.food = null;
            default:
                this.type_of_the_cell = null;
                this.food = null;
                break;
        }
       
    }
    
    public TypeOfTheCell getType() {
        return type_of_the_cell;
    }
    
    public void setType(TypeOfTheCell type) {
        this.type_of_the_cell = type;
    }

   
    
    public Food getFood() {
        return food;
    }
    
    public void setFood(Food food) {
        this.food = food;
    }
    
    @Override
    public String toString(){
    return new String() + cell_character;
    }

    /**
     * @return the upper_cell
     */
    public Cell getUpper_cell() {
        return upper_cell;
    }

    /**
     * @param upper_cell the upper_cell to set
     */
    public void setUpper_cell(Cell upper_cell) {
        this.upper_cell = upper_cell;
    }

    /**
     * @return the lower_cell
     */
    public Cell getLower_cell() {
        return lower_cell;
    }

    /**
     * @param lower_cell the lower_cell to set
     */
    public void setLower_cell(Cell lower_cell) {
        this.lower_cell = lower_cell;
    }

    /**
     * @return the left_cell
     */
    public Cell getLeft_cell() {
        return left_cell;
    }

    /**
     * @param left_cell the left_cell to set
     */
    public void setLeft_cell(Cell left_cell) {
        this.left_cell = left_cell;
    }

    /**
     * @return the right_cell
     */
    public Cell getRight_cell() {
        return right_cell;
    }

    /**
     * @param right_cell the right_cell to set
     */
    public void setRight_cell(Cell right_cell) {
        this.right_cell = right_cell;
    }
    
    
    public boolean isWall(){
        return TypeOfTheCell.WALL==type_of_the_cell;      
    }
    
    public boolean isCorridor(){
        return TypeOfTheCell.EMPTY_CORRIDOR==type_of_the_cell;
    }

    /**
     * @return the coordinate
     */
    public int[] getCoordinate() {
        return coordinate;
    }

    /**
     * @param coordinate the coordinate to set
     */
    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

  

    /**
     * @return the relative_distance
     */
    public int getRelative_distance() {
        return relative_distance;
    }

    /**
     * @param relative_distance the relative_distance to set
     */
    public void setRelative_distance(int relative_distance) {
        this.relative_distance = relative_distance;
    }
    
    public enum TypeOfTheCell {WALL, EMPTY_CORRIDOR, FULL_CORRIDOR;}
    public enum Food {EMPTY, DOT, CHERRY, PIE;}
    public final int MAXIMAL_DISTANCE = 100000000;
    
    
    
}
