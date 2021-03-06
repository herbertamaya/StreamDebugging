package net.nycjava.darkcorners2.streamdebugging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Arrays.stream;
import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static net.nycjava.darkcorners2.streamdebugging.StreamLogger.debug;

public class BaseWithStaticImports {

    public static final String[] WORDS = "The quick brown fox jumped over the lazy dog".split(" ");
    public static final Predicate<String> NOT_XYZ = compile("[XYZ]").asPredicate().negate();

    public static void main(String[] args) {
        // using static imports to keep it terse
        String result = stream(WORDS).
                map(String::toUpperCase).
                filter(NOT_XYZ).
                sorted().
                distinct().
                collect(joining(" "));

        out.println(result);
    }
}
