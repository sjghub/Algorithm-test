-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, date_format(hire_ymd,'%Y-%m-%d') 
from doctor 
where MCDP_CD = 'cs' or MCDP_CD = 'gs'
order by HIRE_YMD desc, dr_name asc;