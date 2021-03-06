/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pivot.wtk.validation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * A validator for a regular expression.
 *
 * @see Pattern
 */
public class RegexTextValidator implements Validator {
    private Pattern p;

    public RegexTextValidator() {
    }

    public RegexTextValidator(Pattern p) {
        this.p = p;
    }

    public RegexTextValidator(String regexPattern) {
        this.p = Pattern.compile(regexPattern);
    }

    public Pattern getPattern() {
        return p;
    }

    public void setPattern(Pattern pattern) {
        this.p = pattern;
    }

    /**
     * @throws PatternSyntaxException If the expression's syntax is invalid
     */
    public void setPattern(String regexPattern) {
        this.p = Pattern.compile(regexPattern);
    }

    @Override
    public boolean isValid(String text) {
        return p.matcher(text).matches();
    }
}
