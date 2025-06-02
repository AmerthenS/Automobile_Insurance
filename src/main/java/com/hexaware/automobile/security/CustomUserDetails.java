/*
 * CustomUserDetails.java
 * 
 * Implements Spring Security's UserDetails to provide authentication information 
 * for both User and Officer entities. Encapsulates user ID, email, password, 
 * role, and authorities for security context use.
 * 
 * Author: Amerthen
 * Date: 2025-06-02
 */
package com.hexaware.automobile.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String password;
    private String role;

    public CustomUserDetails(Long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    
    public static CustomUserDetails fromUser(com.hexaware.automobile.entities.User user) {
        return new CustomUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name()  
        );
    }

    
    public static CustomUserDetails fromOfficer(com.hexaware.automobile.entities.Officer officer) {
        return new CustomUserDetails(
                officer.getId(),
                officer.getEmail(),
                officer.getPassword(),
                officer.getRole().name()  
        );
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
