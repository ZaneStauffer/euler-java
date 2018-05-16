import java.util.ArrayList;

public class LargestProductInGrid {
	public int getMaxInGrid(int[][] grid, int count){
		return getMax(getGridProducts(grid, count));
	}
	
	private int getMax(ArrayList<Integer> ls){
		int max = Integer.MIN_VALUE;
		for(Integer _iter : ls){
			if(_iter.intValue() > max){
				max = _iter.intValue();
			}
		}
		return max;
	}
	private ArrayList<Integer> getGridProducts(int[][] grid, int count){
		ArrayList<Integer> products = new ArrayList<Integer>();
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++){
				for(Integer _iter : getSingleGridProduct(grid, r, c, count)){
					products.add(_iter);
				}
			}
		}
		return products;
	}
	
	private ArrayList<Integer> getSingleGridProduct(int[][] grid, int row, int col, int count){
		ArrayList<Integer> products = new ArrayList<Integer>(); //We instantiate a new arraylist of integers
		for(int i = 1; i <= 8; i++) products.add(new Integer(1)); //Fill the arraylist with default values of 1 up to 8 (1 for each side)
		//DOWN
		for(int i = 0; i < count; i++){ //For each space up to count...
			if(isInBounds(grid, row + i, col)){
				products.set(0, products.get(0) * grid[row + i][col]); //Multiply this value by each adjacent space
			}
		}
		//UP
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row - i, col)){
				products.set(1, products.get(1) * grid[row - i][col]);
			}
		}
		//RIGHT
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row, col + i)){
				products.set(2, products.get(2) * grid[row][col + i]);
			}
		}
		//LEFT
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row, col - i)){
				products.set(3, products.get(3) * grid[row][col - i]);
			}
		}
		//DOWNRIGHT evil
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row + i, col + i)){
				products.set(4, products.get(4) * grid[row + i][col + i]);
			}
		}
		//DOWNLEFT
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row + i, col - i)){
				products.set(5, products.get(5) * grid[row + i][col - i]);
			}
		}
		//UPLEFT
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row - i, col - i)){
				products.set(6, products.get(6) * grid[row - i][col - i]);
			}
		}
		//UPRIGHT
		for(int i = 0; i < count; i++){
			if(isInBounds(grid, row - i, col + i)){
				products.set(7, products.get(7) * grid[row - i][col + i]);
			}
		}
		return products;
	}
	//Checks if an index is inside the bounds of the array.
	private boolean isInBounds(int[][] grid, int row, int col){
		try{
			int _test = grid[row][col];
		}catch(ArrayIndexOutOfBoundsException e){
			return false;
		}
		return true;
	}
}