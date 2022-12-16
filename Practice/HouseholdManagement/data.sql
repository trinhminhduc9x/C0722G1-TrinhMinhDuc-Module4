use househol;

SELECT * FROM househol.househol;

SELECT * FROM househol.member;
-- join cac bang
SELECT *
FROM househol h 
JOIN
member m ON h.id_househol = m.househol_id;

-- join cac bang
SELECT h.id_househol as idHousehol,
m.name as nameMember,
h.number_member as numberMember,
h.start_day as startDay,
h.address as address,
COUNT(m.househol_id) as count
FROM member m 
JOIN
househol h 
ON h.id_househol = m.househol_id
where m.member_type_id = 1
HAVING count = ( 
SELECT 
 COUNT(househol_id) as count
   FROM member
   where househol_id like 1
   );


-- xoa mot cot trong mot bang
ALTER TABLE househol
DROP COLUMN member_id;

-- đêm các id giống nhau trong 1 bang
 SELECT 
 COUNT(househol_id) as count
   FROM member
   where househol_id like 1;
   
   SELECT * FROM member
   where househol_id = 1;
