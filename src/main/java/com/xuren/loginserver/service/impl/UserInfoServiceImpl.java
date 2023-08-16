package com.xuren.loginserver.service.impl;

import com.xuren.loginserver.entity.UserInfo;
import com.xuren.loginserver.mapper.UserInfoMapper;
import com.xuren.loginserver.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuren
 * @since 2023-08-15
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
