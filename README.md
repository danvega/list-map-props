# Configuration Properties Lists & Maps

This is a simple Spring Boot application that demonstrates how to use Configuration Properties with Lists and Maps.

## Lists

In this section you will see how to use Configuration Properties with Lists. The first thing you need to do is to 
create a class that will represent Social Media Properties. This could contain other properties but for now it will
just contain a list of Social Media Accounts. 

The first example will use a traditional class and the second example will use a record.

```java
@ConfigurationProperties("social.media")
public class SocialMediaProperties {

    private List<SocialMediaAccount> accounts = new ArrayList<>();

    public List<SocialMediaAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<SocialMediaAccount> accounts) {
        this.accounts = accounts;
    }

}
```

```java
@ConfigurationProperties("social.media")
public record SocialMediaProperties(List<SocialMediaAccount> accounts) {

}
```

You will need to update the main Application class to enable the Configuration Properties:

```java
@EnableConfigurationProperties(SocialMediaProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

If you are using `application.properties` you would define your properties like this:

```properties
social.media.accounts[0].name=Twitter
social.media.accounts[0].username=therealdanvega
social.media.accounts[0].url=https://twitter.com/therealdanvega
social.media.accounts[1].name=YouTube
social.media.accounts[1].username=danvega
social.media.accounts[1].url=https://www.youtube.com/@danvega
social.media.accounts[2].name=GitHub
social.media.accounts[2].username=danvega
social.media.accounts[2].url=https://github.com/danvega/
social.media.accounts[3].name=LinkedIn
social.media.accounts[3].username=danvega
social.media.accounts[3].url=https://www.linkedin.com/in/danvega/
social.media.accounts[4].name=Reddit
social.media.accounts[4].username=therealdanvega
social.media.accounts[4].url=https://www.reddit.com/user/therealdanvega
```

If you are using `application.yaml` you would define your properties like this:

```yaml
social:
  media:
    accounts:
      -   name: Twitter
          url: https://twitter.com/therealdanvega
          username: therealdanvega
      -   name: YouTube
          url: https://www.youtube.com/@danvega
          username: danvega
      -   name: GitHub
          url: https://github.com/danvega/
          username: danvega
      -   name: LinkedIn
          url: https://www.linkedin.com/in/danvega/
          username: danvega
      -   name: Reddit
          url: https://www.reddit.com/user/therealdanvega
          username: therealdanvega
```


## Maps

In this section you will see how to use Configuration Properties with Maps. The first thing you need to do is to 
create a Record that represents Bookmarks. This will contain a Map of Websites where the key is the name of the website

```java
@ConfigurationProperties("bookmarks")
public record BookmarkProperties(Map<String, Website> websites) {
}

```

You will need to update the main Application class to enable the Configuration Properties: 

```java

@EnableConfigurationProperties({SocialMediaProperties.class, BookmarkProperties.class})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
```

If you are using `application.properties` you would define your properties like this:

```properties
bookmarks.websites.dan-vega=https://www.danvega.dev
bookmarks.websites.spring-academy=https://spring.academy
bookmarks.websites.spring-io=https://spring.io
bookmarks.websites.spring-one=https://springone.io
```

If you are using `application.yaml` you would define your properties like this:

```yaml
bookmarks:
  websites:
    dan-vega: https://www.danvega.dev
    spring-academy: https://springacademy.dev
    spring-io: https://springio.dev
    spring-one: https://springone.io
```