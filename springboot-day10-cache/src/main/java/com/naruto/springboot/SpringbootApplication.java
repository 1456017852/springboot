package com.naruto.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 一、JSR107
 * jAVA Caching定义五个核心接口
 *
 * 1、缓存提供者：CachingProvidor
 *      定义了创建、配置、获取、管理和控制CacheManager，一个应用可以在运行期访问读个CachingProvidor
 * 2、缓存管理器CacheManager：
 *      定义了创建、配置、获取、管理和控制多个唯一命名的Cache，这些Cache存在于CacheManager的上下文中，
 *      一个CacheManager仅被一个CachingProvidor所拥有；
 * 3、缓存接口Cache:
 *      是一个类似于Map的数据结构并临时存储以key为索引的值，对缓存的CRUD操作，都借助于该对象，
 *      一个Cache仅被一个CacheManager所拥有；
 * 4、缓存数据Entry：
 *      是一个存储在Cache中的key-value对
 * 5、缓存有效期Expriy：
 *       每一个存储在Cache中的条目有一个定义的有效期，一旦超过这个有效期，条目为过期状态，
 *      一旦过期，条目将不能访问、更新、删除，缓存有效期通过ExpiryPolicy设置
 *
 * 二、spring的缓存抽象
 * 1、缓存概述
 *      每次调用需要缓存功能的方法时，Spring会检查指定参数的指定的目标方法是否已经被调用过；
 *      如果有就直接从缓存中获取方法调用后的结果，
 *      如果没有就调用方法并缓存结果后返回给用户，下次调用直接从缓存中获取。
 *
 * 2、spring对于cache的支持
 *      Spring从3.1开始定义了org.springframework.cache.Cache
 *      和org.springframework.cache.CacheManager接口来统一不同的缓存技术；
 *      并支持使用JCache（JSR-107）注解简化我们开发；
 *      Cache接口下Spring提供了各种xxxCache的实现；如RedisCache，EhCacheCache , ConcurrentMapCache等；
 *      Cache接口为缓存的组件规范定义，包含缓存的各种操作集合；
 *
 *      <1>支持使用JCache(JSR-107)注解开发
 *
 *          (1)、@EnableCaching：开启基于注解的缓存
 *
 *          (2)、@Cacheable：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 *              @Cacheable的属性：
 *                  value/cacheNames：缓存组件的名称
 *                  key:缓存数据的key(默认使用方法参数的值)
 *                  keyGenerator:指定key的生成策略
 *                  cacheManager:指定从哪个缓存管理器中获取该缓存
 *                  cacheResolver:指定从哪个缓存解析器中获取该缓存(cacheManager、cacheResolver二选一)
 *                  unless:指定的条件为true,不缓存(可以获取到方法的返回值进行判断) eg:unless="result==null"
 *                  condition:指定的条件符合，才缓存 eg:#id>0
 *                  sync:是否使用异步模式
 *
 *          (3)、@CachePut:保证方法被调用，又希望结果被缓存，修改数据库的数据，同时更新缓存(增加、修改)
 *                  @CachePut运行时机：先调用目标方法，同时更新缓存
 *                  @CachePut的属性：同@Cacheable(没有sync)
 *
 *          (4)、@CacheEvict:清空缓存
 *                  @CacheEvict的属性：
 *                      allEntries：清除value/cacheNames指定的所有的缓存
 *                      beforeInvocation:指定是否在方法执行前清除value/cacheNames指定的缓存(默认为false)，
 *                          beforeInvocation=false时，方法抛异常是缓存不会清除
 *                      其他的属性同@Cacheable
 *
 *          (5)、@Caching:主要针对复杂情况下缓存数据,可以同时指定cacheable、put、evict
 *
 *          (6)、Cacheconfig:表示在类上，可以将标识在方法上的注解的公共属性提取出来
 *
 *
 */
@MapperScan("com.naruto.springboot.mapper")
@SpringBootApplication
@EnableCaching//开启基于注解的缓存
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
