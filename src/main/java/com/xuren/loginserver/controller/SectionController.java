package com.xuren.loginserver.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xuren.loginserver.ServerType;
import com.xuren.loginserver.cache.Node;
import com.xuren.loginserver.cache.NodeBusyStatusEnum;
import com.xuren.loginserver.cache.NodeCache;
import com.xuren.loginserver.cache.NodeMaintainStatusEnum;
import com.xuren.loginserver.dto.vo.NodeVO;
import com.xuren.loginserver.dto.vo.RoleVO;
import com.xuren.loginserver.entity.RoleInfo;
import com.xuren.loginserver.exception.ApiException;
import com.xuren.loginserver.exception.StatusCodeEnum;
import com.xuren.loginserver.service.IRoleInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuren
 */

@RestController("section")
public class SectionController {
    @Resource
    private IRoleInfoService roleInfoService;

    @Resource
    private NodeCache nodeCache;

    @GetMapping("/get")
    public List<NodeVO> getSections(@RequestParam String uid) {
        return new ArrayList<>(nodeCache.nodes(ServerType.GAME_SERVER)).stream().map(node -> {
            NodeVO nodeVO = new NodeVO();
            nodeVO.setSec(node.getSec());
            nodeVO.setName("test");
            nodeVO.setBusyStatus(NodeBusyStatusEnum.GOOD);
            nodeVO.setMaintainStatus(NodeMaintainStatusEnum.NORMAL);
            return nodeVO;
        }).collect(Collectors.toList());
    }

    @PostMapping("/choose")
    public NodeVO choose(@RequestParam String sec) {
        var optional = nodeCache.nodes(ServerType.GAME_SERVER).stream().filter(node -> node.getServerId().equals(sec)).map(node -> {
            NodeVO nodeVO = new NodeVO();
            nodeVO.setIp(node.getIp());
            nodeVO.setPort(node.getPort());
            return nodeVO;
        }).findFirst();
        if (optional.isEmpty()) {
            throw new ApiException(StatusCodeEnum.SECTION_NOT_EXISTS, "区服不存在");
        }
        return optional.get();
    }

    @GetMapping("/roles")
    public List<RoleVO> roles(@RequestParam String uid, @RequestParam String section) {
        return roleInfoService.getBaseMapper().selectList(Wrappers.lambdaQuery(RoleInfo.class).eq(RoleInfo::getUid, uid)).stream()
            .map(roleInfo -> {
                RoleVO roleVO = new RoleVO();
                roleVO.setRoleName(roleInfo.getRoleName());
                roleVO.setLevel(roleInfo.getLevel());
                roleVO.setUid(roleInfo.getUid());
                roleVO.setRid(roleInfo.getId());
                return roleVO;
            }).collect(Collectors.toList());
    }
}
