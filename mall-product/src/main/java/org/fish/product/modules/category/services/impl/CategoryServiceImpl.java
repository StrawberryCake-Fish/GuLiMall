package org.fish.product.modules.category.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.fish.core.exception.CustomException;
import org.fish.product.modules.category.entity.CategoryEntity;
import org.fish.product.modules.category.mapper.CategoryMapper;
import org.fish.product.modules.category.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {
    @Transactional
    @Override
    public void createCate(CategoryEntity entity) {
        LambdaQueryWrapper<CategoryEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (entity.getParentCid() != 0) {
            Long count = baseMapper.selectCount(queryWrapper
                    .eq(CategoryEntity::getParentCid, entity.getParentCid())
                    .eq(CategoryEntity::getIsDeleted, 0));
            if (count == 0) {
                throw new CustomException("ParentCid nonexistent!");
            }
        }
        Long nameCount = baseMapper.selectCount(queryWrapper
                .eq(CategoryEntity::getName, entity.getName())
                .eq(CategoryEntity::getIsDeleted, 0));
        if (nameCount != 0) {
            throw new CustomException("Name duplication!");
        }
        baseMapper.insert(entity);
    }


    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryList = baseMapper.selectList(new LambdaQueryWrapper<CategoryEntity>()
                .eq(CategoryEntity::getShowStatus, 1)
                .eq(CategoryEntity::getIsDeleted, 0));
        return categoryList.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getChildren(menu, categoryList)))
                .sorted(Comparator.comparingInt(cate -> (cate.getSort() == null ? 0 : cate.getSort())))
                .toList();
    }

    public List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(categoryEntity -> Objects.equals(categoryEntity.getParentCid(), root.getCatId()))
                .peek(menu -> menu.setChildren(getChildren(menu, all)))
                .sorted(Comparator.comparingInt(cate -> (cate.getSort() == null ? 0 : cate.getSort())))
                .toList();
    }

    @Transactional
    @Override
    public void delCate(List<Long> cateIds) {
        for (Long id : cateIds) {
            CategoryEntity entity = baseMapper.selectById(id);
            if (entity != null) {
                Long count = baseMapper.selectCount(new LambdaQueryWrapper<CategoryEntity>()
                        .eq(CategoryEntity::getParentCid, entity.getCatId())
                        .eq(CategoryEntity::getIsDeleted, 0));
                if (count > 0) {
                    throw new CustomException(String.format("Id %s the submenu is in use!", id));
                }
            }
        }
        baseMapper.deleteBatchIds(cateIds);
    }
}
