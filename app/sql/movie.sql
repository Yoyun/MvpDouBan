/*
Navicat SQLite Data Transfer

Source Server         : Douban
Source Server Version : 30808
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30808
File Encoding         : 65001

Date: 2017-01-17 22:49:35
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS "main"."movie";
CREATE TABLE "movie" (
"id"  TEXT NOT NULL,
"title"  TEXT,
"original_title"  TEXT,
"year"  TEXT,
"rating"  TEXT,
"genres"  TEXT,
"collect_count"  INTEGER,
"subtype"  TEXT,
"alt"  TEXT,
"images"  TEXT,
PRIMARY KEY ("id" ASC)
);
