/*
 * Copyright 2019 TWO SIGMA OPEN SOURCE, LLC
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

package org.testingisdocumenting.webtau.reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class WebTauTestList {
    private List<WebTauTest> tests;

    public WebTauTestList() {
        tests = Collections.synchronizedList(new ArrayList<>());
    }

    public WebTauTestList(List<WebTauTest> tests) {
        this.tests = Collections.synchronizedList(tests);
    }

    public void add(WebTauTest test) {
        tests.add(test);
    }

    public void forEach(Consumer<WebTauTest> action) {
        tests.forEach(action);
    }

    public Stream<WebTauTest> stream() {
        return tests.stream();
    }

    public int size() {
        return tests.size();
    }

    public boolean isEmpty() {
        return tests.isEmpty();
    }

    public Stream<WebTauTest> withStatus(TestStatus status) {
        return tests.stream().filter(e -> e.getTestStatus() == status);
    }

    public long countWithStatus(TestStatus status) {
        return withStatus(status).count();
    }

    public void clear() {
        tests.clear();
    }
}
