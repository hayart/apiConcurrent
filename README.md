use mytest;

CREATE TABLE `category` (
`id` bigint PRIMARY KEY,
`name` varchar(255),
`type` varchar(255),
`status` varchar(255)
);

CREATE TABLE `foods` (
`id` bigint PRIMARY KEY,
`category_id` bigint,
`name` varchar(255),
`description` text,
`status` varchar(255)
);

CREATE TABLE `price` (
`id` bigint PRIMARY KEY,
`product_id` bigint,
`price` double,
`valid_from` timestamp,
`valid_to` timestamp,
`status` varchar(255)
);

CREATE TABLE `inventory` (
`id` bigint PRIMARY KEY,
`product_id` bigint,
`warehouse_id` bigint,
`available_quantity` integer,
`reserved_quantity` integer,
`status` varchar(255)
);

