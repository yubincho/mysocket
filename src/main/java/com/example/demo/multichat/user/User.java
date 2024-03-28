package com.example.demo.multichat.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users") // 데이터베이스에 생성될 테이블 이름을 지정
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email; // 이메일 필드 추가

    @NotBlank
    @Column(unique = true)
    private String nickname; // 별명 필드 추가

    @NotBlank
    private String password;

    private boolean enabled; // 사용자 계정의 활성화 상태
}
