package org.grunskii;

import org.grunskii.model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstFollow {
    public static Map<String, Set<String>> first = new HashMap<>();
    public static Map<String, Set<String>> follow = new HashMap<>();
    private static final String EPSILON = "$$$$$EPSILON";

    public static void makeFirstFollow() {
        makeFirst();
        makeFollow();
    }

    public static boolean checkLL1() {
        for (NonTerminal nonTerminal : InfoClass.nonTerminals.values()) {
            int n = nonTerminal.rules().size();

            // empty
            for (int i = 0; i < n; ++i) {
                if (nonTerminal.rules().get(i).arguments().isEmpty()) {
                    for (int j = 0; j < n; ++j) {
                        if (i == j) continue;
                        final Set<String> second = new HashSet<>();
                        RuleArgument beta = nonTerminal.rules().get(j).arguments().get(0);
                        if (beta.isToken()) {
                            second.add(beta.type());
                        } else {
                            second.addAll(first.get(beta.type()));
                        }

                        if (follow.get(nonTerminal.name()).stream().anyMatch(second::contains)) {
                           return false;
                        }
                    }
                }
            }

            // full
            for (int i = 0; i < n; ++i) {
                if (nonTerminal.rules().get(i).arguments().isEmpty()) continue;
                final Set<String> firstSet = new HashSet<>();
                RuleArgument alpha = nonTerminal.rules().get(i).arguments().get(0);
                if (alpha.isToken()) {
                    firstSet.add(alpha.type());
                } else {
                    firstSet.addAll(first.get(alpha.type()));
                }

                for (int j = i + 1; j < n; ++j) {
                    final Set<String> secondSet = new HashSet<>();
                    RuleArgument beta = nonTerminal.rules().get(j).arguments().get(0);
                    if (beta.isToken()) {
                        secondSet.add(beta.type());
                    } else {
                        secondSet.addAll(first.get(beta.type()));
                    }

                    if (firstSet.stream().anyMatch(secondSet::contains)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void makeFirst() {
        fillEmpty(first);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (NonTerminal nonTerminal : InfoClass.nonTerminals.values()) {
                for (Rule rule : nonTerminal.rules()) {
                    Set<String> set = first.get(nonTerminal.name());
                    if (rule.arguments().isEmpty() && set.add(EPSILON)) {
                        changed = true;
                    } else if (!rule.arguments().isEmpty()) {
                        RuleArgument arg = rule.arguments().get(0);
                        if ((arg.isToken() && set.add(arg.type()))
                                || (!arg.isToken() && set.addAll(first.get(arg.type())))) {
                            changed = true;
                        }
                    }
                }
            }
        }
    }

    private static void makeFollow() {
        fillEmpty(follow);

        if (InfoClass.orderNonTerminals.isEmpty()) {
            throw new IllegalArgumentException("Can't have no rules");
        }
        follow.get(InfoClass.orderNonTerminals.get(0)).add(EPSILON);

        boolean changed = true;
        while (changed) {
            changed = false;
            for (String nonTerminalName : InfoClass.orderNonTerminals) {
                for (Rule rule : InfoClass.nonTerminals.get(nonTerminalName).rules()) {
                    List<RuleArgument> arguments = rule.arguments();
                    for (int i = 0; i < arguments.size(); i++) {
                        RuleArgument cur = arguments.get(i);
                        if (cur.isToken()) continue;

                        if (i + 1 == arguments.size()) {
                            changed = changed || follow.get(cur.type()).addAll(follow.get(nonTerminalName));
                            continue;
                        }

                        RuleArgument next = arguments.get(i + 1);
                        if (next.isToken()) {
                            changed = changed || follow.get(cur.type()).add(next.type());
                            continue;
                        }

                        changed = changed || follow.get(cur.type()).addAll(getWithoutEpsilon(first.get(next.type())));

                        if (first.get(next.type()).contains(EPSILON)) {
                            changed = changed || follow.get(cur.type()).addAll(follow.get(next.type()));
                        }
                    }
                }
            }
        }
    }

    private static void fillEmpty(Map<String, Set<String>> map) {
        for (String nonTerminal : InfoClass.nonTerminals.keySet()) {
            map.put(nonTerminal, new HashSet<>());
        }
    }

    private static Set<String> getWithoutEpsilon(Set<String> set) {
        return set.stream().filter(str -> !str.equals(EPSILON)).collect(Collectors.toSet());
    }
}
