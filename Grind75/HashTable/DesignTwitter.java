package HashTable;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can
 * post tweets,
 * follow/unfollow another user and
 * is able to see the 10 most recent tweets in the user's news feed.
 * <p>
 * Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId):
 * Compose a new tweet.
 * <p>
 * getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * <p>
 * follow(followerId, followeeId):
 * Follower follows a followee.
 * <p>
 * unfollow(followerId, followeeId):
 * Follower unfollows a followee.
 * <p>
 * Example:
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class DesignTwitter {
    private int timestamp;
    private Map<Integer, User> usersMap;

    public DesignTwitter() {
        timestamp = 0;
        usersMap = new HashMap<>();
    }

    public void post(int userId, int tweetId) {
        if (!usersMap.containsKey(userId)) usersMap.put(userId, new User(userId));
        usersMap.get(userId).post(tweetId);
    }

    public void follow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followerId)) usersMap.put(followerId, new User(followerId));
        if (!usersMap.containsKey(followeeId)) usersMap.put(followeeId, new User(followerId));
        usersMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followerId) || followerId == followeeId) return;
        usersMap.get(followerId).unfollow(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!usersMap.containsKey(userId)) return res;
        Set<Integer> follows = usersMap.get(userId).followed;
        Queue<Tweet> queue = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int follow : follows) {
            Tweet t = usersMap.get(follow).tweetHead;
            if (t != null) queue.offer(t);

        }
        int n = 0;
        while (!queue.isEmpty() && n < 10) {
            Tweet t = queue.poll();
            res.add(t.tweetId);
            n++;
            if (t.next != null) queue.add(t.next);
        }
        return res;
    }

    private class User {
        int userId;

        Set<Integer> followed;
        Tweet tweetHead;

        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            follow(userId); // first follow itself
            tweetHead = null;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            followed.remove(userId);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    private class Tweet {
        int tweetId;
        Tweet next;
        int time;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            time = timestamp++;
            next = null;
        }
    }
}
