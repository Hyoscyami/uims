package com.xushifei.uims.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author xushifei
 * @date 2021/3/23
 */
@Getter
@Setter
@ToString
public class User implements UserDetails {
  private static final long serialVersionUID = 1253632851797016790L;
  /** 用户ID */
  private Long id;
  /** 手机号 */
  private String phone;
  /** 用户名 */
  private String name;
  /** 登录账号 */
  private String username;
  /** 密码 */
  private String password;
  /** 是否启用，true启用，false禁用 */
  private Boolean isEnable;
  /** 头像地址 */
  private String avatar;
  /** 权限列表 */
  private Set<GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
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
    return isEnable;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof User) {
      return this.username.equals(((User) obj).username);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.username.hashCode();
  }
}
