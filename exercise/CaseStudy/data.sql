use furama_minhducc07;

INSERT INTO customer_type (name)
VALUE 
('Diamond'),
 ('Platinium'),
 ('Gold'),
 ('silver'),
 ('Member');


-- INSERT INTO `customer` 
-- (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `name`, `phone_number`, `customer_type_id`) 



 INSERT INTO customer
  (`name`,`date_of_birth`, `gender`,`id_card`,`phone_number`, `email`,`address`,`customer_type_id`)
 VALUE ('Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
  ('Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
  ('Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
  ('Dương Văn Quang','1981-07-08',0,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
  ('Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
  ('Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
  ('Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
  ('Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
  ('Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
  ('Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);



INSERT INTO position (name)
VALUE ('Quản lý'), 
('Nhân viên');

INSERT INTO education_degree (name)
VALUE ('Trung cấp'),
('Cao Đẳng'), 
('Đại học'), 
('Sau đại học');

INSERT INTO division (name)
VALUE ('Sale - Marketing'),
('Hành chính'),
('PHỤc vụ'),
('Quản lý');

INSERT INTO rent_type (name) 
VALUE ('year'),
   ('month'),
   ('day'),
   ('hour');
    
INSERT INTO facility_type(name)
VALUE ('Villa'),
    ('House'),
    ('Room');

INSERT INTO facility ( `name`,`area`, `cost`,`max_people`,`standard_room`, `description_other_convenience`,`pool_area`,`number_of_floors`,`facility_free`,`rent_type`,`facility_type`) 
VALUE ('Villa Beach Front',25000,1000000,10,'vip','Có hồ bơi',500,4,null,3,1),
     ('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,null,2,2),
     ('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,'1 Xe máy, 1 Xe đạp',4,3),
     ('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,null,3,1),
     ('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,null,3,2),
     ('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,'1 Xe máy',4,3);

INSERT INTO `furama_minhduc`.`role` (`id`, `name`) VALUES ('1', 'ROLE_USER');
INSERT INTO `furama_minhduc`.`role` (`id`, `name`) VALUES ('2', 'ROLE_ADMIN');



INSERT INTO `furama_minhduc`.`user` (`username`, `is_enabled`, `password`) VALUES ('duc', b'1', '$2a$10$dnZ2zK7Oi0rlBAlnwn.06uDNq8YreNVt6mdlvG1UC2OrA2gE3RcXm');
INSERT INTO `furama_minhduc`.`user` (`username`, `is_enabled`, `password`) VALUES ('vip ', b'1', '$2a$10$dnZ2zK7Oi0rlBAlnwn.06uDNq8YreNVt6mdlvG1UC2OrA2gE3RcXm');
INSERT INTO `furama_minhduc`.`user` (`username`, `is_enabled`, `password`) VALUES ('admin', b'1', '$2a$10$dnZ2zK7Oi0rlBAlnwn.06uDNq8YreNVt6mdlvG1UC2OrA2gE3RcXm');


INSERT INTO `furama_minhduc`.`user_role` (`use_name`, `role_id`) VALUES ('admin', '1');
INSERT INTO `furama_minhduc`.`user_role` (`use_name`, `role_id`) VALUES ('duc', '1');
INSERT INTO `furama_minhduc`.`user_role` (`use_name`, `role_id`) VALUES ('admin', '2');



INSERT INTO `furama_minhduc`.`employee` (`name`,`date_of_birth`,`id_card`,`salary`,`phone_number`,`email`,`address`,`position_id`,`education_degree_id`,`division_id`, `user_name`) 
VALUE ('Nguyễn Văn Anh','1970-11-07', '456231786',10000000,'0901234121','annguyen@gMAIL.COM','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,'duc'),
 ('Lê Văn Bình','1997-04-09', '654231234',7000000,'0934212314','binhlv@gmaIl.com','22 YÊN BÁI, Đà Nẵng',1,2,2,'duc'),
 ('Hồ Thị Yến','1995-12-12', '999231723',14000000,'0412352315','thiyen@gMail.com','K234/11 Điện BiÊN PHỦ, GIa Lai',1,3,2,'duc'),
 ('Võ Công Toản','1980-04-04', '123231365',17000000,'0374443232','toan0404@gmail.com','77 Hoàng DIệu, Quảng TrỊ',1,4,4,'duc'),
 ('Nguyễn BỈnh Phát','1999-12-09', '454363232',6000000,'0902341231','PHATPhaT@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,'duc'),
 ('Khúc NGUYỄN An Nghi','2000-11-08', '964542311',7000000,'0978653213','annghI20@GMAIl.Com','294 Nguyễn Tất ThànH, Đà Nẵng',2,3,3,'duc'),
 ('NguYỄN HỮU Hà','1993-01-01', '534323231',8000000,'0941234553','nhh0101@gmail.com','4 NGUYỄN CHí Thanh, Huế',2,3,2,'duc'),
 ('Nguyễn Hà ĐÔng','1989-09-03', '232414123',9000000,'0642123111','dOnghanguyen@gmail.com','111 HùnG VƯƠNG, HÀ Nội',2,4,4,'duc'),
 ('Tòng Hoang','1982-09-03', '256781231',6000000,'0245144444','hoangtong@gmail.Com','213 Hàm Nghi, Đà Nẵng',2,4,4,'duc'),
 ('NGuyễn Công Đạo','1994-01-08', '755434343',8000000,'0988767111','nguyencongdao@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,'duc');
 
 UPDATE `furama_minhduc`.`facility` SET `id` = '1' WHERE (`id` = '7');
UPDATE `furama_minhduc`.`facility` SET `id` = '2' WHERE (`id` = '8');
UPDATE `furama_minhduc`.`facility` SET `id` = '3' WHERE (`id` = '9');
UPDATE `furama_minhduc`.`facility` SET `id` = '4' WHERE (`id` = '10');
UPDATE `furama_minhduc`.`facility` SET `id` = '5' WHERE (`id` = '11');
UPDATE `furama_minhduc`.`facility` SET `id` = '6' WHERE (`id` = '12');

 UPDATE `furama_minhduc`.`employee` SET `id` = '1' WHERE (`id` = '11');
UPDATE `furama_minhduc`.`employee` SET `id` = '2' WHERE (`id` = '12');
UPDATE `furama_minhduc`.`employee` SET `id` = '3' WHERE (`id` = '13');
UPDATE `furama_minhduc`.`employee` SET `id` = '4' WHERE (`id` = '14');
UPDATE `furama_minhduc`.`employee` SET `id` = '5' WHERE (`id` = '15');
UPDATE `furama_minhduc`.`employee` SET `id` = '6' WHERE (`id` = '16');
UPDATE `furama_minhduc`.`employee` SET `id` = '7' WHERE (`id` = '17');
UPDATE `furama_minhduc`.`employee` SET `id` = '8' WHERE (`id` = '18');
UPDATE `furama_minhduc`.`employee` SET `id` = '9' WHERE (`id` = '19');
UPDATE `furama_minhduc`.`employee` SET `id` = '10' WHERE (`id` = '20');


INSERT INTO attach_facility (name,cost, unit,status)
VALUE ('Karaoke',10000,'Giờ','Tiện nghi, hiện đại'),
      ('Thuê xe máy',10000,'chiếc','Hỏng 1 xe'),
      ('Thuê xe đạp',20000,'chiếc','Tốt'),
      ('Buffet buổi sáng',15000,'suất','Đầy đủ đồ ăn, tráng miệng'),
      ('Buffet buổi trưa',90000,'suất','Đầy đủ đồ ăn, tráng miệng'),
      ('Buffet buổi tối',16000,'suất','Đầy đủ đồ ăn, tráng miệng');
 
INSERT INTO `furama_minhduc`.`contract` ( `start_date`,`end_date`,`deposit`,`employee_id`,`customer_id`,`facility_id`) 
VALUE ('2020-12-08','2020-12-08',0,3,1,3),
      ('2020-07-14','2020-07-21',200000,7,3,1),
      ('2021-03-15','2021-03-17',50000,3,4,2),
      ('2021-01-14','2021-01-18',100000,7,5,5),
      ('2021-07-14','2021-07-15',0,7,2,6),
      ('2021-06-01','2021-06-03',0,7,7,6),
      ('2021-09-02','2021-09-05',100000,7,4,4),
      ('2021-06-17','2021-06-18',150000,3,4,1),
      ('2020-11-19','2020-11-19',0,3,4,3),
      ('2020-04-12','2020-04-14',0,10,3,5),
	  ('2021-04-25','2021-04-25',0,2,2,1),
      ('2021-05-25','2021-05-27',0,7,10,1);
      
      UPDATE `furama_minhduc`.`contract` SET `id` = '1' WHERE (`id` = '25');
UPDATE `furama_minhduc`.`contract` SET `id` = '2' WHERE (`id` = '26');
UPDATE `furama_minhduc`.`contract` SET `id` = '3' WHERE (`id` = '27');
UPDATE `furama_minhduc`.`contract` SET `id` = '4' WHERE (`id` = '28');
UPDATE `furama_minhduc`.`contract` SET `id` = '5' WHERE (`id` = '29');
UPDATE `furama_minhduc`.`contract` SET `id` = '6' WHERE (`id` = '30');
UPDATE `furama_minhduc`.`contract` SET `id` = '7' WHERE (`id` = '31');
UPDATE `furama_minhduc`.`contract` SET `id` = '8' WHERE (`id` = '32');
UPDATE `furama_minhduc`.`contract` SET `id` = '9' WHERE (`id` = '33');
UPDATE `furama_minhduc`.`contract` SET `id` = '10' WHERE (`id` = '34');
UPDATE `furama_minhduc`.`contract` SET `id` = '11' WHERE (`id` = '35');
UPDATE `furama_minhduc`.`contract` SET `id` = '12' WHERE (`id` = '36');

 INSERT INTO `furama_minhduc`.`contract_detail` ( `quantity`,`contract_id`,`attach_facility_id`) 
VALUE (5,2,4),
 (8,2,5),
 (15,2,6),
 (1,3,1),
 (11,3,2),
 (1,1,3),
 (2,1,2),
 (2,12,2);

SELECT 
    *
FROM
    furama_minhduc.contract_detail
    join
    contract 
    on contract.id=contract_detail.contract_id
    join
    attach_facility
    on attach_facility.id=contract_detail.attach_facility_id
WHERE
    contract_id = 2;
    
    
    
--     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa




     SELECT 
		attach_facility.name nameFacility,
		customer.name nameCustomer,
		attach_facility.cost costAttachFacility,
		contract_detail.quantity quantity,
        facility.cost costFacility
          ,SUM((IFNULL(contract_detail.quantity * attach_facility.cost, 0)) + facility.cost) sumMony
            FROM
            customer
             join
            contract 
             on customer.id =contract.customer_id
             join
            facility
            on facility.id=contract.facility_id
 join
        contract_detail
        on contract_detail.contract_id=contract.id
          join
               attach_facility 
              on attach_facility.id=contract_detail.attach_facility_id
		WHERE
           customer_id = 1
            GROUP BY nameFacility;
            
            
--            ORDER BY customer.id;

-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

SELECT 
SUM((IFNULL(sumMony, 0))) tongTien,
nameFacility,
nameCustomer,
costAttachFacility,
quantity,
costFacility
from
(SELECT 
		attach_facility.name nameFacility,
		customer.name nameCustomer,
		attach_facility.cost costAttachFacility,
		contract_detail.quantity quantity,
        facility.cost costFacility
          ,SUM((IFNULL(contract_detail.quantity * attach_facility.cost, 0)) + facility.cost) sumMony
            FROM
            customer
           left  join
            contract 
             on customer.id =contract.customer_id
            left   join
            facility
            on facility.id=contract.facility_id
	left	 join
        contract_detail
        on contract_detail.contract_id=contract.id
         left join
               attach_facility 
              on attach_facility.id=contract_detail.attach_facility_id

		WHERE
           customer_id = 1
            GROUP BY nameFacility)AS bang2 

