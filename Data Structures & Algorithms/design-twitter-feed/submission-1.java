class Twitter {

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    class User {
        int userId;
        Tweet head;
        Set<Integer> followees;

        User(int id) {
            this.userId = id;
            this.followees = new HashSet<>();
        }
    }

    private Map<Integer, User> map;
    private int timestamp;

    public Twitter() {
        map = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        Tweet tweet = new Tweet(tweetId, timestamp);
        timestamp++;
        tweet.next = user.head;
        user.head = tweet;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                            (a, b) -> Integer.compare(b.time, a.time));
        User user = getUser(userId);
        if (user.head != null) {
            maxHeap.offer(user.head);
        }
        for (int followee : user.followees) {
            user = getUser(followee);
            if (user.head != null) {
                maxHeap.offer(user.head);
            }
        }
        int times = 0;
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && times < 10) {
            Tweet tweet = maxHeap.poll();
            result.add(tweet.id);
            times++;
            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.followees.remove(followeeId);
    }

    private User getUser(int userId) {
        if (map.containsKey(userId)) {
            return map.get(userId);
        }
        User user = new User(userId);
        map.put(userId, user);
        return user;
    }
}
