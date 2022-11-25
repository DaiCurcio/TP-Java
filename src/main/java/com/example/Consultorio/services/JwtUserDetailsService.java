package com.example.Consultorio.services;

import com.freetube.JavaFreetube.Models.Roles;
import com.freetube.JavaFreetube.Models.Usuarios;
import com.freetube.JavaFreetube.Repositories.RolesRepo;
import com.freetube.JavaFreetube.Repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	public UsuariosRepo repo;
	@Autowired
	public RolesRepo roles;
	public JwtUserDetailsService(UsuariosRepo repo) {
		this.repo = repo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios us =  repo.findAll().stream().filter(x -> x.usuario.contains(username)).findFirst().get();
		List<Roles> rol = roles.findAll();
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		rol.forEach(role ->
				{
					if(role.id_rol == us.permiso)
					{
						authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre_rol()));
					}
				}
		);

		if (us.usuario.equals(username)) {
			return new User(us.usuario, us.pass,
					authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}


}