package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsSkuInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    PmsSkuInfo getSkuById(String skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

    List<PmsSkuInfo> getAllSku(String catalog3Id);
}
