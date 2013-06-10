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
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This demonstrates that the workaround for SPR-9464 of using an
 * {@link ImportBeanDefinitionRegistrar} does not work since the bean is not yet
 * in the {@link BeanDefinitionRegistry}. We need all beans registered as is
 * guaranteed with {@link BeanDefinitionRegistryPostProcessor}. Specifically the
 * javadoc of {@link BeanDefinitionRegistryPostProcessor} states
 * "All regular bean definitions will have been loaded".
 *
 * @author Rob Winch
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JavaConfig.class)
public class JavaConfigTest{
    @Autowired
    private MyDynamicallyRegisteredClass registered;

    @Test
    public void definitionRegistrarSeesMyBean() {
    }
}
