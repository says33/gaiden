/*
 * Copyright 2013 the original author or authors
 *
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

package gaiden.markdown

import org.pegdown.LinkRenderer
import org.pegdown.ParsingTimeoutException
import org.pegdown.PegDownProcessor

/**
 * A Processor for Markdown.
 *
 * @author Hideki IGARASHI
 * @author Kazuki YAMAMOTO
 */
class GaidenMarkdownProcessor extends PegDownProcessor {

    GaidenMarkdownProcessor(int options) {
        super(options)
    }

    /**
     * Converts the given markdown source to HTML.
     *
     * @param markdownSource the markdown source to convert
     * @param outputPath the relative path from the output directory
     * @return the HTML
     * @throws ParsingTimeoutException if the input cannot be parsed within the configured parsing timeout
     */
    String markdownToHtml(String markdownSource, String outputPath) throws ParsingTimeoutException {
        def astRoot = parseMarkdown(markdownSource.toCharArray())
        new GaidenToHtmlSerializer(new LinkRenderer(), new ImageRenderer(outputPath)).toHtml(astRoot)
    }

}
