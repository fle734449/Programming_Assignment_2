import java.util.ArrayList;

public class Heap {
    private ArrayList<City> minHeap;

    public Heap() {
        minHeap = new ArrayList<City>();
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
        	minHeap.add(cities.get(i));
        }
        
        int mid = cities.size()/2 - 1; 	//Get the last parent node.
        for(int i = mid; i >= 0; i--) {
        	heapifyDown(mid);
        }
    }

    private void heapifyDown(int i) {
		// TODO Auto-generated method stub
    	int heapSize = minHeap.size();
    	int leftChild = getIndexOfLeftChild(i);
		int rightChild = getIndexOfRightChild(i);
		int indexToSwap = i;
		
    	if(leftChild > heapSize) {
    		return;
    	} else if(leftChild < heapSize) {
    		if(minHeap.get(leftChild).getMinCost() < minHeap.get(i).getMinCost()) {
    			indexToSwap = leftChild;
    		} else if(minHeap.get(leftChild).getMinCost() == minHeap.get(i).getMinCost()) {
    			if(minHeap.get(leftChild).getCityName() < minHeap.get(i).getCityName()) {
    				indexToSwap = leftChild;
    			}
    		}
    		if(minHeap.get(rightChild).getMinCost() < minHeap.get(indexToSwap).getMinCost()) {
    			indexToSwap = rightChild;
    		} else if(minHeap.get(rightChild).getMinCost() == minHeap.get(indexToSwap).getMinCost()) {
    			if(minHeap.get(rightChild).getCityName() < minHeap.get(indexToSwap).getCityName()) {
    				indexToSwap = rightChild;
    			}
    		}
    	} else if (leftChild == heapSize) {
    		indexToSwap = leftChild;
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
		minHeap.set(i, minHeap.get(parent));
		minHeap.set(parent, tempCity);
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
        heapifyUp(indexOfLastCity);
    }

    /**
     * findMin()
     *
     * @return the minimum element of the heap. Must run in constant time.
     */
    public City findMin() {
    	return minHeap.get(0);
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public City extractMin() {
        City minCity = minHeap.get(0);
        int indexOfLastCity = minHeap.size() - 1;
        City lastCity = minHeap.remove(indexOfLastCity);
        minHeap.set(0, lastCity);
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
        // TODO: implement this method
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
        // TODO: implement this method
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
