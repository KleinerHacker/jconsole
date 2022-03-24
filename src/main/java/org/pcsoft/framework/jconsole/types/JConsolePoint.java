package org.pcsoft.framework.jconsole.types;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public final class JConsolePoint {
    private final int x;
    private final int y;
}
