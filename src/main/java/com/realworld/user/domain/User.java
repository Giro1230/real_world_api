package com.realworld.user.domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("User Name")
    @Column(length = 20, nullable = false)
    private String name;

    @Comment("유저 이메일")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Comment("비밀번호")
    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 6, message = "비밀번호는 최소 6자 이상이어야 합니다.")
    @Column(nullable = false)
    private String password;

    @Comment("자기소개")
    private String bio;

    @Comment("이미지")
    private String image;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
