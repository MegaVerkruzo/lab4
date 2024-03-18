package org.grunskii.model;

import java.util.List;

public record Rule(List<RuleArgument> arguments, String result) {
}
