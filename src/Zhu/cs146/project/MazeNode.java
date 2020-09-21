package Zhu.cs146.project;

import java.util.ArrayList;

/**Represents a vertex in a maze. Can have a maximum of 4 neighbors.*/
public class MazeNode {
    int row;
    int col;
    boolean hasNorthWall;
    boolean hasSouthWall;
    boolean hasEastWall;
    boolean hasWestWall;
    boolean wasVisited;
    ArrayList<MazeNode> neighbors;
    Color color;
    int discoveryTime;
    int finishingTime;
    Integer distance;
    Integer numVisited;
    MazeNode predecessor;

    /**
     * Constructor for a MazeNode with a given row and column
     * @param r The row of the MazeNode
     * @param c The column of the MazeNode
     */
    public MazeNode(int r, int c) {
        neighbors = new ArrayList<MazeNode>();
        wasVisited = false;
        hasWestWall = hasEastWall = hasNorthWall = hasSouthWall = true;
        row = r;
        col = c;
        color = Color.WHITE;
        discoveryTime = 0;
        finishingTime = 0;
        distance = 0;
        numVisited = 0;
        predecessor = null;
    }

    /**
     * Sets the node as "Visited"
     */
    public void setVisited(){
        wasVisited = true;
    }

    /**
     * Returns true if the node has been visited before
     * @return Whether node has been visited before
     */


    public boolean wasVisited(){
        return wasVisited;
    }

    /**
     * Determines if the node has all its walls intact
     * @return True if the node has all its walls intact
     */
    public boolean allWallsIntact(){
        return neighbors.size() == 0;
    }

    //Two nodes are equal if they have the same location
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        MazeNode other = (MazeNode)o;
        return other.row == row && other.col == col;
    }

    @Override
    public String toString(){
        return "(" + row + ", " + col + ")";
    }

    /**
     * Knocks down the wall between two walls and sets them as neighbors.
     * @param node The other node who is to become its neighbor
     */
    public void knockDownWall(MazeNode node){
        //node is west neighbor
        if(node.row == row && node.col == col - 1){
            hasWestWall = false;
            node.hasEastWall = false;
            neighbors.add(node);
            node.neighbors.add(this);
        }
        //node is east neighbor
        else if(node.row == row && node.col == col + 1){
            hasEastWall = false;
            node.hasWestWall = false;
            neighbors.add(node);
            node.neighbors.add(this);
        }
        //node is north neighbor
        else if(node.col == col && node.row == row - 1){
            hasNorthWall = false;
            node.hasSouthWall = false;
            neighbors.add(node);
            node.neighbors.add(this);
        }
        //node is south neighbor
        else if(node.col == col && node.row == row + 1){
            hasSouthWall = false;
            node.hasNorthWall = false;
            neighbors.add(node);
            node.neighbors.add(this);
        }
    }
}