## Spring Boot 3.X basic project with Spring Security & Filter

### controller filter

- JDK17 required.
- Lombok imported.
- Slf4j imported.
---
* add jpa and database dependency to pom.
  * jpa
  * PostgreSQL
    
* add spring-boot-starter-security dependency to pom.
  * add security config (SecurityConfig.java)
    * let api path /account and post method permitAll.     
    * let api path /account/?* and get method permitAll.
    * else authenticated required.
---
* expected api result (api protected)
  * account and post method, 200 OK.
  * account/?* and get method, 200 OK.
  * accounts and get method, 403 Forbidden.
  * every api request and response data is logged by global filter.
  * only /account api path is logged by custom filter.
    

* filter
  we can use ordered filters. 
  ![](https://github.com/benjamin-kuo/images/blob/main/turtorial/SpringFilter.png?raw=true)
