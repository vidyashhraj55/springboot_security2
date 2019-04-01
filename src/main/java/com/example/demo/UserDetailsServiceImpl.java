package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//    	UserDetailsImpl userDetailsImpl=null;
//    	try
//    	{
    	System.out.println("input="+userName);
    	
        Optional<User> optionalUser = usersRepository.findByuserName(userName);
      //  System.out.println("optionalUser="+optionalUser);
      //  System.out.println("optionalUser="+optionalUser.get());
//        UserDetailsImpl userDetailsImpl = Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
//        .map(UserDetailsImpl::new).get();
        User user = optionalUser.get();
        System.out.println("optionalUser="+optionalUser.get());
        UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);
        System.out.println(userDetailsImpl+"@"+userDetailsImpl.getClass().getName());
//    	}
//    	catch(Throwable e)
//    	{
//    		e.printStackTrace();
//    		
//    	}
        return userDetailsImpl;
    }
}
