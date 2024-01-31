package dev.danvega.props.list;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("social.media")
public record SocialMediaProperties(List<SocialMediaAccount> accounts) {

}
