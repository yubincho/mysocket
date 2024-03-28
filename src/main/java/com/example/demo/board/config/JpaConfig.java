package com.example.demo.board.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;


@EnableJpaAuditing
@Configuration
public class JpaConfig {

    // AuditorAware 구현체를 빈으로 등록합니다.
    // 현재 보안 컨텍스트의 사용자 이름(또는 다른 식별자)을 생성자와 수정자로 자동 할당하는 데 사용됩니다.
    @Bean
    public AuditorAware<String> auditorAware() {
        // 여기서는 예시로 "system"을 기본 사용자로 사용합니다.
        // 실제 애플리케이션에서는 Spring Security 컨텍스트에서 인증된 사용자 이름을 반환해야 합니다.
        return () -> Optional.of("yubin"); // 현재 인증된 사용자를 반환하는 로직으로 대체해야 합니다.
    }
}
