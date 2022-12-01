package com.tienda.services;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Sebusca el usuario ne la tabla usuario
        Usuario usuario =usuarioDao.findByUsername(username);
        if(usuario==null) {//Usuario no existe en base datos
            throw new UsernameNotFoundException (username);
        }
        //Se cargan los roles del usuario en un arreglo especial de tipo GrantedAuthority
        var roles= new ArrayList<GrantedAuthority>();
        
        // Se recorre el ArrayList del objeto usuario y se transforma en GrantedAuthority cada rol
        for(Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        // Se retorna in UserDetail con la info recuperada
        return new User(usuario.getUsername(), usuario.getPassword(),roles);
    }
    
}
