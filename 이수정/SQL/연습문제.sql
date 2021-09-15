-- 1. emp 테이블에서 사원번호, 사원이름, 월급을 출력하시오. 
SELECT empno, ename, sal FROM emp;
-- 2. emp 테이블에서 사원이름과 월급을 출력하는데 컬럼명은 이 름, 월 급으로 바꿔서 출력하시오.
SELECT ename "이름", sal "월급"  FROM emp;
-- 3. emp 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 각각 컬럼명은 사원번호, 사원이름, 월급, 연봉으로 출력하시오. 
SELECT empno "사원번호", ename "사원이름", sal "월급", sal*12 "연봉" FROM emp;
-- 4. emp 테이블 의 업무(job)를 중복되지 않게 표시하시오.
SELECT DISTINCT job FROM emp;
-- 5. emp 테이블의 사원명과 업무로 연결(SMITH, CHECK)해서 표시하고 컬럼명은 Employee and job으로 표시하시오. 
SELECT CONCAT(CONCAT(ename,', '),job) "Employee and job" FROM emp;

-- 1. emp 테이블에서 사원번호가 7698 인 사원의 이름, 업무, 급여를 출력하시오. 
SELECT ename, job, sal FROM emp WHERE empno = 7698;
-- 2. emp 테이블에서 사원이름이 SMITH인 사람의 이름과 월급, 부서번호를 구하시오.
SELECT ename, job, deptno FROM emp WHERE ename = 'SMITH';
-- 3. 월급이 2500이상 3500미만인 사원의 이름, 입사일, 월급을 구하시오. 
SELECT ename, hiredate, sal FROM emp WHERE sal BETWEEN 2500 AND 3500;
-- 4. 급여가 2000에서 3000사이에 포함되지 않는 사원의 이름, 업무, 급여를 출력하시오.
SELECT ename, job, sal FROM emp WHERE NOT sal BETWEEN 2000 AND 3000;
-- 5. 81년05월01일과 81년12월03일 사이에 입사한 사원의 이름, 급여, 입사일을 출력하시오.
SELECT ename, job, hiredate FROM emp WHERE hiredate > TO_CHAR('81/05/01') AND hiredate < TO_CHAR('81/12/03');
-- 6. emp테이블에서 사원번호가 7566,7782,7934인 사원을 제외한 사람들의 사원번호,이름, 월급을 출력하시오. 
SELECT empno, ename, sal FROM emp WHERE empno NOT IN(7566,7782,7934);
