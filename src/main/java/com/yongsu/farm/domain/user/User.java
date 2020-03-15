package com.yongsu.farm.domain.user;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-03-15
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private UserType userType;

    private String password;

    private String cellPhoneNumber;

    private String email;

    private OffsetDateTime lastLogInAt;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<UserAddress> userAddressList = new ArrayList<>();

    @Builder
    public User(String name, UserType userType, String password, String cellPhoneNumber, String email, OffsetDateTime lastLogInAt, OffsetDateTime createdAt) {
        this.name = name;
        this.userType = userType;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.lastLogInAt = lastLogInAt;
        this.createdAt = createdAt;
    }
}
