package pl.markowski.konrad.app.artgallery.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.markowski.konrad.app.artgallery.repository.AuthorRepository;
import pl.markowski.konrad.app.artgallery.repository.entity.AuthorEntity;

@Service
public class GalleryUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthorRepository authorRepository;

//    public GalleryUserDetailsService(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthorEntity user = authorRepository.findByName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(user.getName())
                .password(user.getPassword())
                .roles("USER")
                .build();
        return userDetails;
    }
}
