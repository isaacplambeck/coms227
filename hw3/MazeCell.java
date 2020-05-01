package hw3;

import java.awt.Point;
import java.util.ArrayList;
import maze.Status;

/**
 * Implementation of MazeCell that has a location in a 2D plane.
 * @author isaacplambeck
 */
public class MazeCell 
{
  /**
   * the maze to which this MazeCell belongs. 
   */
  private Maze owner;
  /**
   * Status of this cell.
   */
  private Status status;
  /**
   * Parent of class.
   */
  private MazeCell parent;
  /**
   * ArrayList for neighbors.
   */
  private ArrayList<MazeCell> neighbors;
  /**
   * Time stamp ~ Time.
   */
  private int time;
  /**
   * Column Variable.
   */
  private int col;
  /**
   * Row Variable.
   */
  private int row;
  /**
   * Point, written as (x,y)
   */
  private Point point;
  
 
  /*
	 * Constructs a maze cell.
	 *  @param int row and int col
	 */
	public MazeCell(int row, int col) {
		status = Status.WALL;
		
		parent = null;
		
		neighbors = new ArrayList<MazeCell>();
		
		time = 0;
		
		this.col = col;
		
		this.row = row;
		
		point = new Point(row, col);
	}
  
 
  /**
   * Adds an observer for changes in this cell's status.
   * @param obs
   */
  public void setOwner(Maze maze)
  {
    owner = maze;    
  }
  
  /*
	 * @return this cell's location as a point, which contains its row and column.
	 */
	public java.awt.Point getLocation(){
		return point;
	}
  

  /*
	 * Adds a neighbor to this cell.
	 * @param MazeCell m
	 */
	public void addNeighbor(MazeCell m) {
		neighbors.add(m);
	}
	
	/*
	 * @return the neighbors of the current cell. 
	 * If a cell has no neighbor, the method must still return an ArrayList, 
	 * which is empty.
	 */
	public java.util.ArrayList<MazeCell> getNeighbors(){
		return neighbors;
	}
	
	  /**
	   * Update the status of this cell and notifies the owner that this current cell's status has changed 
	   * @param cell
	   */
	  public void setStatus(Status s)
	  {
	    status = s;
	    if (owner != null)
	    {
	      owner.updateStatus(this);
	    }
	  }

	  /**
	   * return the status of the current the status
	   * @return status
	   */
	  public Status getStatus()
	  {
	    return status;
	  }
	
	  
	  /*
		 * Returns a string representation of this cell's row and column 
		 * numbers enclosed by a pair of parenthesis, e.g., (3, 4), or (10, 0).
		 */
		public java.lang.String toString(){
			return "(" + row + "," + col + ")"; 
		}
	  
		/*
		 * Gets the parent of this cell. 
		 * This method returns null if the current cell has no parent.
		 * @return parent cell
		 */
		public MazeCell getParent() {
			return parent;
		}
	  
	  
		/*
		 * Sets the parent of this cell with the given parent.
		 * @param parent - The parent cell
		 */
		public void setParent(MazeCell parent) {
			this.parent = parent;
		}
		
		
		/*
		 * Returns the time stamp of this cell
		 * @return time stamp
		 */
		public int getTimeStamp() {
			return time;
		}
		
		
		/*
		 * Sets the time stamp of this cell
		 * @param time - time stamp
		 */
		public void setTimeStamp(int time) {
			this.time = time;
		}
		
		
		/*
		 * Computes the Manhattan distance between this cell and other cell. 
		 * The distance between two points measured along axes at right angles. 
		 * In a plane with p1 at (x1, y1) and p2 at (x2, y2), it is |x1 - x2| + |y1 - y2|.
		 * @param MazeCell other
		 */
		public int distance(MazeCell other) {
			
			int rowDistance = 0;
			
			int colDistance = 0;
			
			if(row >= other.row) {
				rowDistance = row - other.row;
			}
			else {
				rowDistance = other.row - row;
			}
			
			if(col >= other.col) {
				colDistance = col - other.col;
			}
			else {
				colDistance = other.col - col;
			}
			
			
			return rowDistance + colDistance;
			
			
		}
		

		
		
  
}
