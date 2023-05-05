package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.MyRepository;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qmcz.domain.vi.RepositoryVi;

import java.util.List;

/**
* @author hp
* @description 针对表【repository】的数据库操作Service
* @createDate 2023-05-05 09:30:40
*/
public interface RepositoryService extends IService<MyRepository> {

    TransformData<MyRepository> getAllPage(RepositoryVi vi);

    TransformData<MyRepository> getOneById(RepositoryVi vi);

    TransformData<MyRepository> deleteById(RepositoryVi vi);

    List<MyRepository> getAllRepos();
}
