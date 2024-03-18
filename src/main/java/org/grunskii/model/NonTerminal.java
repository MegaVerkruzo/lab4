package org.grunskii.model;

import java.util.List;

public record NonTerminal(
        String name,
        List<Attribute> attributes,
        String resultType,
        List<Rule> rules
) {
}
