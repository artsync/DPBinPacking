package nl.arthurvlug.dpbinpacking;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Result implements Comparable<Result> {
	private int totalValue;
	private int totalWeight;
	private Set<Item> items;
	
	public Result(Result recursionResult, Item extraItem) {
		this();
		add(extraItem);
		for(Item item : recursionResult.items) {
			add(item);
		}
	}

	public Result() {
		this.items = new HashSet<>();
	}

	public Result(Item... items) {
		this();
		for(Item item : items) {
			add(item);
		}
	}

	private void add(Item item) {
		this.items.add(item);
		this.totalValue += item.getValue();
		this.totalWeight += item.getWeight();
	}

	public int compareTo(Result bestRecursionResult) {
		if(bestRecursionResult == null) {
			return totalValue;
		} else {
			return totalValue - bestRecursionResult.getTotalValue();
		}
	}
	
	@Override
	public String toString() {
		String s = "{Total value=" + totalValue + ". Total weight=" + totalWeight + " : ";
		for(Item item : items) {
			s += "(" + item.getName() + "=" + item.getValue() + ") ";
		}
		s += "}";
		return s;
	}
}
