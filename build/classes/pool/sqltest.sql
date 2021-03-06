select userid,ssn,name,roll,teamid,password,age,gender,subject FROM MEMBER  WHERE name  LIKE '형준';
SELECT * FROM MEMBER;
--페이지 수를 구하는 쿼리
SELECT CEIL(COUNT(*)/5) "PAGE" 
from member;

--전체 ROWNUM DESC
SELECT ROWNUM R, CEIL(ROWNUM/5)PAGE, M.* 
FROM MEMBER M 
ORDER BY ROWNUM DESC;

-- 페이지당 회원의 ID만 보여주는 쿼리
SELECT T2.MEM_ID
FROM (SELECT  *
FROM    (
        SELECT  CEIL(ROWNUM/5) PAGE, MEM_ID
        FROM    (
                SELECT  *
                FROM    MEMBER
                ) T1
        )
WHERE PAGE LIKE 4) T2
ORDER BY ROWNUM DESC;

-- 강사님 쿼리
SELECT T.*
FROM (SELECT ROWNUM SEQ, M.*
FROM MEMBER M
ORDER BY SEQ DESC) T
WHERE T.SEQ BETWEEN 1 AND 5