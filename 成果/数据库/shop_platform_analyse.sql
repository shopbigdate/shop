/*
Navicat MySQL Data Transfer

Source Server         : Linux
Source Server Version : 50173
Source Host           : 192.168.30.130:3306
Source Database       : shop_platform_analyse

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-12-25 16:11:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for active_count
-- ----------------------------
DROP TABLE IF EXISTS `active_count`;
CREATE TABLE `active_count` (
  `active_count_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_hour` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active_count` int(11) NOT NULL COMMENT '每小时活跃人数',
  PRIMARY KEY (`active_count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of active_count
-- ----------------------------
INSERT INTO `active_count` VALUES ('1', '2019-12-25 16:40:00', '23');
INSERT INTO `active_count` VALUES ('2', '2019-12-25 16:41:00', '60');
INSERT INTO `active_count` VALUES ('3', '2019-12-25 16:42:00', '20');
INSERT INTO `active_count` VALUES ('4', '2019-12-25 16:43:00', '36');
INSERT INTO `active_count` VALUES ('5', '2019-12-25 16:44:00', '23');
INSERT INTO `active_count` VALUES ('6', '2019-12-25 16:45:00', '85');
INSERT INTO `active_count` VALUES ('7', '2019-12-25 16:46:00', '53');
INSERT INTO `active_count` VALUES ('8', '2019-12-25 16:47:00', '42');
INSERT INTO `active_count` VALUES ('9', '2019-12-25 16:48:00', '23');
INSERT INTO `active_count` VALUES ('10', '2019-12-25 16:49:00', '43');
INSERT INTO `active_count` VALUES ('11', '2019-12-25 16:50:00', '38');
INSERT INTO `active_count` VALUES ('12', '2019-12-25 16:51:00', '64');
INSERT INTO `active_count` VALUES ('13', '2019-12-25 16:52:00', '14');
INSERT INTO `active_count` VALUES ('14', '2019-12-25 16:53:00', '40');
INSERT INTO `active_count` VALUES ('15', '2019-12-25 16:54:00', '31');
INSERT INTO `active_count` VALUES ('16', '2019-12-25 16:55:00', '75');
INSERT INTO `active_count` VALUES ('17', '2019-12-25 16:56:00', '66');
INSERT INTO `active_count` VALUES ('18', '2019-12-25 16:57:00', '39');
INSERT INTO `active_count` VALUES ('19', '2019-12-25 16:58:00', '22');
INSERT INTO `active_count` VALUES ('20', '2019-12-25 16:59:00', '9');
INSERT INTO `active_count` VALUES ('21', '2019-12-25 17:00:00', '17');
INSERT INTO `active_count` VALUES ('22', '2019-12-25 17:01:00', '44');
INSERT INTO `active_count` VALUES ('23', '2019-12-25 17:02:00', '26');
INSERT INTO `active_count` VALUES ('24', '2019-12-25 17:03:00', '6');
INSERT INTO `active_count` VALUES ('25', '2019-12-25 17:04:00', '19');
INSERT INTO `active_count` VALUES ('26', '2019-12-25 17:05:00', '37');
INSERT INTO `active_count` VALUES ('27', '2019-12-25 17:06:00', '77');
INSERT INTO `active_count` VALUES ('28', '2019-12-25 17:07:00', '39');
INSERT INTO `active_count` VALUES ('29', '2019-12-25 17:08:00', '23');
INSERT INTO `active_count` VALUES ('30', '2019-12-25 17:09:00', '14');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) NOT NULL,
  `goods_price` decimal(8,2) NOT NULL,
  `goods_store` int(11) NOT NULL,
  `goods_detail` text,
  `goods_shop` varchar(50) NOT NULL,
  `goods_category` varchar(30) NOT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES ('1', '红星二锅头', '89.00', '40', '酒绿瓶56度500ml*6瓶清香型白酒酒厂直供', '天猫', '酒');
INSERT INTO `goods_info` VALUES ('2', '野人牙齿', '1000.00', '50', '具有收藏价值的牙齿', '天猫', '藏品');
INSERT INTO `goods_info` VALUES ('3', '蜂花香皂', '17.40', '60', '檀香皂清洁润滑肌肤沐浴芳香国货125g*3块', '天猫', '洗涤用品');
INSERT INTO `goods_info` VALUES ('4', '友臣肉松棒', '45.00', '70', '1KG肉松饼面包礼盒整箱网红小吃糕点心早餐休闲零食', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('5', '云南白药牙膏', '28.30', '80', '国粹清新口气去黄牙垢去口臭美白亮白牙齿抗敏家庭装', '天猫', '洗涤用品');
INSERT INTO `goods_info` VALUES ('6', '霸王首乌固发洗发液', '69.00', '90', '固发防掉发洗发露乌发黑发洗发水男女士黑芝麻洗头膏正品', '天猫', '洗涤用品');
INSERT INTO `goods_info` VALUES ('7', '阿迪达斯neo男鞋', '329.00', '100', '2019春新款RUN 70S运动鞋休闲鞋防滑跑步鞋CG6140', '天猫', '运动鞋');
INSERT INTO `goods_info` VALUES ('8', '惠普幽灵500蓝牙鼠标', '249.00', '110', '惠普HP 幽灵系列无线蓝牙鼠标时尚前卫拉丝感磨砂涂层便携WIN7MAC', '天猫', '数码产品');
INSERT INTO `goods_info` VALUES ('9', 'Huawei P10', '1468.00', '120', '徕卡双摄拍照 华为 p10 全网通4G智能手机支持NFC P10PLUS P20', '天猫', '数码产品');
INSERT INTO `goods_info` VALUES ('10', '小熊加湿器', '199.00', '130', '家用静音孕妇婴儿增湿器迷你办公桌面抑菌空气小香薰机', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('11', '卫龙辣条', '18.00', '140', '麻辣熟食小面筋亲嘴烧豆腐干辣块辣味儿时回忆零食品礼包', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('12', '屈臣氏香草苏打汽水', '199.00', '150', '屈臣氏原味/香草苏打汽水330ml*24罐整箱调酒配料碳酸饮用水饮料', '天猫', '饮料');
INSERT INTO `goods_info` VALUES ('13', '折叠躺椅', '289.00', '160', '午休懒人便携沙滩逍遥靠背椅子办公室休闲家用阳台午睡床', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('14', '茅台迎宾酒', '768.00', '40', '53度茅台迎宾酒500mlx6（2013版） 贵州酱香型白酒整箱', '天猫', '酒');
INSERT INTO `goods_info` VALUES ('15', '五粮液', '399.00', '100', '五粮液股份富贵天下佳藏52度 500mL*6瓶浓香型白酒整箱送礼礼盒', '天猫', '酒');
INSERT INTO `goods_info` VALUES ('16', '剑南春', '2999.00', '40', '52度剑南春白酒500ml*6整箱酒厂直供', '天猫', '酒');
INSERT INTO `goods_info` VALUES ('17', '红花郎', '698.00', '90', '【酒厂自营】郎酒 红花郎15 53度酱香型白酒500mL（两瓶送礼袋）', '天猫', '酒');
INSERT INTO `goods_info` VALUES ('18', '全峰收纳', '249.00', '120', '小推车置物架落地厨房储物架子婴儿用品宝宝带轮可移动宜家收纳架', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('19', '长明灯蜡烛台', '48.00', '50', '佛具用品，琉璃烛台，精雕细琢，质感上乘', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('20', '立体印花喜盆', '23.90', '300', '结婚新人陪嫁红色盆子洗脸盆 新娘嫁妆不锈钢喜盆2个装 婚庆用品', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('21', '装饰贡品水果', '43.00', '150', '平平安安 供奉佛像 做工精致', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('22', '卫生间晾晒用具', '18.89', '160', '实心20夹 防风钩型 加粗加厚 不锈钢', '天猫', '家居用品');
INSERT INTO `goods_info` VALUES ('23', '广告宣传片制作', '100.00', '150', '视频拍摄淘宝主图制作服装美食数码产品短视频剪辑模特广告宣传片', '天猫', '数码产品');
INSERT INTO `goods_info` VALUES ('24', '金贝摄影灯', '370.00', '160', 'DII-250W 数码影室闪光灯 证件照 人像 淘宝产品 高指数闪光 色温精准', '天猫', '数码产品');
INSERT INTO `goods_info` VALUES ('25', '屏幕清洁剂', '40.00', '160', '丹麦AM键盘清洁手机液晶屏幕清洁剂套装清理除尘MIST小号清洁剂喷雾灰色', '天猫', '数码产品');
INSERT INTO `goods_info` VALUES ('26', '洗衣液', '9.90', '160', '一品净手洗洗衣液袋装500g衣物内衣洗衣液去渍去污洗涤剂用品皂液', '天猫', '洗涤用品');
INSERT INTO `goods_info` VALUES ('27', '狗年纪念币', '738.00', '150', '大业狗年纪念币纯银纪念章金银钞银条银币定制生肖狗纪念品收藏品', '天猫', '藏品');
INSERT INTO `goods_info` VALUES ('28', '发晶印章', '580.00', '160', '千蕊 天然罕见发晶印章 发晶白幽灵共生清透章料收藏品实物', '天猫', '藏品');
INSERT INTO `goods_info` VALUES ('29', '和田玉', '16800.00', '160', '【戴逸晨作品】 新疆和田玉籽料吊坠《龙龟》苏州名家大师藏品', '天猫', '藏品');
INSERT INTO `goods_info` VALUES ('30', '安踏女鞋', '169.00', '160', '安踏女鞋运动鞋2019冬季新款官网白色皮面保暖跑鞋ins旅游休闲鞋', '天猫', '运动鞋');
INSERT INTO `goods_info` VALUES ('31', 'NIKE AIR FORCE 1 07 AF1', '749.00', '150', 'Nike耐克官方NIKE AIR FORCE 1 07 AF1女子运动鞋休闲板鞋', '天猫', '运动鞋');
INSERT INTO `goods_info` VALUES ('32', 'adidas三叶草STAN', '799.00', '160', '阿迪达斯官网adidas三叶草STAN SMITH男女经典小白鞋运动鞋M20324', '天猫', '运动鞋');
INSERT INTO `goods_info` VALUES ('33', 'UMA男鞋女鞋', '549.00', '160', '彪马PUMA男鞋女鞋2019新款suede李现同款休闲鞋板鞋运动鞋352634', '天猫', '运动鞋');
INSERT INTO `goods_info` VALUES ('34', '氧气吐司面包', '29.00', '160', '【三只松鼠_氧气吐司面包800g/整箱】营养早餐食品夹心小零食糕点', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('35', '足迹面包', '25.00', '150', '三只松鼠 足迹面包750g/整箱手撕全麦营养早餐夹心蛋糕糕点心食品', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('36', '全麦面包', '28.00', '160', '黑麦全麦面包整箱代餐饱腹低粗粮脂吐司无糖精早餐零食品速食懒人', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('37', '盐焗鸡翅', '47.00', '160', '无穷食品旗舰店盐焗鸡翅240g爱辣味翅中翅根肉类休闲零食小吃整箱', '天猫', '食品');
INSERT INTO `goods_info` VALUES ('38', '维他柠檬茶', '59.80', '160', '【薇娅推荐】Vita维他柠檬茶法国艺术家设计款250mL*24盒 饮料', '天猫', '饮料');
INSERT INTO `goods_info` VALUES ('39', '茶兀饮料', '64.90', '150', '农夫山泉茶兀饮料茶派果味水500ml*15瓶整箱蜜桃乌龙西柚茉莉红茶', '天猫', '饮料');
INSERT INTO `goods_info` VALUES ('40', '星巴克星冰乐饮料', '59.00', '160', 'Starbucks星巴克星冰乐饮料281ml*4瓶装即饮浓咖啡饮料星倍醇锐能', '天猫', '饮料');

-- ----------------------------
-- Table structure for goods_order_count
-- ----------------------------
DROP TABLE IF EXISTS `goods_order_count`;
CREATE TABLE `goods_order_count` (
  `goods_id` int(11) DEFAULT NULL,
  `goods_name` varchar(20) DEFAULT NULL,
  `goods_category` varchar(20) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `day` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_order_count
-- ----------------------------
INSERT INTO `goods_order_count` VALUES ('18', '全峰收纳', '家居用品', '6', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('19', '长明灯蜡烛台', '家居用品', '5', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('21', '装饰贡品水果', '家居用品', '2', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('14', '茅台迎宾酒', '酒', '3', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('15', '五粮液', '酒', '2', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('17', '红花郎', '酒', '1', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('38', '维他柠檬茶', '饮料', '5', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('39', '茶兀饮料', '饮料', '3', '2019-12-24');
INSERT INTO `goods_order_count` VALUES ('40', '星巴克星冰乐饮料', '饮料', '1', '2019-12-25');

-- ----------------------------
-- Table structure for goods_picture
-- ----------------------------
DROP TABLE IF EXISTS `goods_picture`;
CREATE TABLE `goods_picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `picture_path` varchar(100) NOT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `goods_id_picture` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_picture
-- ----------------------------
INSERT INTO `goods_picture` VALUES ('1006', '3306', '../../static/images/fang_shubiao1_zxr.jpg');
INSERT INTO `goods_picture` VALUES ('1007', '3306', '../../static/images/fang_shubiao2_zxr.jpg');
INSERT INTO `goods_picture` VALUES ('1008', '3306', '../../static/images/fang_shubiao3_zxr.jpg');

-- ----------------------------
-- Table structure for hot_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `hot_goods_info`;
CREATE TABLE `hot_goods_info` (
  `hot_goods_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_hot` int(11) DEFAULT '0',
  `goods_date` date NOT NULL,
  PRIMARY KEY (`hot_goods_id`),
  KEY `goods_id_hot` (`goods_id`),
  CONSTRAINT `goods_id_hot` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot_goods_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_count
-- ----------------------------
DROP TABLE IF EXISTS `order_count`;
CREATE TABLE `order_count` (
  `order_count_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_sum_count` int(11) NOT NULL COMMENT '总的订单个数',
  `order_pay_count` int(11) NOT NULL COMMENT '成功支付的订单个数',
  `order_refund_count` int(11) NOT NULL COMMENT '退款的订单个数',
  `order_trade_sum` decimal(10,2) NOT NULL COMMENT '订单交易总额',
  `order_refund_sum` decimal(10,2) NOT NULL COMMENT '订单退款总额',
  `order_count_date` date NOT NULL,
  PRIMARY KEY (`order_count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_count
-- ----------------------------
INSERT INTO `order_count` VALUES ('1', '2', '1', '1', '89.00', '17.40', '2019-12-18');
INSERT INTO `order_count` VALUES ('2', '11', '9', '2', '100.00', '30.00', '2019-12-19');
INSERT INTO `order_count` VALUES ('3', '12', '10', '2', '77.00', '1.00', '2019-12-20');
INSERT INTO `order_count` VALUES ('4', '4', '2', '2', '1.00', '11.00', '2019-12-21');
INSERT INTO `order_count` VALUES ('5', '5', '3', '2', '22.00', '77.00', '2019-12-22');
INSERT INTO `order_count` VALUES ('6', '6', '4', '2', '33.00', '86.00', '2019-12-23');
INSERT INTO `order_count` VALUES ('7', '7', '1', '6', '2.00', '23.00', '2019-12-24');
INSERT INTO `order_count` VALUES ('8', '7', '4', '3', '89.00', '17.40', '2019-12-25');
INSERT INTO `order_count` VALUES ('9', '12', '5', '7', '89.00', '17.40', '2019-12-26');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_number` int(11) NOT NULL,
  `goods_sum` decimal(8,2) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `order_id_detail` (`order_id`),
  KEY `goods_id_detail` (`goods_id`),
  CONSTRAINT `goods_id_detail` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`),
  CONSTRAINT `order_id_detail` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '20191217-183740-1', '3', '1', '17.40');
INSERT INTO `order_detail` VALUES ('2', '20191217-183740-1', '1', '3', '267.00');
INSERT INTO `order_detail` VALUES ('3', '20191217-190201-1', '24', '5', '1850.00');
INSERT INTO `order_detail` VALUES ('4', '20191219-115416-1', '1', '2', '178.00');
INSERT INTO `order_detail` VALUES ('5', '20191223-195453-1', '37', '3', '141.00');
INSERT INTO `order_detail` VALUES ('6', '20191223-195754-1', '20', '3', '71.70');
INSERT INTO `order_detail` VALUES ('7', '20191223-195754-1', '30', '1', '169.00');
INSERT INTO `order_detail` VALUES ('8', '20191223-200139-1', '4', '1', '45.00');
INSERT INTO `order_detail` VALUES ('9', '20191223-200329-1', '15', '1', '399.00');
INSERT INTO `order_detail` VALUES ('10', '20191223-200329-1', '32', '1', '799.00');
INSERT INTO `order_detail` VALUES ('11', '20191223-203241-1', '2', '1', '1000.00');
INSERT INTO `order_detail` VALUES ('12', '20191223-203316-1', '40', '1', '59.00');
INSERT INTO `order_detail` VALUES ('13', '20191225-002514-6', '20', '2', '47.80');
INSERT INTO `order_detail` VALUES ('14', '20191225-002600-6', '8', '1', '249.00');
INSERT INTO `order_detail` VALUES ('15', '20191225-002630-6', '12', '1', '199.00');
INSERT INTO `order_detail` VALUES ('16', '20191225-002630-6', '19', '1', '48.00');
INSERT INTO `order_detail` VALUES ('17', '20191225-003108-4', '35', '1', '25.00');
INSERT INTO `order_detail` VALUES ('18', '20191225-003116-4', '29', '1', '16800.00');
INSERT INTO `order_detail` VALUES ('19', '20191225-003159-4', '25', '1', '40.00');
INSERT INTO `order_detail` VALUES ('20', '20191225-003159-4', '17', '2', '1396.00');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `consignee_name` varchar(30) NOT NULL,
  `order_sum` decimal(8,2) DEFAULT NULL,
  `order_status` char(1) DEFAULT NULL COMMENT '订单状态：\r\n1(下单成功)\r\n2(付款成功)\r\n3(退款成功)',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单状态修改时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('20191217-183740-1', '1', 'zsd', '284.40', '1', '2019-12-17 18:37:40', '2019-12-17 18:37:40');
INSERT INTO `order_info` VALUES ('20191217-190201-1', '1', 'zsd', '1850.00', '2', '2019-12-17 19:02:01', '2019-12-17 19:02:04');
INSERT INTO `order_info` VALUES ('20191219-115416-1', '1', 'zsd', '178.00', '1', '2019-12-19 11:54:16', '2019-12-19 11:54:19');
INSERT INTO `order_info` VALUES ('20191223-195453-1', '1', 'zsd', '141.00', '1', '2019-12-23 19:54:53', '2019-12-23 19:54:55');
INSERT INTO `order_info` VALUES ('20191223-195754-1', '1', 'zsd', '240.70', '1', '2019-12-23 19:57:54', '2019-12-23 19:57:54');
INSERT INTO `order_info` VALUES ('20191223-200139-1', '1', 'zsd', '45.00', '1', '2019-12-23 20:01:39', '2019-12-23 20:01:44');
INSERT INTO `order_info` VALUES ('20191223-200329-1', '1', 'zsd', '1198.00', '1', '2019-12-23 20:03:29', '2019-12-23 20:03:31');
INSERT INTO `order_info` VALUES ('20191223-203241-1', '1', 'zsd', '1000.00', '2', '2019-12-23 20:32:41', '2019-12-23 20:32:43');
INSERT INTO `order_info` VALUES ('20191223-203316-1', '1', 'zsd', '59.00', '3', '2019-12-23 20:33:16', '2019-12-23 20:33:18');
INSERT INTO `order_info` VALUES ('20191225-002514-6', '6', 'jzn', '47.80', '2', '2019-12-25 00:25:14', '2019-12-25 00:25:20');
INSERT INTO `order_info` VALUES ('20191225-002600-6', '6', 'jzn', '249.00', '3', '2019-12-25 00:26:00', '2019-12-25 00:26:01');
INSERT INTO `order_info` VALUES ('20191225-002630-6', '6', 'jzn', '247.00', '3', '2019-12-25 00:26:30', '2019-12-25 00:26:33');
INSERT INTO `order_info` VALUES ('20191225-003108-4', '4', 'gbb', '25.00', '3', '2019-12-25 00:31:08', '2019-12-25 00:31:10');
INSERT INTO `order_info` VALUES ('20191225-003116-4', '4', 'gbb', '16800.00', '2', '2019-12-25 00:31:16', '2019-12-25 00:31:17');
INSERT INTO `order_info` VALUES ('20191225-003159-4', '4', 'gbb', '1436.00', '2', '2019-12-25 00:31:59', '2019-12-25 00:32:00');

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `shopping_car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_number` int(11) NOT NULL,
  `isbuy` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否在页面上勾选',
  `isshow` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示在购物车中（结算后为0）',
  PRIMARY KEY (`shopping_car_id`),
  KEY `user_id_shop` (`user_id`),
  KEY `goods_id_shop` (`goods_id`),
  CONSTRAINT `goods_id_shop` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`),
  CONSTRAINT `user_id_shop` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
INSERT INTO `shopping_car` VALUES ('3', '1', '4', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('4', '1', '3', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('5', '1', '1', '3', '0', '0');
INSERT INTO `shopping_car` VALUES ('6', '1', '24', '4', '0', '0');
INSERT INTO `shopping_car` VALUES ('7', '1', '24', '5', '0', '0');
INSERT INTO `shopping_car` VALUES ('8', '3', '14', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('9', '3', '14', '3', '0', '0');
INSERT INTO `shopping_car` VALUES ('10', '1', '22', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('11', '1', '16', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('12', '1', '1', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('13', '1', '23', '4', '0', '0');
INSERT INTO `shopping_car` VALUES ('14', '3', '3', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('15', '1', '37', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('16', '1', '30', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('17', '1', '20', '3', '0', '0');
INSERT INTO `shopping_car` VALUES ('18', '1', '4', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('19', '1', '15', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('20', '1', '32', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('21', '1', '2', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('22', '1', '40', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('23', '6', '8', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('24', '6', '12', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('25', '6', '20', '2', '0', '0');
INSERT INTO `shopping_car` VALUES ('26', '6', '19', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('27', '4', '35', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('28', '4', '29', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('29', '4', '25', '1', '0', '0');
INSERT INTO `shopping_car` VALUES ('30', '4', '17', '2', '0', '0');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `user_password` varchar(32) NOT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `login_status` char(1) NOT NULL COMMENT '登录状态：1（登录）、0（退出）',
  `active_status` char(1) NOT NULL COMMENT '每小时活跃状态：1(在线)、0(离线)',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'zsd', '3Eg+gKegvZ73HYz5c2c5JA==', '17815953575', '南通如皋', '0', '0');
INSERT INTO `user_info` VALUES ('2', 'lly', '3Eg+gKegvZ73HYz5c2c5JA==', '13015946321', null, '0', '0');
INSERT INTO `user_info` VALUES ('3', 'llx', '3Eg+gKegvZ73HYz5c2c5JA==', '18078962586', null, '1', '0');
INSERT INTO `user_info` VALUES ('4', 'gbb', '3Eg+gKegvZ73HYz5c2c5JA==', '13962354578', null, '1', '1');
INSERT INTO `user_info` VALUES ('5', 'cjl', '3Eg+gKegvZ73HYz5c2c5JA==', '18012457996', null, '0', '0');
INSERT INTO `user_info` VALUES ('6', 'jzn', '3Eg+gKegvZ73HYz5c2c5JA==', '18012457896', null, '1', '1');

-- ----------------------------
-- Procedure structure for create_shopping_car
-- ----------------------------
DROP PROCEDURE IF EXISTS `create_shopping_car`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_shopping_car`(in get_goods_id int,in get_goods_number int,in get_user_id int,
       out result int)
begin 
      set result = 1;
      select goods_store into @store from goods_info where goods_id=get_goods_id; 
      select count(1) into @counts from shopping_car where goods_id=get_goods_id and user_id=get_user_id and isshow=1; 
      if @store >= get_goods_number then
         if @counts >0 then  
            UPDATE shopping_car SET goods_number=goods_number+get_goods_number where goods_id=get_goods_id and user_id=get_user_id and isshow = 1; 
            set result = FOUND_ROWS();
         else
             insert into shopping_car ( user_id,goods_id,goods_number ) values (get_user_id,get_goods_id,get_goods_number);
             set result = FOUND_ROWS();
         end if;
      else
           set result = 0; 
      end if;
end
;;
DELIMITER ;
