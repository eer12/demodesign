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

import java.lang.annotation.*;

/**
 * declare the transaction only execute in single local RM,<br/>
 * but the transaction need to ensure records to update(or select for update) is not in global transaction middle
 * stage<br/>
 *
 * use this annotation instead of GlobalTransaction in the situation mentioned above will help performance.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface GlobalLock {
}
