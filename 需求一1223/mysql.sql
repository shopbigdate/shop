CREATE TABLE `goods_order_count` (
  `goods_id` int(11) default NULL,
  `goods_name` varchar(20) default NULL,
  `goods_category` varchar(20) default NULL,
  `sum` int(11) default NULL,
  `day` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;