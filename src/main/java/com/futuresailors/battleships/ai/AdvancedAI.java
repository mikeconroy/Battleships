package com.futuresailors.battleships.ai;

import com.futuresailors.battleships.model.Grid;
import com.futuresailors.battleships.model.GridTile;
import com.futuresailors.battleships.model.Ship;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

//This is a copy of moderate that needs modifying

/**
 * Advanced implementation of the AI. This will randomly hit tiles but once it finds a hit it will
 * keep hitting adjacent tiles until that ship is wiped out. It also places it's ships randomly.
 * 
 * @author Michael Conroy
 */
public class AdvancedAI implements AI {

    private Grid myGrid;
    private Grid oppGrid;
    private Ship[] ships;

    /**
     * @param myGrid - The AIs grid where it will place it's ships.
     * @param oppGrid - The AIs enemies grid where it will drop bombs.
     * @param ships - The AIs ships it needs to place.
     */
    public AdvancedAI(final Grid myGrid, Grid oppGrid, Ship[] ships) {
        this.myGrid = myGrid;
        this.oppGrid = oppGrid;
        this.ships = ships;
    }

    public void placeShips() {
        // Randomly places ships like the Simple AI.
        Point pos = new Point(0, 0);
        for (Ship ship : ships) {
            do {
                pos.x = ThreadLocalRandom.current().nextInt(0, myGrid.getColumns());
                pos.y = ThreadLocalRandom.current().nextInt(0, myGrid.getRows());
            } while (!myGrid.checkValidPlace(pos, ship));
            ship.placeShip(pos);
            myGrid.placeShip(pos, ship);
        }
    }

    public Point takeMove() {
        Point target = new Point(0, 0);
        target.x = ThreadLocalRandom.current().nextInt(0, myGrid.getColumns());
        target.y = ThreadLocalRandom.current().nextInt(0, myGrid.getRows());
        for (int y = 0; y < oppGrid.getColumns(); y++) {
            for (int x = 0; x < oppGrid.getRows(); x++) {
                if (oppGrid.getTile(new Point(x, y)) == GridTile.SHIP) {
                    target = new Point(x, y);
                    return target;
                }
            }
        }
        return target;
    }
}
