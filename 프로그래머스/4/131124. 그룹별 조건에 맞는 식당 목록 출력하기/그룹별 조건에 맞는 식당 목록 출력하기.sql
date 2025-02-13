SELECT P.MEMBER_NAME, R.REVIEW_TEXT, TO_CHAR(R.REVIEW_DATE,'YYYY-MM-DD') AS REVIEW_DATE
FROM REST_REVIEW R JOIN MEMBER_PROFILE P
ON R.MEMBER_ID=P.MEMBER_ID
WHERE R.MEMBER_ID IN (SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(*)=(SELECT MAX(COUNT(*))
        FROM REST_REVIEW 
        GROUP BY MEMBER_ID))

ORDER BY 3,2



