package com.ruoyi.web.controller.system;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.McNews;
import com.ruoyi.system.service.IMcNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻Controller
 * 
 * @author ruoyi
 * @date 2021-04-12
 */
@RestController
@RequestMapping("/system/news")
public class McNewsController extends BaseController
{
    @Autowired
    private IMcNewsService mcNewsService;

    /**
     * 查询新闻列表
     */
    @PreAuthorize("@ss.hasPermi('system:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(McNews mcNews)
    {
        startPage();
        List<McNews> list = mcNewsService.selectMcNewsList(mcNews);
        return getDataTable(list);
    }

    /**
     * 导出新闻列表
     */
    @PreAuthorize("@ss.hasPermi('system:news:export')")
    @Log(title = "新闻", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(McNews mcNews)
    {
        List<McNews> list = mcNewsService.selectMcNewsList(mcNews);
        ExcelUtil<McNews> util = new ExcelUtil<McNews>(McNews.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 获取新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(mcNewsService.selectMcNewsById(id));
    }

    /**
     * 新增新闻
     */
    @PreAuthorize("@ss.hasPermi('system:news:add')")
    @Log(title = "新闻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody McNews mcNews)
    {
        return toAjax(mcNewsService.insertMcNews(mcNews));
    }

    /**
     * 修改新闻
     */
    @PreAuthorize("@ss.hasPermi('system:news:edit')")
    @Log(title = "新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody McNews mcNews)
    {
        return toAjax(mcNewsService.updateMcNews(mcNews));
    }

    /**
     * 删除新闻
     */
    @PreAuthorize("@ss.hasPermi('system:news:remove')")
    @Log(title = "新闻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(mcNewsService.deleteMcNewsByIds(ids));
    }
}
