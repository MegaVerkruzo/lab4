package org.grunskii.model;

import java.util.List;

public record RuleArgument(boolean isToken, String name, String type, List<String> inherits) {
}
