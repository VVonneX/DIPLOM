package test;

import model.Feed;
import org.junit.After;
import org.junit.Before;
import step.FeedSteps;

public class BaseConf {

    public FeedSteps steps = new FeedSteps();
    public Feed feed;

    @Before
    public void startFeed() {
        feed = new Feed(1L, "asdaa", "fffff");
    }

    @After
    public void deleteAuthFeedPositiveTest() {
       steps.deleteFeed(1L);
    }
}
