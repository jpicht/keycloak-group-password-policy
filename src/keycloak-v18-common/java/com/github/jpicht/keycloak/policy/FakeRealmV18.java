/*
 * Copyright 2021 Brian Long (brian@inteligr8.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jpicht.keycloak.policy;

import org.keycloak.models.ParConfig;

import java.util.Map;

public class FakeRealmV18 extends FakeRealmV15 {


    @Override
    public void createOrUpdateRealmLocalizationTexts(String locale, Map<String, String> localizationTexts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
