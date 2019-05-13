package com.briup.bean;

import java.util.List;

public interface OutGoodsMapper {
	void insertOutGoods(Goods a);
	List<Goods> selectOutGoodsByName(String name);
	List<Goods> selectAllOutGoods();
	List<Goods> selectOutGoodsById(int id);
	void updateOutGoods(Goods goods);
}
