/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;

import sample.config.MyDynamicallyRegisteredClass;

/**
 * Consistent way of registering the {@link MyDynamicallyRegisteredClass}
 * @author Rob Winch
 *
 */
class RegisterBeanUtil {

    static void registerCustom(String beanName,
            BeanDefinitionRegistry registry) throws BeansException {
        boolean beanExists = registry.containsBeanDefinition(beanName);

        if(beanExists) {
            String beanClass = MyDynamicallyRegisteredClass.class.getName();
            registry.registerBeanDefinition(RegisterBeanUtil.class.getName()+"." + beanName,
                    new RootBeanDefinition(beanClass));
        }
    }

}
