/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : chuzhouforum

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2019-02-11 21:07:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `score` int(10) unsigned zerofill DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topic_id` (`topic_id`),
  KEY `username` (`username`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('5', '2', '78', '0000000066', '666', '2019-02-10 21:21:53', 'oppo');
INSERT INTO `answer` VALUES ('8', '1', '78', '0000000096', '<p>666</p>', '2019-02-10 21:21:53', 'oppo');
INSERT INTO `answer` VALUES ('9', '1', '78', '0000000000', '<p><br></p>', '2019-02-10 21:30:39', 'oppo');
INSERT INTO `answer` VALUES ('14', '1', '78', '0000000000', '<p>789</p>', '2019-02-10 21:39:43', 'oppo');
INSERT INTO `answer` VALUES ('16', '1', '73', '0000000000', '<p>超文本标记语言</p>', '2019-02-10 21:42:22', 'oppo');
INSERT INTO `answer` VALUES ('18', '1', '75', '0000000000', '<p>洒水</p>', '2019-02-11 20:08:16', 'oppo');

-- ----------------------------
-- Table structure for `classify`
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(255) NOT NULL,
  `second` varchar(255) NOT NULL,
  `fid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('1', '前端', 'HTML', '1');
INSERT INTO `classify` VALUES ('2', '前端', 'CSS', '1');
INSERT INTO `classify` VALUES ('3', '前端', 'Javascript', '1');
INSERT INTO `classify` VALUES ('4', '前端', 'Vue', '1');
INSERT INTO `classify` VALUES ('5', '后台', 'JavaSE', '2');
INSERT INTO `classify` VALUES ('6', '后台', 'SpringBoot', '2');
INSERT INTO `classify` VALUES ('7', '后台', 'Maven', '2');
INSERT INTO `classify` VALUES ('8', '数据库', 'MySQL', '3');
INSERT INTO `classify` VALUES ('9', '数据库', 'JPA', '3');

-- ----------------------------
-- Table structure for `likeanswer`
-- ----------------------------
DROP TABLE IF EXISTS `likeanswer`;
CREATE TABLE `likeanswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `useful` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likeanswer
-- ----------------------------
INSERT INTO `likeanswer` VALUES ('2', '1', '0000000001');
INSERT INTO `likeanswer` VALUES ('2', '2', '0000000001');
INSERT INTO `likeanswer` VALUES ('3', '1', '0000000001');
INSERT INTO `likeanswer` VALUES ('3', '2', '0000000001');
INSERT INTO `likeanswer` VALUES ('4', '1', '0000000001');
INSERT INTO `likeanswer` VALUES ('5', '1', '0000000001');
INSERT INTO `likeanswer` VALUES ('5', '2', '0000000001');
INSERT INTO `likeanswer` VALUES ('7', '1', '0000000000');
INSERT INTO `likeanswer` VALUES ('8', '1', '0000000000');
INSERT INTO `likeanswer` VALUES ('9', '1', '0000000001');

-- ----------------------------
-- Table structure for `profile`
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
  `user_id` int(11) NOT NULL,
  `atype` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('1', '学生', '6bc4a380-83fc-484d-9070-bc9e78e9dc88.png');
INSERT INTO `profile` VALUES ('2', '教师', '1ec6d0ac-1edc-4c31-891d-1ea334047a2b.png');
INSERT INTO `profile` VALUES ('5', '学生', 'default.png');
INSERT INTO `profile` VALUES ('11', '学生', 'e9070dfb-8ea9-497e-9bf2-c29418b5e390.png');

-- ----------------------------
-- Table structure for `rank`
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `user_id` int(11) NOT NULL,
  `point` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `rank_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('1', '0000000150');
INSERT INTO `rank` VALUES ('2', '0000000018');
INSERT INTO `rank` VALUES ('3', '0000000020');
INSERT INTO `rank` VALUES ('4', '0000000000');
INSERT INTO `rank` VALUES ('5', '0000000000');
INSERT INTO `rank` VALUES ('6', '0000000000');
INSERT INTO `rank` VALUES ('7', '0000000000');
INSERT INTO `rank` VALUES ('8', '0000000000');
INSERT INTO `rank` VALUES ('9', '0000000000');
INSERT INTO `rank` VALUES ('10', '0000000000');
INSERT INTO `rank` VALUES ('11', '0000000000');

-- ----------------------------
-- Table structure for `recommend`
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `user_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `focus` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`user_id`,`topic_id`),
  KEY `topic_id` (`topic_id`),
  KEY `recommend_ibfk_1` (`user_id`),
  CONSTRAINT `recommend_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `recommend_ibfk_2` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('1', '69', '0000000010');
INSERT INTO `recommend` VALUES ('1', '70', '0000000024');
INSERT INTO `recommend` VALUES ('1', '75', '0000000012');
INSERT INTO `recommend` VALUES ('2', '70', '0000000017');
INSERT INTO `recommend` VALUES ('2', '74', '0000000011');
INSERT INTO `recommend` VALUES ('2', '78', '0000000002');
INSERT INTO `recommend` VALUES ('3', '69', '0000000014');
INSERT INTO `recommend` VALUES ('4', '71', '0000000017');
INSERT INTO `recommend` VALUES ('5', '72', '0000000025');
INSERT INTO `recommend` VALUES ('6', '70', '0000000019');
INSERT INTO `recommend` VALUES ('7', '69', '0000000020');

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `category` varchar(16) NOT NULL,
  `code` varchar(1024) DEFAULT NULL,
  `content` varchar(1024) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `title` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6br5a7f1rn1bi94rkmi38mcln` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('69', '1', 'mbs', null, 'MyBatis的一个主要的特点就是需要程序员自己编写sql，那么如果表太多的话，难免会很麻烦，mybatis官方提供了一个逆向工程，可以针对单表自动生成mybatis执行所需要的代码。有没有一个例子可以表现出来', '2018-11-13 10:33:10', 'Mybatis的逆向工程是什么意思？');
INSERT INTO `topic` VALUES ('70', '2', 'web', null, '1.display:none;会让元素完全从渲染树中消失，渲染的时候不占据任何空间；visibility: hidden;不会让元素从渲染树消失，渲染师元素继续占据空间，只是内容不可见\r\n2.display: none;是非继承属性，子孙节点消失由于元素从渲染树消失造成，通过修改子孙节点属性无法显示；visibility: hidden;是继承属性，子孙节点消失由于继承了hidden，通过设置visibility: visible;可以让子孙节点显式\r\n3.修改常规流中元素的display通常会造成文档重排。修改visibility属性只会造成本元素的重绘。\r\n4.读屏器不会读取display: none;元素内容；会读取visibility: hidden;元素内容', '2018-11-19 09:49:37', 'display: none;与visibility:hide区别');
INSERT INTO `topic` VALUES ('71', '3', 'web', null, '同源：两个文档同源需满足\r\n\r\n协议相同\r\n域名相同\r\n端口相同\r\n跨域通信：js进行DOM操作、通信时如果目标与当前窗口不满足同源条件，浏览器为了安全会阻止跨域操作。跨域通信通常有以下方法\r\n\r\n如果是log之类的简单单项通信，新建<img>,<script>,<link>,<iframe>元素，通过src，href属性设置为目标url。实现跨域请求\r\n如果请求json数据，使用<script>进行jsonp请求\r\n现代浏览器中多窗口通信使用HTML5规范的targetWindow.postMessage(data, origin);其中data是需要发送的对象，origin是目标窗口的origin。window.addEventListener(\'message\', handler, false);handler的event.data是postMessage发送来的数据，event.origin是发送窗口的origin，event.source是发送消息的窗口引用\r\n内部服务器代理请求跨域url，然后返回数据\r\n跨域请求数据，现代浏览器可使用HTML5规范的CORS功能，只要目标服务器返回HTTP头部**Access-Control-Allow-Origin: ***即可像普通ajax一样访问跨域资源', '2018-12-02 20:51:26', 'javascript跨域通信');
INSERT INTO `topic` VALUES ('72', '4', 'other', null, '∫(0~2π)e^sint dcost=?', '2018-12-01 23:53:10', '一个高数问题，有没有大佬？');
INSERT INTO `topic` VALUES ('73', '5', 'HTML', null, 'NICE', '2019-02-01 19:00:24', 'HTML是什么');
INSERT INTO `topic` VALUES ('74', '6', 'VUE', null, '这东西是干嘛的', '2019-01-30 17:01:17', 'VUE很火吗？');
INSERT INTO `topic` VALUES ('75', '7', 'Jpa', null, 'ganmade', '2019-01-29 20:26:30', '有人知道这是什么吗');
INSERT INTO `topic` VALUES ('76', '1', 'HTML', '《h1》？', '哪个标签啊', '2019-02-03 21:50:16', '标题用什么标签');
INSERT INTO `topic` VALUES ('78', '1', 'JavaSE', 'splice？', '怎么按照 指定位置分割字符串', '2019-02-03 21:55:32', 'string字符串分割');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(5) unsigned zerofill DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `expiretime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`username`),
  KEY `id` (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'oppo', '$2a$10$RzdVvJWKQxyhKDDFk1FjJuLQWWcae3xp/yj3wmERl1HEw41m2WCii', '00000', 'u4mryrvhlf8l4fb50qwctxrov8zzxkbw', '2019-02-11 20:46:22', '2019-02-11 21:46:22');
INSERT INTO `user` VALUES ('2', 'oracle', '$2a$10$gF6R7IAFEriV5QgqiCvbweVT86yHj0KQIqdvJVTl.DFKxi4Q1NqwO', '00001', 'qlfeewim9icdf9xxpxsopmtort2lv9jz', '2019-02-11 20:03:53', '2019-02-11 21:03:53');
INSERT INTO `user` VALUES ('3', 'test1', '123456', '00000', 'jcf9fsorc44ngpuj5mdk1wl2c9of8je8', '2019-01-08 14:37:20', '2019-01-08 15:37:20');
INSERT INTO `user` VALUES ('4', 'test2', '$2a$10$aemtjSVo3jrUTK0t.p6rhOWLsaADGScZo0m3xzIXiIcr/mPOwR/0m', '00000', '1pn19mxidb6oceih1bcoi9opxoe6fhz2', '2019-01-16 21:08:28', '2019-01-16 22:08:28');
INSERT INTO `user` VALUES ('5', 'chuzhou', '$2a$10$.EUfTl1OxwEiV5IVakVkC.Ba7YCgrIHvwAu9Ao8j6bR9m5iXEfwTa', '00000', 'vu8awepk34crptcleypjh0ybzv8a5i6y', '2019-01-16 21:20:40', '2019-01-16 22:20:40');
INSERT INTO `user` VALUES ('6', '前端大神', '$2a$10$3jlBTTSFjh4sARRW6EGA1O1J4zTJ7yNdI.NjX5WKY4MHWhsQ3kUC.', '00001', 'mhkh3mgqqrrl6rav952zu6heleva4i2b', '2019-01-17 21:00:54', '2019-01-17 22:00:54');
INSERT INTO `user` VALUES ('7', '后端大佬', '$2a$10$742vXhTYgvrRVKAw3BxKGuve.viPrwxXCkDtWXBiY50cd48C9GTHy', '00000', 'uzk50dq8c008w7dsqqdias5fd21yj475', '2019-01-17 21:06:05', '2019-01-17 22:06:05');
INSERT INTO `user` VALUES ('8', '666', '$2a$10$IgVBZFImwjYzvkYU3D9XneXcwRYJ1yiO3R8EomxHqcnjiCTfBCadC', '00000', '4uxmvsbvc6fzkixuiqc9i4v3imlazrcz', '2019-02-11 10:48:05', '2019-02-11 11:48:05');
INSERT INTO `user` VALUES ('9', '123', '$2a$10$Q9ovB5yDtYPbXQQVrPrF6eGIJkPJcBh7IAiFCgkUl5RFeZUdAPl8a', '00000', '7zvptvi07uxte6ojbr2uagva15zr1uye', '2019-02-11 10:48:56', '2019-02-11 11:48:56');
INSERT INTO `user` VALUES ('10', '89654', '$2a$10$56OnvE0UtK0Ztjyt2TEhR.n5S/w4UTCM7lF1eF4mNim4dublZ.U0C', '00000', 'mwy8x0rs8p3ylmy3wqbfy4oowltv6hlo', '2019-02-11 10:58:34', '2019-02-11 11:58:34');
INSERT INTO `user` VALUES ('11', '89654ww', '$2a$10$NCuBrdqp.LFCBBVC6OF60eWABV2hrFKE3lRiuiRJ3623oLnikN6XW', '00000', 'cejwuj9trj05e4u0clyt5kihwvdtckv6', '2019-02-11 11:02:09', '2019-02-11 12:02:09');
