class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx] = pq.poll()[0];
            idx++;
        }

        return result;
    }
}
