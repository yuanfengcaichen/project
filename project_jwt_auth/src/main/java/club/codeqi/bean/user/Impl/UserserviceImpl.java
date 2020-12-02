package club.codeqi.bean.user.Impl;

import club.codeqi.bean.user.UserService;
import club.codeqi.bean.user.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserserviceImpl implements UserService {

    @Autowired
    private userMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userMapper.findByName(s);
    }
}
