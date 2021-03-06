package com.sanger.sprintel.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6189678452627071360L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	@JsonIgnore
	private String password;

	private String avatar;

	private String fullName;

	@Column(unique = true)
	private String email;

	private String image;

	private boolean enabled;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;

	@CreatedDate
	private LocalDateTime createdAt;

	@Builder.Default
	private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.name())).collect(Collectors.toList());
	}

	/**
	 * No vamos a gestionar la expiraci??n de cuentas. De hacerse, se tendr??a que dar
	 * cuerpo a este m??todo
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * No vamos a gestionar el bloqueo de cuentas. De hacerse, se tendr??a que dar
	 * cuerpo a este m??todo
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * No vamos a gestionar la expiraci??n de cuentas. De hacerse, se tendr??a que dar
	 * cuerpo a este m??todo
	 */

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
