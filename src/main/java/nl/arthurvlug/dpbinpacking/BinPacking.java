package nl.arthurvlug.dpbinpacking;

import java.util.List;


public class BinPacking {
	private final List<Item> items;
	private int maxWeight;

	public BinPacking(int maxWeight, List<Item> items) {
		this.maxWeight = maxWeight;
		this.items = items;
	}
	
	Result packBins() {
		for(int i = 0; i < items.size(); i++) {
			packBins(i, 0, 0);
		}
		
		return packBins(items.size(), 0, 0);
	}

	private Result packBins(int howMany, int chosenItems, int totalWeight) {
		if(howMany == 0) {
			return new Result();
		}
		
		Result bestRecursionResult = new Result();
		for(int itemId = 0; itemId < items.size(); itemId++) {
			Item currentItem = items.get(itemId);
			if(isAvailable(itemId, chosenItems) && totalWeight + currentItem.getWeight() <= maxWeight) {
				chosenItems = chooseItem(itemId, chosenItems);
				
				// Select the current item and go in recursion.
				// - The total weight is increased by the item's weight
				// - We can't choose the item again
				// - the total Value is added
				Result recursion = recursion(howMany-1, chosenItems, totalWeight + currentItem.getWeight());
				Result recursionCombined = new Result(recursion, currentItem);
				if(recursionCombined.compareTo(bestRecursionResult) > 0) {
					bestRecursionResult = recursionCombined;
				}
			}
		}
		return bestRecursionResult;
	}

	private Result recursion(int howMany, int chosenItems, int totalWeight) {
		return packBins(howMany, chosenItems, totalWeight);
	}

	int chooseItem(int itemId, int chosenItems) {
		chosenItems |= (1 << itemId);
		return chosenItems;
	}

	boolean isAvailable(int itemId, int chosenItems) {
		int availableItems = ~chosenItems;
		boolean isAvailable = (availableItems & (1 << itemId)) != 0;
		return isAvailable;
	}
}
