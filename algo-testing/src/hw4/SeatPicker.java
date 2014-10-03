package hw4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SeatPicker {

	int count;
	public int[][] pickSeating(int numberOfPeople, List<Pair> friendships) {
		count = numberOfPeople;
		/*
		 * 	init return grid
		 * 	
		 * 	seating of 0 means empty
		 * 	seating of 1 ... numberOfPeople should exist only once. final output should have exactly one of each.
		 * 	each person needs to be sitting in the same row, or in an adjacent row of their friend
		 *  
		 *  one person needs to be in row 0. people in row 0 must have distance compatible property.
		 *  
		 * 
		 */
		int[][] seating = new int[numberOfPeople][numberOfPeople];
		
		/*
		 * create map
		 * 
		 * runs in O( # of friendships )
		 */
		
		HashMap<Integer,Vertex> friendshipMap = new HashMap<Integer,Vertex>();
		for (Pair pair : friendships) {
			addAdjacencyWithPair(friendshipMap, pair); 
		}
		
		Set<Integer> set = friendshipMap.keySet();
		for (Integer i : set) {
			System.out.println(friendshipMap.get(i).toString());
		}
		
		/*
		 * FIGURE OUT THE SEATING
		 */
		while (!friendshipMap.isEmpty()) {
			
			Set<Integer> keys = friendshipMap.keySet();
			Integer key = keys.iterator().next();
			Vertex v = friendshipMap.get(key);
			Queue<Vertex> queue = new LinkedList<Vertex>();
			queue.add(v);
			Vertex endOfLayerOrig = new Vertex(0);
			queue.add(endOfLayerOrig);
			int layer = 0;
			
			Collection<Vertex> values = friendshipMap.values();
			while (!queue.isEmpty()) {
				Vertex vertex = queue.poll();
				if (vertex.id == 0) {
					System.out.println("end layer");
					layer++;
				}
				else {
					System.out.println("row: " + layer);
					insertIntoSeating(layer,vertex.id,seating);
					for (Integer i : vertex.adjacency_list) {
						
						Vertex adjacent = friendshipMap.get(i);
						
						if (adjacent.visited == false) {
							adjacent.visited = true;
							adjacent.layer = layer;
							queue.add(adjacent);
						}
					}
					if (queue.peek().id == 0) {
						Vertex endOfLayer = new Vertex(0);
						endOfLayer.layer = layer;
						queue.add(endOfLayer);
					}
				}
				vertex.visited = true;
			}
			
			keys = friendshipMap.keySet();
			Iterator<Integer> iter = keys.iterator();
			List<Integer> removalList = new LinkedList<Integer>();
			
			while(iter.hasNext()){
				
				int currentId = iter.next();
				Vertex vx = friendshipMap.get(currentId);
				
				if (vx.visited) {
					removalList.add(currentId);
				}
				
			}
			for (Integer i : removalList) {
				friendshipMap.remove(i);
				System.out.println("sze is now :" + friendshipMap.size());
			}
		}
		
		/*
		 * clear the visited vertexes
		 */
		
		return seating;
		
	}

	private void insertIntoSeating(int row, int person, int[][] seating) {
		for (int i = 0; i < seating.length; i ++) {
			if (seating[row][i] == 0) {
				seating[row][i] = person;
				return;
			}
		}
		
	}
	private void addAdjacencyWithPair(HashMap<Integer, Vertex> friendshipMap, Pair pair) {
		if (friendshipMap.containsKey(pair.person)) {
			
			/*
			 * add new adjacency to existing vertex
			 */
			Vertex v = friendshipMap.get(pair.person);
			v.adjacency_list.add(pair.friend);
		} else {
			
			/*
			 * create new vertex and add first adjacency
			 */
			Vertex v = new Vertex(pair.person);
			v.adjacency_list.add(pair.friend);
			friendshipMap.put(pair.person, v);
		}
		
		/*
		 * repeat for the friend
		 */
		if (friendshipMap.containsKey(pair.friend)) {
			
			Vertex v = friendshipMap.get(pair.friend);
			v.adjacency_list.add(pair.person);
		} else {
			
			Vertex v = new Vertex(pair.friend);
			v.adjacency_list.add(pair.person);
			friendshipMap.put(pair.friend, v);
		}
	}
}
