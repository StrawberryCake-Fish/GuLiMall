package org.fish.product.services.impl;

import org.fish.product.entity.CategoryEntity;
import org.fish.product.mapper.CategoryMapper;
import org.fish.product.services.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

}
