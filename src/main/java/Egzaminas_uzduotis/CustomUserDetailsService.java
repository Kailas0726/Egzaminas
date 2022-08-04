package Egzaminas_uzduotis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        User user = userRepo.findByEmail(username);
        
        if (user == null) {
        	
            throw new UsernameNotFoundException("User not found");
            
        }
        
        //return new CustomUserDetails(user);
        UserDetails userDetail;
        
        if(user.getRoleNames().contains("ADMINISTRATORIUS")){
        	
            userDetail = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
    				.password(user.getPassword())
            		.roles("ADMINISTRATORIUS")
                    .build();
            
        }else{
        	
            userDetail = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
    				.password(user.getPassword())
            		.roles("TEVAS")
                    .build();
        }
        
        return userDetail;
        
    }
 
}
