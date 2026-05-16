package com.kranium.project.gearapi.modules.identity.domain;

import com.kranium.project.gearapi.modules.identity.inheritanceClass.domain.Entidade;
import com.kranium.project.gearapi.modules.users.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(
        name = "tb_refresh_token",
        indexes = {
                @Index(name = "idx_refresh_token", columnList = "token")
        }
)
public class RefreshToken extends Entidade {

    @Column(nullable = false, unique = true, length = 512)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(nullable = false)
    private Instant issuedAt;

    @Column(nullable = false)
    private Instant expiresAt;

    @Column(nullable = false)
    private boolean revoked = false;

    public boolean isExpired() {
        return Instant.now().isAfter(this.expiresAt);
    }

    public boolean isValid() {
        return !revoked &&
                Instant.now().isBefore(this.expiresAt);
    }
}
