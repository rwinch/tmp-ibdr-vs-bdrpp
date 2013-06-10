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
package sample.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sample.MyBeanDefinitionRegistryPostProcessor;

/**
 * This demonstrates that even if {@link MyBeanDefinitionRegistryPostProcessor}
 * is configured in XML and loaded with a Java Config {@link ApplicationContext}
 * it does not work. This is not unexpected since it
 * {@link ConfigurationClassPostProcessor} is trying to register a
 * {@link BeanDefinitionRegistryPostProcessor} which won't work.
 *
 * @author Rob Winch
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HybridJavaConfig.class)
public class HybridJavaTest {
    @Autowired
    private MyDynamicallyRegisteredClass registered;

    @Test
    public void definitionRegistrarSeesMyBean() {
    }
}

