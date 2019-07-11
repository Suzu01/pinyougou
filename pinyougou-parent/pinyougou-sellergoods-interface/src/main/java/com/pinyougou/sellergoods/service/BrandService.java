package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查找所有品牌
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 分页查询品牌
     * @param pageNum  当前页
     * @param pageSize 每页条数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 添加品牌
     * @param brand
     */
    public void add(TbBrand brand);

    /**
     * 根据id查找品牌
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 修改品牌信息
     * @param brand
     */
    public void update(TbBrand brand);

    /**
     * 批量删除品牌
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 条件查询
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand brand,int pageNum, int pageSize);

    List<Map> selectOptionList();
}
