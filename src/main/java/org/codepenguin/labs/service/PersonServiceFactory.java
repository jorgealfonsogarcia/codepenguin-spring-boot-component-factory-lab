/*
 * MIT License
 *
 * Copyright (c) 2022 CodePenguin.org - Jorge Alfonso Garcia Espinosa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package org.codepenguin.labs.service;

import org.codepenguin.labs.enums.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Factory component that returns the service according to the country.
 *
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
@Component
public class PersonServiceFactory {

    private final PersonService usPersonService;
    private final PersonService gbPersonService;

    /**
     * Constructor.
     *
     * @param usPersonService the service for US persons.
     * @param gbPersonService the service for GB persons.
     */
    @Autowired
    public PersonServiceFactory(@Qualifier("usPersonService") final PersonService usPersonService,
                                @Qualifier("gbPersonService") final PersonService gbPersonService) {
        this.usPersonService = usPersonService;
        this.gbPersonService = gbPersonService;
    }

    /**
     * Gets the service by country.
     *
     * @param country the country.
     * @return the service.
     */
    public PersonService get(final Country country) {
        return switch (country) {
            case US -> usPersonService;
            case GB -> gbPersonService;
        };
    }
}
