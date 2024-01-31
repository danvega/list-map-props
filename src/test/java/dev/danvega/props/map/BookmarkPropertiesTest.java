package dev.danvega.props.map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookmarkPropertiesTest {

    @Autowired
    BookmarkProperties properties;

    @Test
    void shouldGetAllBookmarks() {
        Map<String, Website> websites = properties.websites();
        assertEquals(4, websites.size());
    }

    @Test
    void shouldGetBookmarkDanVega() {
        Map<String, Website> websites = properties.websites();
        Website website = websites.get("dan-vega");
        assertEquals("https://www.danvega.dev", website.url());
    }

    @Test
    void shouldGetBookmarkSpringAcademy() {
        Map<String, Website> websites = properties.websites();
        Website website = websites.get("spring-academy");
        assertEquals("https://spring.academy", website.url());
    }

    @Test
    void shouldGetBookmarkSpringIO() {
        Map<String, Website> websites = properties.websites();
        Website website = websites.get("spring-io");
        assertEquals("https://spring.io", website.url());
    }

    @Test
    void shouldGetBookmarkSpringOne() {
        Map<String, Website> websites = properties.websites();
        Website website = websites.get("spring-one");
        assertEquals("https://springone.io", website.url());
    }

}