import java.util.LinkedList;

class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int currentTime = 0;
		int totalWeight = 0;
		LinkedList<Integer[]> onBridge = new LinkedList<>();

		for (int truckWeight : truck_weights) {
			currentTime++;

			while ((!onBridge.isEmpty() && onBridge.getFirst()[0] <= currentTime) || totalWeight + truckWeight > weight) {
				currentTime = onBridge.getFirst()[0];
				totalWeight -= onBridge.getFirst()[1];
				onBridge.removeFirst();
			}

			totalWeight += truckWeight;
			onBridge.add(new Integer[]{currentTime + bridge_length, truckWeight});
		}

		return onBridge.getLast()[0];
	}
}