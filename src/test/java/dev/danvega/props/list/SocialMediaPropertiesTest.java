package dev.danvega.props.list;

import dev.danvega.props.list.SocialMediaAccount;
import dev.danvega.props.list.SocialMediaProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SocialMediaPropertiesTest {

    @Autowired
    SocialMediaProperties properties;

    @Test
    void shouldListAllSocialMediaAccounts() {
        List<SocialMediaAccount> accounts = properties.accounts();
        assertEquals(5, accounts.size());
    }

    @Test
    void shouldGetTwitterAccount() {
        SocialMediaAccount account = properties.accounts().getFirst();
        assertEquals("Twitter", account.name());
        assertEquals("therealdanvega", account.username());
        assertEquals("https://twitter.com/therealdanvega", account.url());
    }

    @Test
    void shouldGetYouTubeAccount() {
        SocialMediaAccount account = properties.accounts().get(1);
        assertEquals("YouTube", account.name());
        assertEquals("danvega", account.username());
        assertEquals("https://www.youtube.com/@danvega", account.url());
    }

    @Test
    void shouldGetGitHubAccount() {
        SocialMediaAccount account = properties.accounts().get(2);
        assertEquals("GitHub", account.name());
        assertEquals("danvega", account.username());
        assertEquals("https://github.com/danvega/", account.url());
    }

    @Test
    void shouldGetLinkedInAccount() {
        SocialMediaAccount account = properties.accounts().get(3);
        assertEquals("LinkedIn", account.name());
        assertEquals("danvega", account.username());
        assertEquals("https://www.linkedin.com/in/danvega/", account.url());
    }

    @Test
    void shouldGetRedditAccount() {
        SocialMediaAccount account = properties.accounts().get(4);
        assertEquals("Reddit", account.name());
        assertEquals("therealdanvega", account.username());
        assertEquals("https://www.reddit.com/user/therealdanvega", account.url());
    }



}