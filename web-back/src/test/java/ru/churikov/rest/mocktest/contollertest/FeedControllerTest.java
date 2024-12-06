package ru.churikov.rest.mocktest.contollertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.churikov.rest.controllers.FeedController;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.models.FeedDto;
import ru.churikov.rest.service.FeedService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {FeedController.class})
@WebMvcTest
@WithMockUser
public class FeedControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public FeedService feedService;

    private static final String ID = "1";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String URL = "/api/feed";

    public FeedControllerTest() {
    }

    @Test
    void getAllFeed() throws Exception {
        Mockito.when(feedService.getAllFeed()).thenReturn(getListFeed());

        mockMvc.perform(get(URL + "/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", equalTo(NAME)))
                .andReturn();
    }
    // проверка метода getAllFeed(вместо обычного feedService используется мок сервис, который иметирует поведение фид сервиса,
    // поведение которого мы точно контролируем, и ожидаем возвращение заранее изместного результата
    // в нашем случаем, возвращает значения в конфигурации)

    @Test
    void getOneByFeed() throws Exception {
        Mockito.when(feedService.getOntById(Mockito.any())).thenReturn(getFeed());

        mockMvc.perform(get(URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andReturn();
    }

    /*  @Test
      void createOrEdit() throws Exception {
          Mockito.when(feedService.save(Mockito.any(Feed.class))).thenReturn(getFeed());

          mockMvc.perform(post(URL).content(readFileAsString("feed/saveFeed.json")))
                  .andExpect(status().isOk())
                  .andExpect(jsonPath("$.name", equalTo(NAME)))
                  .andReturn();
      }
  */
    public static String readFileAsString(String filename) throws IOException {
        File file = new File("src/test/resources/" + filename);
        Path path = file.toPath();
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes, StandardCharsets.UTF_8);
    }

    FeedDto getFeedDto() {
        FeedDto dto = new FeedDto();
        dto.setId(Long.parseLong(ID));
        dto.setName(NAME);
        dto.setDescription(DESCRIPTION);
        return dto;
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
