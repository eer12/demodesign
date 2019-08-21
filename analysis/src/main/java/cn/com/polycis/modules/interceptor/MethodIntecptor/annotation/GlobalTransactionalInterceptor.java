/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package cn.com.polycis.modules.interceptor.MethodIntecptor.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Global transactional interceptor.
 *
 * @author jimin.jm @alibaba-inc.com
 */
@Component
public class GlobalTransactionalInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalTransactionalInterceptor.class);



    @Override
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
        Class<?> targetClass = (methodInvocation.getThis() != null ? AopUtils.getTargetClass(methodInvocation.getThis()) : null);
        Method specificMethod = ClassUtils.getMostSpecificMethod(methodInvocation.getMethod(), targetClass);
        final Method method = BridgeMethodResolver.findBridgedMethod(specificMethod);

        final GlobalTransactional globalTransactionalAnnotation = getAnnotation(method, GlobalTransactional.class);
        final GlobalLock globalLockAnnotation = getAnnotation(method, GlobalLock.class);
        if (globalTransactionalAnnotation != null) {
            return true;
        } else if (globalLockAnnotation != null) {
            return false;
        } else {
            return methodInvocation.proceed();
        }
    }



    private <T extends Annotation> T getAnnotation(Method method, Class<T> clazz) {
        if (method == null) {
            return null;
        }
        return method.getAnnotation(clazz);
    }

    private String formatMethod(Method method) {
        String paramTypes = Arrays.stream(method.getParameterTypes())
                .map(Class::getName)
                .collect(Collectors.joining(", ", "(", ")"));
        return method.getName() + paramTypes;
    }
}
