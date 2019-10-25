package com.lhp.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.lhp.demo.autombg.mapper.PmsBrandMapper;
import com.lhp.demo.autombg.model.PmsBrand;
import com.lhp.demo.autombg.model.PmsBrandExample;
import com.lhp.demo.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PmsBrandServiceImpl
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/24 14:15
 * @Version： V1.0
 **/
@Api(tags ="PmsBrandServiceImpl")
@Service
@Slf4j
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insert(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int deleteBrand(Long id) {

        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        //TODO
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
    @ApiOperation("查找单个信息")
    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

}
