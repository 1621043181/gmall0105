package com.atguigu.gmall.item.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.bean.PmsSkuSaleAttrValue;
import com.atguigu.gmall.service.SkuService;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class itemController {

    @Reference
    SkuService skuService;
    @Reference
    SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId,ModelMap map){

        PmsSkuInfo pmsSkuInfo=skuService.getSkuById(skuId);
        map.put("skuInfo",pmsSkuInfo);
        //销售属性列表
        List<PmsProductSaleAttr> pmsProductSaleAttrs=spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),pmsSkuInfo.getId());
        map.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);

        //查询当前sku的spu的其他sku集合的hash表
        Map<String,String> skuSaleAttrHash=new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfos=skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
       for (PmsSkuInfo skuInfo:pmsSkuInfos){
           String k="";
           String v=skuInfo.getId();
           List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues=skuInfo.getSkuSaleAttrValueList();
           for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue:pmsSkuSaleAttrValues){
               k+=pmsSkuSaleAttrValue.getSaleAttrValueId()+"|";
           }
           skuSaleAttrHash.put(k,v);
       }
        //将sku的销售属性hash表放到页面
        String skuSaleAttrHashJsonStr=JSON.toJSONString(skuSaleAttrHash);
        map.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);
        return "item";
    }


    @RequestMapping("index")
    public String index(ModelMap modelmap){
        List<String> list=new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("循环数据"+i);
        }
        modelmap.put("list",list);
        modelmap.put("hello","hello thymeleaf !!");
        return "index";
    }

}
