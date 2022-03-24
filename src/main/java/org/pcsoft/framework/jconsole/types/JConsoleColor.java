package org.pcsoft.framework.jconsole.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum JConsoleColor {
    BLACK(0),
    RED(1),
    GREEN(2),
    YELLOW(3),
    BLUE(4),
    MAGENTA(5),
    CYAN(6),
    LIGHT_GRAY(7),
    DEFAULT(9),
    DARK_GRAY(60),
    LIGHT_RED(61),
    LIGHT_GREEN(62),
    LIGHT_YELLOW(63),
    LIGHT_BLUE(64),
    LIGHT_MAGENTA(65),
    LIGHT_CYAN(66),
    WHITE(67),
    ;

    private final int ansiCode;
}
