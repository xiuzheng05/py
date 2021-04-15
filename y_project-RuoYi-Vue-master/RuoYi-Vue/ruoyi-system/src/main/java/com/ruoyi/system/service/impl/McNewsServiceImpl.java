package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.McNewsMapper;
import com.ruoyi.system.domain.McNews;
import com.ruoyi.system.service.IMcNewsService;

/**
 * 新闻Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-12
 */
@Service
public class McNewsServiceImpl implements IMcNewsService 
{
    @Autowired
    private McNewsMapper mcNewsMapper;

    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    @Override
    public McNews selectMcNewsById(String id)
    {
        return mcNewsMapper.selectMcNewsById(id);
    }

    /**
     * 查询新闻列表
     * 
     * @param mcNews 新闻
     * @return 新闻
     */
    @Override
    public List<McNews> selectMcNewsList(McNews mcNews)
    {
        return mcNewsMapper.selectMcNewsList(mcNews);
    }

    /**
     * 新增新闻
     * 
     * @param mcNews 新闻
     * @return 结果
     */
    @Override
    public int insertMcNews(McNews mcNews)
    {
        mcNews.setCreateTime(DateUtils.getNowDate());
        return mcNewsMapper.insertMcNews(mcNews);
    }

    /**
     * 修改新闻
     * 
     * @param mcNews 新闻
     * @return 结果
     */
    @Override
    public int updateMcNews(McNews mcNews)
    {
        return mcNewsMapper.updateMcNews(mcNews);
    }

    /**
     * 批量删除新闻
     * 
     * @param ids 需要删除的新闻ID
     * @return 结果
     */
    @Override
    public int deleteMcNewsByIds(String[] ids)
    {
        return mcNewsMapper.deleteMcNewsByIds(ids);
    }

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    @Override
    public int deleteMcNewsById(String id)
    {
        return mcNewsMapper.deleteMcNewsById(id);
    }
}
