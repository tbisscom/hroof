package com.tbiss.hroof.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
@PrimaryKeyJoinColumn(name="user_id")
public class Admin extends User {



    String previlgies ;



    public Admin( String name, String email, String password) {
        super(name, email, password,UserType.ADMIN);
    }
}
