package com.web.system.service;

import com.web.system.entity.User;
import com.web.vo.IndexVO;

import java.util.List;


public interface IndexService {

    public List<IndexVO> getIndex(User user);
}
