package roomservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roomservice.datasource.PlayerRepository;
import roomservice.entity.Player;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                                        .orElseThrow(() ->
                                                     new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                                                    );

        return UserPrincipal.create(player);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(
        () -> new UsernameNotFoundException("Player not found with id : " + id));

        return UserPrincipal.create(player);
    }
}

