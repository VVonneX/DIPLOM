package ru.churikov.rest.mocktest.servicetest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.repoitory.FeedRepository;
import ru.churikov.rest.service.FeedService;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {FeedService.class})
class FeedServiceTest {

    //@Autowired
    FeedService service;

   // @MockBean
    FeedRepository repository;

    private static final String ID = "1";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";

   // @AfterEach
    public void tearDown() {
        Mockito.clearInvocations(repository);
    }

   // @Test
    void testGetById() {
        Mockito.when(repository.findOneById(Mockito.any())).thenReturn(Optional.of(getFeed()));
        Feed check = service.getOntById(Long.parseLong(ID));
        assertEquals(check, getFeed());
        Mockito.verify(repository, Mockito.times(1)).findOneById(any());
    }

   // @Test
    void testSave() {
        Mockito.when(repository.save(Mockito.any(Feed.class))).thenReturn(getFeed());
        Feed check = service.save(getFeed());
        assertEquals(check, getFeed());
        Mockito.verify(repository, Mockito.times(1)).save(any());
    }

   // @Test
    void verifyThatGetAllFeedsSuccessiful() {
        Mockito.when(repository.findAll()).thenReturn(getListFeed());
        List<Feed> feeds = service.getAllFeed();
        assertEquals(feeds, getListFeed());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    List<Feed> getListFeed() {
        Feed feed = new Feed();
        feed.setId(Long.parseLong(ID));
        feed.setName(NAME);
        feed.setDescription(DESCRIPTION);
        return Collections.singletonList(feed);
    }

    Feed getFeed() {
        Feed feed = new Feed();
        feed.setId(Long.parseLong(ID));
        feed.setName(NAME);
        feed.setDescription(DESCRIPTION);
        return feed;
    }

}

