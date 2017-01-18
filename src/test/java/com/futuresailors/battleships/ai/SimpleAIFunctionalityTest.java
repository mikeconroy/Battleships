package com.futuresailors.battleships.ai;

import com.futuresailors.battleships.model.Grid;
import com.futuresailors.battleships.model.Ship;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class SimpleAIFunctionalityTest extends TestCase{
    //Human
    private Grid player1 = new Grid(10);
    //AI
    private Grid player2 = new Grid(10);
    private Ship[] ships;
    private SimpleAI ai;
    
    @Before 
    public void setUp(){
        //Init the ships & AI
        ships = new Ship[5];
        ships[0] = new Ship(5, 1, "/images/ships/Horizontal/1.png");
        ships[1] = new Ship(4, 1, "/images/ships/Horizontal/2.png");
        ships[2] = new Ship(3, 1, "/images/ships/Horizontal/3.png");
        ships[3] = new Ship(3, 1, "/images/ships/Horizontal/5.png");
        ships[4] = new Ship(2, 1, "/images/ships/Horizontal/5.png");
        ai = new SimpleAI(player2, player1, ships);
    }
    
    @Test
    public void testRandomMove(){
        ai.placeShips();
        Point pos1 = ai.takeMove();
        Point pos2 = ai.takeMove();
        assert(pos1.x != pos2.x && pos1.y != pos2.y);
    }
    //Not sure how to test this.
    @Test
    public void testPlaceShips(){
        ai.placeShips();
 
    }

}