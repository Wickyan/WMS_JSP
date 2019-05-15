package com.briup.bean;

import java.util.List;

public interface GoodsMapper {
	void insertGoods(Goods a);
	List<Goods> selectGoodsByName(String name);
	List<Goods> selectAllGoods();
	List<Goods> selectGoodsById(int id);
	void updateGoods(Goods goods);
	void updateGoodsAll(Goods goods);;
	void deleteGoods(Goods goods);
}

//<update id="updateGoodsAll" parameterType="Goods" > 
//		update goods set name=#{name}, num=#{num},  sort=#{sort},  address=#{address}
//		where goodsid=#{goodsid} 
//</update> 
//<delete id="deleteGoods" parameterType="Goods">
//			 delete from goods where goodsid = #{goodsid}
//</delete>