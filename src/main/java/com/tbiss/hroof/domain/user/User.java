package com.tbiss.hroof.domain.user;

import com.tbiss.hroof.domain.BaseEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Entity
@Data
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id ;
    private String name ;
    private String username ;
    private String email ;
    private  String password ;

    @Enumerated(EnumType.STRING)
    private UserType type;


    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.OFFLINE ;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();





    public User(String name, String email, String password,UserType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
