package com.htt.controller;

import com.htt.dao.NewsDao;
import com.htt.po.News;
import com.htt.result.Result;
import com.htt.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：www
 * @date ：Created in 20-7-14 下午3:23
 * @description：
 * @modified By：
 * @version:
 */
@Api(value = "/swagger", tags = "我的接口模块news")
@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsDao newsDao;
    @GetMapping("selectAll")
    public Result selectAll(long userReceiveid, String newsZt, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        Specification<News> spec = new Specification<News>() {
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(!StringUtils.isEmpty(userReceiveid)) {
                    list.add(cb.equal(root.get("userReceiveid"), userReceiveid));
                }
                if(!StringUtils.isEmpty(newsZt)) {
                    list.add(cb.equal(root.get("newsZt"), newsZt));
                }
                //此时条件之间是没有任何关系的。
                Predicate[] arr = new Predicate[list.size()];
                return cb.and(list.toArray(arr));
            }
        };
        //Sort sort = Sort.by(Sort.Direction.DESC, "NewsTime");;
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "newsZt");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "newsTime");
        orders.add(order);
        orders.add(order2);
        Sort sort1 = Sort.by(orders);
        PageRequest pageRequest = PageRequest.of(page-1,size,sort1);
        Page<News> news = newsDao.findAll(spec,pageRequest);
        return ResultUtil.success(news);
    }
}
