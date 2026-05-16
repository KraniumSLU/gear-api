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

@Getter
@Setter
@Entity
@Table(name = "tb_session")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Session extends Entidade {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private String userAgent;

    @Column(nullable = false)
    private String device;

    @Column(nullable = false)
    private Instant startedAt;

    @Column
    private Instant lastAccess;

    @Column(nullable = false)
    private boolean active = true;
}
