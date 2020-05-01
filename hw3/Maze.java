package hw3;

import maze.MazeObserver;
import maze.Status;

/**
 * A Maze consists of MazeCells arranged in a 2D grid.
 * @author isaacplambeck
 */
public class Maze
{
 
  
  /**
   * Observer to be notified in case of changes to cells
   * in this maze.
   */
  private MazeObserver observer;
  /**
   * Row Variable.
   */
  private int row;
  /**
   * Column Variable.
   */
  private int col;
  /**
   * Start of the Maze.
   */
  private MazeCell start;
  /**
   * Goal of the Maze.
   */
  private MazeCell goal;
  
  private MazeCell[][] maze;
  
  /*
	 * Constructs a maze based on a 2D grid.
	 */
	public Maze(java.lang.String[] rows) {
		
		row = rows.length;
		
		col = rows[0].length();
		
		maze = new MazeCell[row][col];
		
		//top of cell.
		boolean top = true;
		
		//bottom of cell.
		boolean bottom = true;
		
		//right of cell.
		boolean right = true;
		
		//left of cell.
		boolean left = true;
		
		
		
		
		for(int x = 0; x<rows.length; x++) {
			
			for(int y = 0; y<rows[0].length(); y++) {
				
				
			//if # is in row
				if(rows[x].charAt(y) == '#') {
					
					//new Maze with incrementing rows and columns.
					maze[x][y] = new MazeCell(x, y);
					
					//starts with Status WALL.
					maze[x][y].setStatus(Status.WALL);
					
					//set this maze as owner.
					maze[x][y].setOwner(this);
				}
				
				else if(rows[x].charAt(y) == 'S') {
					//S represents START
					start = new MazeCell(x, y);
					
					start.setStatus(Status.UNVISITED);
					
					start.setOwner(this);
					
					maze[x][y] = start;
				}
				//$ represents GOAL
				else if(rows[x].charAt(y) == '$') {
					goal = new MazeCell(x, y);
					
					goal.setStatus(Status.GOAL);
					
					goal.setOwner(this);
					
					maze[x][y] = goal;
					
				}
				
				//basic maze.
				else {
					maze[x][y] = new MazeCell(x, y);
					
					maze[x][y].setStatus(Status.UNVISITED);
					
					maze[x][y].setOwner(this);				
					
				}
		
			}
	
		}
		
		
		for(int x = 0; x < maze.length; x++) {
			
			
			  for(int y = 0; y < maze[0].length; y++) {
				  
				  
				  if(maze[x][y].getStatus() != Status.WALL) {
					  //no wall left
					  if(y == 0) {
						  
						  left = false;
					  }
					//no wall right
					  if(y == maze[0].length-1) {
						  
						  right = false;
					  }
					//no wall bottom
					  if(x == maze.length-1) {
						  
						  bottom = false;
					  }
					  
					  if(top == true) {
						  
						  if(maze[x-1][y].getStatus() != Status.WALL) {
							  
							  maze[x][y].addNeighbor(maze[x-1][y]);
						  }
					  }
					  
					  if(left == true) {
						  
						  if(maze[x][y-1].getStatus() != Status.WALL) {
							  
							  maze[x][y].addNeighbor(maze[x][y-1]);
						  }
					  }
					  
					  if(bottom == true) {
						  
						  if(maze[x+1][y].getStatus() != Status.WALL) {
							  
							  maze[x][y].addNeighbor(maze[x+1][y]);
						  }
					  }
					  
					  if(right == true) {
						  
						  if(maze[x][y+1].getStatus() != Status.WALL) {
							  
							  maze[x][y].addNeighbor(maze[x][y+1]);
						  }

					  
		
		
		
					  }
				  }
			  }
		}
	}
	
	/*
	 * Returns the cell at the given position.
	 * @return the cell called
	 * @param int row and int col
	 */
	public MazeCell getCell(int row, int col) {
		return maze[row][col];
	}
	
	
	/*
	 * @return the number of rows in this maze.
	 */
	public int getRows() {
		return row;
	}
	
	
	/*
	 * @return the number of columns in this maze.
	 * 
	 */
	public int getColumns() {
		return col;
	}
	
	
	/*
	 * @return the start cell for this maze.
	 */
	public MazeCell getStart() {
		return start;
	}
	
	/*
	 * @return the goal cell for this maze.
	 */
	public MazeCell getGoal() {
		return goal;
	}
  

  
  
  /**
   * Sets the observer for the cells of this maze.
   * @param obs
   */
  public void setObserver(MazeObserver obs)
  {
    observer = obs;
  }

  public void updateStatus(MazeCell cell)
  {
    if (observer != null)
    {
      observer.updateStatus(cell);
    }
  }

}
