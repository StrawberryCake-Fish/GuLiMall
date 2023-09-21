package org.fish.product.services.impl;

import org.fish.product.entity.BrandEntity;
import org.fish.product.mapper.BrandMapper;
import org.fish.product.services.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌 服务实现类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

}
