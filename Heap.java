import java.util.ArrayList;

public class Heap {
    private ArrayList<City> minHeap;
    private ArrayList<Integer> invHeap;

    public Heap() {
        minHeap = new ArrayList<City>();
        invHeap = new ArrayList<Integer>();
    }

    /**
     * buildHeap(ArrayList<City> cities)
     * Given an ArrayList of Cities, build a min-heap keyed on each City's minCost
     * Time Complexity - O(n)
     *
     * @param cities
     */
    public void buildHeap(ArrayList<City> cities) {
        for(int i = 0; i < cities.size(); i++) {
        	minHeap.add(cities.get(i));				//O(n) copy to array of cities into min heap
        }
        
        int mid = cities.size()/2 - 1; 	//Get the last parent node.
        for(int i = mid; i >= 0; i--) {
        	heapifyDown(i);							//O(n) building of min heap
        }
        
        for(int i = 0; i < minHeap.size(); i++) {
    		invHeap.add(0);							//O(n)
    	}
        
        for(int i = 0; i < minHeap.size(); i++) {		//O(n) creation of inverted list
            int city = minHeap.get(i).getCityName();
            invHeap.set(city, i);
            	
        }
    }

    private void heapifyDown(int i) {
    	int heapSize = minHeap.size();
    	int leftChild = getIndexOfLeftChild(i);
		int rightChild = getIndexOfRightChild(i);
		int indexToSwap = i;
		
    	if(leftChild > heapSize) {
    		return;
    	}
    	if(leftChild < heapSize) {
    		if(minHeap.get(leftChild).getMinCost() < minHeap.get(indexToSwap).getMinCost()) {
    			indexToSwap = leftChild;
    		} else if(minHeap.get(leftChild).getMinCost() == minHeap.get(indexToSwap).getMinCost()) {
    			if(minHeap.get(leftChild).getCityName() < minHeap.get(indexToSwap).getCityName()) {
    				indexToSwap = leftChild;
    			}
    		}
    		
    	}
    	if (rightChild < heapSize) {
    		if(minHeap.get(rightChild).getMinCost() < minHeap.get(indexToSwap).getMinCost()) {
    			indexToSwap = rightChild;
    		} else if(minHeap.get(rightChild).getMinCost() == minHeap.get(indexToSwap).getMinCost()) {
    			if(minHeap.get(rightChild).getCityName() < minHeap.get(indexToSwap).getCityName()) {
    				indexToSwap = rightChild;
    			}
    		}
    	}

    	if(indexToSwap == i) {
    		return;
    	} else {
    		swap(indexToSwap, i);
    		heapifyDown(indexToSwap);
    	}
    	
		
	}
    
    private void heapifyUp(int i) {
		if(i > 0) {
			int parent = getIndexOfParent(i);
			if(minHeap.get(i).getMinCost() < minHeap.get(parent).getMinCost()) {
				swap(i, parent);
				heapifyUp(parent);
			}
			
			if(minHeap.get(i).getMinCost() == minHeap.get(parent).getMinCost()) {
				if(minHeap.get(i).getCityName() < minHeap.get(parent).getCityName()) {
					swap(i, parent);
					heapifyUp(parent);
				}
			}
			
		}
		
	}

    private void swap(int i, int parent) {
		City tempCity = minHeap.get(i);
		City parentCity = minHeap.get(parent);
		minHeap.set(i, minHeap.get(parent));
		minHeap.set(parent, tempCity);
		
		//update inverted list
		if(invHeap.size() != 0) {
			int j = tempCity.getCityName();
			int toSwap = invHeap.get(j);
			int swapWith = invHeap.get(parentCity.getCityName());
			invHeap.set(j, swapWith);
			invHeap.set(parentCity.getCityName(), toSwap);
		}
	}

	private int getIndexOfParent(int i) {
		return (i-1)/2;
	}
    
	private int getIndexOfLeftChild(int i) {
		return 2*i + 1;
	}
	
	private int getIndexOfRightChild(int i) {
		return 2*i + 2;
	}
	
	public int size() {
		return minHeap.size();
	}

	/**
     * insertNode(City in)
     * Insert a City into the heap.
     * Time Complexity - O(log(n))
     *
     * @param in - the City to insert.
     */
    public void insertNode(City in) {
        minHeap.add(in);
        int indexOfLastCity = minHeap.size() - 1;
        if(in.getCityName() > invHeap.size()-1) {
        	invHeap.add(indexOfLastCity);
        } else {
        	invHeap.set(in.getCityName(), indexOfLastCity);
        }
        heapifyUp(indexOfLastCity);
    }

    /**
     * findMin()
     *
     * @return the minimum element of the heap. Must run in constant time.
     */
    public City findMin() {
    	if(minHeap.size() == 0) {
    		return null;
    	} else {
    		return minHeap.get(0);
    	}
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public City extractMin() {
    	if(minHeap.size() == 1) {
    		City minCity = minHeap.remove(0);
    		return minCity;
    	}
    	
        City minCity = findMin();
        int indexOfLastCity = minHeap.size() - 1;
        City lastCity = minHeap.remove(indexOfLastCity);
        minHeap.set(0, lastCity);
        invHeap.set(lastCity.getCityName(), 0);
        heapifyDown(0);
        return minCity;
    }

    /**
     * delete(int index)
     * Deletes an element in the min-heap given an index to delete at.
     * Time Complexity - O(log(n))
     *
     * @param index - the index of the item to be deleted in the min-heap.
     */
    public void delete(int index) {
    	int indexOfLastCity = minHeap.size() - 1;
    	City lastCity = minHeap.remove(indexOfLastCity);
    	if(index == indexOfLastCity) {
    		return;
    	}
    	minHeap.set(index, lastCity);
    	invHeap.set(lastCity.getCityName(), index);
    	int parent = getIndexOfParent(index);
    	
    	if((minHeap.get(index).getMinCost() > minHeap.get(parent).getMinCost()) || index == 0) {
    		heapifyDown(index);
    	} else if(minHeap.get(index).getMinCost() == minHeap.get(parent).getMinCost()) {
    		if(minHeap.get(index).getCityName() > minHeap.get(parent).getCityName()){
    			heapifyDown(index);
    		} else {
    			heapifyUp(index);
    		}
    	} else {
    		heapifyUp(index);
    	}
    	
    	
    }

    /**
     * changeKey(City c, int newCost)
     * Updates and rebalances a heap for City c.
     * Time Complexity - O(log(n))
     *
     * @param c       - the city in the heap that needs to be updated.
     * @param newCost - the new cost of city c in the heap (note that the heap is keyed on the values of minCost)
     */
    public void changeKey(City c, int newCost) {
    	int index = invHeap.get(c.getCityName());
    	City change = minHeap.get(index);
    	change.setMinCost(newCost);
    	minHeap.set(index, change);

    	int parent = getIndexOfParent(index);
    	
    	if((minHeap.get(index).getMinCost() > minHeap.get(parent).getMinCost()) || index == 0) {
    		heapifyDown(index);
    	} else if(minHeap.get(index).getMinCost() == minHeap.get(parent).getMinCost()) {
    		if(minHeap.get(index).getCityName() > minHeap.get(parent).getCityName()){
    			heapifyDown(index);
    		} else {
    			heapifyUp(index);
    		}
    	} else {
    		heapifyUp(index);
    	}
    	
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < minHeap.size(); i++) {
            output += minHeap.get(i).getCityName() + " ";
        }
        return output;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public ArrayList<City> toArrayList() {
        return minHeap;
    }
}
