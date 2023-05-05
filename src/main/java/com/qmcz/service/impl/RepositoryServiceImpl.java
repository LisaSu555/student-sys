package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qmcz.base.TransformData;
import com.qmcz.domain.MyRepository;
import com.qmcz.domain.vi.RepositoryVi;
import com.qmcz.service.RepositoryService;
import com.qmcz.mapper.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hp
* @description 针对表【repository】的数据库操作Service实现
* @createDate 2023-05-05 09:30:40
*/
@Service
public class RepositoryServiceImpl extends ServiceImpl<RepositoryMapper, MyRepository>
    implements RepositoryService{

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Override
    public TransformData<MyRepository> getAllPage(RepositoryVi vi) {
        Integer current = vi.getPageStart();
        Integer size = vi.getPageSize();
        Integer total = vi.getPageNumber();
        if(current == null || size == null || total == null){
            current = 1;
            size = 10;
            total = 10;
        }
        Page<MyRepository> repoPage = new Page<>(current,size,total);
        QueryWrapper<MyRepository> qw = new QueryWrapper<>();
        qw.eq("delete_flag","no");
        if(vi.getName() != null && !"".equals(vi.getName())){
            qw.like("name",vi.getName());
        }
        Page<MyRepository> page = repositoryMapper.selectPage(repoPage, qw);
        Integer allCount = Math.toIntExact(repositoryMapper.selectCount(qw));
        List<MyRepository> dataList = page.getRecords();
        TransformData<MyRepository> tr = new TransformData<>();
        if(dataList.size() > 0){
            tr.setCode("0000");
            tr.setMsg("查到了"+allCount);
        }else{
            tr.setCode("0001");
            tr.setMsg("没查到");
        }
        tr.setRows(dataList);
        return tr;
    }

    @Override
    public TransformData<MyRepository> getOneById(RepositoryVi vi) {
        TransformData<MyRepository> tr = new TransformData<MyRepository>();
        MyRepository myRepository = new MyRepository();
        Integer id = vi.getId();
        if(id == null){
            tr.setCode("9999");
            tr.setMsg("没有传入repo的id，无法回显");
        }else {
            myRepository = repositoryMapper.selectById(id);
            tr.setOneData(myRepository);
            tr.setMsg("查询成功");
            tr.setCode("0000");
        }
        return tr;
    }

    @Override
    public TransformData<MyRepository> deleteById(RepositoryVi vi) {
        TransformData<MyRepository> tr = new TransformData<>();
        vi.setDeleteFlag("yes");
        repositoryMapper.updateById(vi);
        tr.setCode("0000");
        tr.setMsg("删除了");
        return tr;
    }

    @Override
    public List<MyRepository> getAllRepos() {
        return repositoryMapper.getAllRepos();
    }
}




