package com.naruto.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 一、springboot的配置文件：
 *
 * 1、作用：
 *  springboot的自动配置原理知道，springboot自动给IOC容器中导入许多配置类,这些配资类给组件配置好了许多默认属性。
 *  我们可以通过配置文件，来修改springboot通过自动配置类配置的默认属性值
 *
 * 2、格式：
 *  springboot有两种格式的配置文件：.properties和.yaml(yml)
 *  程序启动时，优先使用application.properties中的配置
 *
 *  <1>.properties比较熟悉，就不讲了
 *  <2>.yml
 *     (1)、基本语法：
 *          K:(空格)v
 *          以空格的缩进来控制层级关系,左对齐的是同一级,大小写敏感
 *     (2)、值的写法：
 *
 *          字面量：(数字、字符串、boolean)
 *
 *              字符串默认不加单引号或者双引号
 *              双引号：不会转移特殊字符 例如，name: "naruto\n wangli" -->naruto\n wangli
 *              单引号：会转义特殊字符 例如，name: "naruto\n wangli" -->naruto
 *                                                                  wangli
 *
 *          对象、Map：k: v
 *
 *              firends:
 *                  name: naruto
 *                  age: 18
 *
 *              行内写法:firends: {name: naruto,age: 18}
 *
 *          数组、List:
 *               animal:
 *                - cat
 *                - dog
 *                - pig
 *
 *               行内写法：animal: [cat,dog,pig]
 *
 * 3、实战
 *  (1)在pom.xml中配置文件处理器 配置文件的提示
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-configuration-processor</artifactId>
 *             <optional>true</optional>
 *         </dependency>
 *  (2) 编写配置文件
 *      person:
 *          id: 1
 *          name: "naruto \n wangli"
 *          isBoss: false
 *          birth: 2019-05-26
 *          maps: {k1: v1,k2: v2}
 *          lists:
 *              - v1
 *              - v2
 *              - v3
 *          dog:
 *              name: pandora
 *              age: 5
 *   (3) 编写配置类
 *      @Component
 *      @ConfigurationProperties(prefix = "person")
 *   (4)在ConfigApplicationTests中测试
 *
 * 4、springboot读取配置文件的属性配置
 *  (1)@ConfigurationProperties(prefix = "XXX")读取springboot的配置文件
 *  (2)@Value读取springboot的配置文件
 *  (3)PropertySource("classpath:XXX")+@Value读取自定义的配置文件
 *  (4)@ImportResource读取自定义的spring配置文件
 *
 * 5、springboot配置文件的加载位置
 * springboot会扫描一下位置的application*.properties或者application.yml作为Springboot的默认配置文件
 *      ./config/
 *      ./
 *      classpath:/config/
 *      classpath:/
 * 加载优先级由高到低,高优先级的会覆盖低优先级的配置，互补配置
 *
 * 还可以通过spring.config.location来指定springboot的配置文件
 *
 *
 */

@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
