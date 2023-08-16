package com.xuren.loginserver.service.impl;

import com.xuren.loginserver.entity.AccountInfo;
import com.xuren.loginserver.mapper.AccountInfoMapper;
import com.xuren.loginserver.service.IAccountInfoService;
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
public class AccountInfoServiceImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements IAccountInfoService {

}
