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
   
    private TypeOfTheCell type;
    private Food food;
    private char cell_character;
    
    public Cell(TypeOfTheCell type, Food food) {
        this.type = type;
        this.food = food;
    }

    public Cell(char character) {
        this.cell_character = character;
        switch (character) {
            case '#':
                this.type = TypeOfTheCell.WALL;
                this.food = null;
                break;
            case '.':
                this.type = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.DOT;
                break;
            case '%':
                this.type = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.CHERRY;
                break;
            case 'O':
                this.type = TypeOfTheCell.FULL_CORRIDOR;
                this.food = Food.PIE;
                break;
            case ' ':
                this.type = TypeOfTheCell.EMPTY_CORRIDOR;
                this.food = null;
            default:
                this.type = null;
                this.food = null;
                break;
        }
       
    }
    
    public TypeOfTheCell getType() {
        return type;
    }
    
    public void setType(TypeOfTheCell type) {
        this.type = type;
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
    
    public enum TypeOfTheCell {WALL, EMPTY_CORRIDOR, FULL_CORRIDOR;}
    public enum Food {EMPTY, DOT, CHERRY, PIE;}
    
    
    
}
