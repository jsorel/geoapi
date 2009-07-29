/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2004-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.metadata.acquisition;

import java.util.ArrayList;
import java.util.List;

import org.opengis.annotation.UML;
import org.opengis.util.CodeList;

import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * Ordered list of priorities.
 *
 * @author Cédric Briançon (Geomatys)
 *
 * @since GeoAPI 2.3
 */
@UML(identifier="MI_PriorityCode", specification=ISO_19115_2)
public final class Priority extends CodeList<Priority> {
    /**
     * Serial number for compatibility with different versions.
     */
    private static final long serialVersionUID = -3504801926504645861L;

    /**
     * List of all enumerations of this type.
     * Must be declared before any enum declaration.
     */
    private static final List<Priority> VALUES = new ArrayList<Priority>(4);

    /**
     * Decisive importance.
     */
    @UML(identifier="critical", obligation=CONDITIONAL, specification=ISO_19115_2)
    public static final Priority CRITICAL = new Priority("CRITICAL");

    /**
     * Requires resources to be made available.
     */
    @UML(identifier="highImportance", obligation=CONDITIONAL, specification=ISO_19115_2)
    public static final Priority HIGH_IMPORTANCE = new Priority("HIGH_IMPORTANCE");

    /**
     * Normal operation priority.
     */
    @UML(identifier="mediumImportance", obligation=CONDITIONAL, specification=ISO_19115_2)
    public static final Priority MEDIUM_IMPORTANCE = new Priority("MEDIUM_IMPORTANCE");

    /**
     * To be completed when resources are available
     */
    @UML(identifier="lowImportance", obligation=CONDITIONAL, specification=ISO_19115_2)
    public static final Priority LOW_IMPORTANCE = new Priority("LOW_IMPORTANCE");

    /**
     * Constructs an enum with the given name. The new enum is
     * automatically added to the list returned by {@link #values}.
     *
     * @param name The enum name. This name must not be in use by an other enum of this type.
     */
    private Priority(final String name) {
        super(name, VALUES);
    }

    /**
     * Returns the list of {@code Priority}s.
     *
     * @return The list of codes declared in the current JVM.
     */
    public static Priority[] values() {
        synchronized (VALUES) {
            return VALUES.toArray(new Priority[VALUES.size()]);
        }
    }

    /**
     * Returns the list of enumerations of the same kind than this enum.
     */
    public Priority[] family() {
        return values();
    }

    /**
     * Returns the priority that matches the given string, or returns a
     * new one if none match it.
     *
     * @param code The name of the code to fetch or to create.
     * @return A code matching the given name.
     */
    public static Priority valueOf(String code) {
        return valueOf(Priority.class, code);
    }
}
