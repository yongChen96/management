package com.example.management.vo;

import com.example.management.entity.Role;
import com.example.management.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: UserInfoVO
 * @Description: 用户信息VO
 * @Author: yongchen
 * @Date: 2020/9/1 16:02
 **/
@Data
public class UserInfoVO implements UserDetails,Serializable {
    private static final long serialVersionUID = 6035555496498402805L;

    private User user;
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return roles.stream()
                .filter(role -> role.getRoleCode() != null)
                .map(role -> new SimpleGrantedAuthority(role.getRoleCode()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
        return user.getAccStatus().equals("0");
    }
}
