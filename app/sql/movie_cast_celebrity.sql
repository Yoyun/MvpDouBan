/*
Navicat SQLite Data Transfer

Source Server         : Douban
Source Server Version : 30808
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 30808
File Encoding         : 65001

Date: 2017-01-17 22:49:42
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for movie_cast_celebrity
-- ----------------------------
DROP TABLE IF EXISTS "main"."movie_cast_celebrity";
CREATE TABLE "movie_cast_celebrity" (
"movie_id"  TEXT,
"celebrity_id"  TEXT,
FOREIGN KEY ("movie_id") REFERENCES "movie" ("id"),
FOREIGN KEY ("celebrity_id") REFERENCES "celebrity" ("id"),
UNIQUE ("movie_id", "celebrity_id")
);
