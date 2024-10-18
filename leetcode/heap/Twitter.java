package heap;

import java.util.*;

public class Twitter {
    List<List<Integer>> followList;
    List<List<Integer>> allTweets;
    public Twitter() {
        followList = new ArrayList<>();
        allTweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        allTweets.add(userId, new ArrayList<>(tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // List<Integer> tweets = new ArrayList<>();
        List<Integer> followers = followList.get(userId);
        PriorityQueue<Integer> recentTweet = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < followers.size(); i++) {
            
        }
    }
    
    public void follow(int followerId, int followeeId) {
        followList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followList.get(followerId).remove(followeeId);
    }
}

