/**
 * Maze.java
 * @author Lin Zhu
 * @author Runze Wei
 * CS 146 Porject 3
 */
package Zhu.cs146.project;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test for the Maze class
 */
public class MazeTest {

    /**
     * Tests the timing of DFS and BFS of a maze with size four
     */
    @Test
    public void testTimeSizeFour(){

        Maze maze = new Maze(4);
        System.out.println("Graph size: 4\n\n" +"Maze:" + "\n" + maze + "\n");

        //depth-first search
        long start = System.currentTimeMillis();
        maze.dfs();
        System.out.println("Depth-first search:\n");
        System.out.println(maze.printDFS());
        System.out.println("\n" + maze.printDFSShortestPath());
        long end = System.currentTimeMillis();
        System.out.println("DFS Time Efficiency(Size4): " + (end - start) + " ms\n");

        //breadth-first search
        start = System.currentTimeMillis();
        maze.bfs();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze.printBFS());
        System.out.println("\n" + maze.printBFSShortestPath());
        end = System.currentTimeMillis();
        System.out.println("BFS Time Efficiency(Size4): " + (end - start) + " ms\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size six
     */
    @Test
    public void testDFSTimeSizeSix(){
        long start = System.currentTimeMillis();
        Maze maze = new Maze(6);
        System.out.println("Graph size: 6\n\n" +"Maze:" + "\n" + maze + "\n");

        //depth-first search
        maze.dfs();
        System.out.println("Depth-first search:\n");
        System.out.println(maze.printDFS());
        System.out.println("\n" + maze.printDFSShortestPath());
        long end = System.currentTimeMillis();
        System.out.println("DFS Time Efficiency(Size6): " + (end - start) + " ms\n");

        // breadth-first search
        start = System.currentTimeMillis();
        maze.bfs();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze.printBFS());
        System.out.println("\n" + maze.printBFSShortestPath());
        end = System.currentTimeMillis();
        System.out.println("BFS Time Efficiency(Size6): " + (end - start) + " ms\n");
    }

    /**
     * Tests the timing of DFS and BFS of a maze with size eight
     */
    @Test
    public void testDFSTimeSizeEight(){
        long start = System.currentTimeMillis();
        Maze maze = new Maze(8);
        System.out.println("Graph size: 8\n\n" +"Maze:" + "\n" + maze + "\n");

        //depth-first search
        maze.dfs();
        System.out.println("Depth-first search:\n");
        System.out.println(maze.printDFS());
        System.out.println("\n" + maze.printDFSShortestPath());
        long end = System.currentTimeMillis();
        System.out.println("DFS Time Efficiency(Size8): " + (end - start) + " ms\n");

        // breadth-first search
        start = System.currentTimeMillis();
        maze.bfs();
        System.out.println("Breadth-first search:\n");
        System.out.println(maze.printBFS());
        System.out.println("\n" + maze.printBFSShortestPath());
        end = System.currentTimeMillis();
        System.out.println("BFS Time Efficiency(Size8): " + (end - start) + " ms\n");
    }

    /**
     * Tests to make sure that the shortest path of the DFS and BFS are equal
     */
    @Test
    public void DFSEqualBFS(){
        Maze maze = new Maze(10);

        maze.dfs();
        maze.printDFS();
        String dfs = maze.printDFSShortestPath();

        maze.bfs();
        maze.printBFS();
        String bfs = maze.printBFSShortestPath();

        assertEquals(dfs,bfs);

    }
    @Test
    public void nonRandomMazeCheck(){
        Maze maze = new Maze(4);
        MazeNode[][] nonRandomNodes = new MazeNode[4][4];
        int size = 4;

        nonRandomNodes[0][0] = new MazeNode(0,0);
        nonRandomNodes[0][0].setVisited();
        nonRandomNodes[0][1] = new MazeNode(0,1);
        nonRandomNodes[0][2] = new MazeNode(0,2);
        nonRandomNodes[0][3] = new MazeNode(0,3);

        nonRandomNodes[1][0] = new MazeNode(1,0);
        nonRandomNodes[1][0].setVisited();
        nonRandomNodes[1][1] = new MazeNode(1,1);
        nonRandomNodes[1][1].setVisited();
        nonRandomNodes[1][2] = new MazeNode(1,2);
        nonRandomNodes[1][3] = new MazeNode(1,3);

        nonRandomNodes[2][0] = new MazeNode(2,0);
        nonRandomNodes[2][1] = new MazeNode(2,1);
        nonRandomNodes[2][1].setVisited();
        nonRandomNodes[2][2] = new MazeNode(2,2);
        nonRandomNodes[2][2].setVisited();
        nonRandomNodes[2][3] = new MazeNode(2,3);

        nonRandomNodes[3][0] = new MazeNode(3,0);
        nonRandomNodes[3][1] = new MazeNode(3,1);
        nonRandomNodes[3][2] = new MazeNode(3,2);
        nonRandomNodes[3][2].setVisited();
        nonRandomNodes[3][3] = new MazeNode(3,3);
        nonRandomNodes[3][3].setVisited();

        nonRandomNodes[0][0].knockDownWall(nonRandomNodes[1][0]);
        nonRandomNodes[0][1].knockDownWall(nonRandomNodes[0][2]);
        nonRandomNodes[0][2].knockDownWall(nonRandomNodes[0][3]);
        nonRandomNodes[1][0].knockDownWall(nonRandomNodes[1][1]);
        nonRandomNodes[0][2].knockDownWall(nonRandomNodes[1][2]);
        nonRandomNodes[0][3].knockDownWall(nonRandomNodes[1][3]);
        nonRandomNodes[1][2].knockDownWall(nonRandomNodes[2][1]);
        nonRandomNodes[1][3].knockDownWall(nonRandomNodes[2][3]);
        nonRandomNodes[2][0].knockDownWall(nonRandomNodes[3][0]);
        nonRandomNodes[2][1].knockDownWall(nonRandomNodes[2][2]);
        nonRandomNodes[3][0].knockDownWall(nonRandomNodes[3][1]);
        nonRandomNodes[3][1].knockDownWall(nonRandomNodes[3][2]);
        nonRandomNodes[3][2].knockDownWall(nonRandomNodes[3][3]);
        nonRandomNodes[3][2].knockDownWall(nonRandomNodes[2][2]);
        nonRandomNodes[2][3].knockDownWall(nonRandomNodes[3][3]);
        nonRandomNodes[1][1].knockDownWall(nonRandomNodes[2][1]);

        for(int row = 0; row < size; row++)
            for(int col = 0; col < size; col++){
                if(row == 0 & col == 0)
                    nonRandomNodes[row][col].hasNorthWall = false;
                if(row == size - 1 & col == size - 1)
                    nonRandomNodes[row][col].hasSouthWall = false;
            }

        maze.setMaze(nonRandomNodes);

        System.out.println("Non-Random Maze: \n" + maze.toString());

        String solution = "+  +--+--+--+"
                + "\n|##|        |"
                + "\n+  +--+  +  +"
                + "\n|## ##|  |  |"
                + "\n+--+  +--+  +"
                + "\n|  |## ##|  |"
                + "\n+  +--+  +  +"
                + "\n|      ## ##|"
                + "\n+--+--+--+  +\n";

        System.out.println("Solution: \n" + solution);


        maze.dfs();
        System.out.println("DFS Solved: \n" + maze.printDFSShortestPath());
        assertEquals(maze.printDFSShortestPath(),solution);
        maze.bfs();
        System.out.println("BFS Solved: \n" + maze.printBFSShortestPath());
        assertEquals(maze.printBFSShortestPath(),solution);


    }
}
