package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.McNews;

/**
 * 新闻Service接口
 * 
 * @author ruoyi
 * @date 2021-04-12
 */
public interface IMcNewsService 
{
    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    public McNews selectMcNewsById(String id);

    /**
     * 查询新闻列表
     * 
     * @param mcNews 新闻
     * @return 新闻集合
     */
    public List<McNews> selectMcNewsList(McNews mcNews);

    /**
     * 新增新闻
     * 
     * @param mcNews 新闻
     * @return 结果
     */
    public int insertMcNews(McNews mcNews);

    /**
     * 修改新闻
     * 
     * @param mcNews 新闻
     * @return 结果
     */
    public int updateMcNews(McNews mcNews);

    /**
     * 批量删除新闻
     * 
     * @param ids 需要删除的新闻ID
     * @return 结果
     */
    public int deleteMcNewsByIds(String[] ids);

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    public int deleteMcNewsById(String id);
}
