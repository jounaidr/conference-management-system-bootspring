package com.lukas.ramonas.cms.DAO;

import com.lukas.ramonas.cms.Principal.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.lukas.ramonas.cms.Model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);

        //List<SimpleGrantedAuthority> grantedAuthorities = user.getAuthority().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }

    

}
