package nl.arthurvlug.dpbinpacking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Item {
	private String name;
	private int weight;
	private int value;
}
