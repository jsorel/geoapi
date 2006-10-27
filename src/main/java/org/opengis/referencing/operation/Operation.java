/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2003-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.referencing.operation;

// OpenGIS direct dependencies
import org.opengis.parameter.ParameterValueGroup;

// Annotations
import org.opengis.annotation.UML;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * A parameterized mathematical operation on coordinates that transforms or converts
 * coordinates to another coordinate reference system. This coordinate operation thus
 * uses an operation method, usually with associated parameter values.
 *  
 * @version <A HREF="http://portal.opengeospatial.org/files/?artifact_id=6716">Abstract specification 2.0</A>
 * @author ISO/DIS 19111
 * @author Martin Desruisseaux (IRD)
 * @since GeoAPI 1.0
 *
 * @see OperationMethod
 */
@UML(identifier="CC_Operation", specification=ISO_19111)
public interface Operation extends SingleOperation {
    /**
     * Returns the operation method.
     */
    @UML(identifier="usesMethod", obligation=MANDATORY, specification=ISO_19111)
    OperationMethod getMethod();

    /**
     * Returns the parameter values.
     *
     * @rename Added "{@code Parameter}" prefix for more consistency with the return type.
     */
    @UML(identifier="usesValue", obligation=MANDATORY, specification=ISO_19111)
    ParameterValueGroup getParameterValues();
}
