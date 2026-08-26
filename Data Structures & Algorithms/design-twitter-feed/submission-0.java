class Twitter {

    private int time = 0;

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
        followMap.putIfAbsent(userId, new HashSet<>());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = 
            new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        if (tweetMap.containsKey(userId)) {
            maxHeap.offer(tweetMap.get(userId));
        }

        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())) {
            if (tweetMap.containsKey(followeeId)) {
                maxHeap.offer(tweetMap.get(followeeId));
            }
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet tweet = maxHeap.poll();
            result.add(tweet.tweetId);
            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId); 
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId)
                    .remove(followeeId);
        }
    }
}
