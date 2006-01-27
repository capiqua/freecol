package net.sf.freecol.common.model;

/**
 * Determines the cost of a single move. Used by {@link Map#findPath} 
 * and {@link Map#search}.
 */
public interface CostDecider {
    
    public static final int ILLEGAL_MOVE = -1;
    
    /**
     * Determines the cost of a single move.
     * 
     * @param oldTile The <code>Tile</code> we are moving from.
     * @param newTile The <code>Tile</code> we are moving to.
     * @param movesLeft The remaining moves left. The
     *      <code>CostDecider</code> can use this information
     *      if needed.
     * @return The cost of moving the given unit from the
     *      <code>oldTile</code> to the <code>newTile</code>.
     */
    public int getCost(Unit unit, Tile oldTile, Tile newTile, int movesLeft, int turns);   
    
    /**
     * Gets the number of moves left. This method should be
     * called after invoking {@link #getCost}.
     * 
     * @return The number og moves left.
     */
    public int getMovesLeft();

    /**
     * Checks if a new turn is needed in order to make the
     * move. This method should be called after invoking 
     * {@link #getCost}.
     * 
     * @return <code>true</code> if the move requires a
     *      new turn and <code>false</code> otherwise.
     */    
    public boolean isNewTurn();    
}
