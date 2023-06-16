실행 시 설정
Active profile : local
Program arguments : requestDate=2023061601 등과 같이 매개변수를 주어 중복 실행 가능하게 한다.


--


-- batch.adimg_new definition

CREATE TABLE `adimg_new` (
  `adino` int unsigned DEFAULT NULL,
  `ano` int unsigned DEFAULT NULL,
  `armno` int DEFAULT NULL,
  `armgno` int DEFAULT NULL,
  `ht_imgid` int unsigned DEFAULT NULL,
  `ht_aid` int unsigned DEFAULT NULL,
  `tmino` int DEFAULT NULL,
  `type` tinyint unsigned DEFAULT NULL,
  `aeigno` int unsigned DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `sort_num` smallint unsigned DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `is_use` enum('Y','N') DEFAULT NULL,
  `adiedit` timestamp NOT NULL,
  `adireg` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
