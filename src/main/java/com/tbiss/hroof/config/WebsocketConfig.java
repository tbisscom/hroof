package com.tbiss.hroof.config;

import com.tbiss.hroof.config.handleshake.JwtHandshakeHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import static com.tbiss.hroof.controller.v2.Constants.SECURED_CHAT_HISTORY;
import static com.tbiss.hroof.controller.v2.Constants.SECURED_CHAT_SPECIFIC_USER;


@Configuration()
@EnableWebSocketMessageBroker()
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(SECURED_CHAT_HISTORY, SECURED_CHAT_SPECIFIC_USER);
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/secured/user");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/secured/competitions")
                .setHandshakeHandler(new JwtHandshakeHandler())
                .setAllowedOrigins("*").withSockJS() ;
    }
}
