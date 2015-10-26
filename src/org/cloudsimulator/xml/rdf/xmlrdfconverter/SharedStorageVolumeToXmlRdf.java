/* Icaro Cloud Simulator (ICLOS).
   Copyright (C) 2015 DISIT Lab http://www.disit.org - University of Florence

   This program is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License
   as published by the Free Software Foundation; either version 2
   of the License, or (at your option) any later version.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA. */

package org.cloudsimulator.xml.rdf.xmlrdfconverter;

import org.cloudsimulator.domain.ontology.SharedStorageVolume;
import org.cloudsimulator.repository.NameSpaceRepository;
import org.cloudsimulator.xml.XmlUtility;
import org.jdom2.Namespace;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class SharedStorageVolumeToXmlRdf {

    private SharedStorageVolumeToXmlRdf() {
        // Not Called
    }

    public static Element createSharedStorageVolumeElement(
            final Namespace nameSpace, final Document documentParent,
            final SharedStorageVolume sharedStorageVolume) {

        Element sharedStorageVolumeElement = documentParent.createElementNS(
                nameSpace.getURI(), nameSpace.getPrefix()
                        + ":SharedStorageVolume");
        sharedStorageVolumeElement.setAttributeNS(
                NameSpaceRepository.RDF.getURI(),
                NameSpaceRepository.RDF.getPrefix() + ":about",
                sharedStorageVolume.getUri());
        sharedStorageVolumeElement.appendChild(XmlUtility
                .createSimpleTextElement(nameSpace, documentParent, "hasName",
                        sharedStorageVolume.getHasName()));
        sharedStorageVolumeElement
                .appendChild(XmlUtility.createSimpleTextElement(nameSpace,
                        documentParent, "hasIdentifier",
                        sharedStorageVolume.getHasIdentifier()));
        sharedStorageVolumeElement.appendChild(XmlUtility.createDecimalElement(
                nameSpace, documentParent, "hasDiskSize",
                sharedStorageVolume.getHasDiskSize()));

        return sharedStorageVolumeElement;
    }
}
