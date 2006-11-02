package org.opengis.filter;

import java.util.Set;

import org.opengis.filter.identity.Identifier;

/**
 * A filter that passes only the Identifiers listed.
 * <p>
 * This application of this filter for Features is well established:
 * <ul>
 * <li>FeatureId - used for GML2 Features
 * <li>GeometryId - used for GML3 Features and Geometry constructs
 * </ul>
 * We also have the following identifiers:
 * <ul>
 * <li>RecordId - from CSW-2
 * <li>ObjectId - from CSW-2
 * </ul>
 * 
 * @author Chris Dillard (SYS Technologies)
 * @author Justin Deoliveira, The Open Planning Project
 *
 */
public interface Id extends Filter {
	/**
	 * Set of IDs representing the Identifiers used by this filter.
	 * 
     * @return {@linkplain Set} of IDs
     */
	Set<Object> getIDs();
	
	/**
     * @return {@linkplain Set} of Identifiers used by this filter.
     */
	Set<Identifier> getIdentifiers();
}