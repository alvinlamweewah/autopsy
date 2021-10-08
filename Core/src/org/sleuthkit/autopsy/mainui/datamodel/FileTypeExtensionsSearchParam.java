/*
 * Autopsy Forensic Browser
 *
 * Copyright 2021 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.mainui.datamodel;

import java.util.Objects;

/**
 * Key for accessing data about file type extensions from the DAO.
 */
public class FileTypeExtensionsSearchParam {

    private final FileExtSearchFilter filter;
    private final Long dataSourceId;
    private final boolean knownShown;

    // TODO: This should ideally take in some kind of ENUM once we redo the tree.
    // this assumes that filters implicitly or explicitly implement hashCode and equals to work
    public FileTypeExtensionsSearchParam(FileExtSearchFilter filter, Long dataSourceId, boolean showKnown) {
        this.filter = filter;
        this.dataSourceId = dataSourceId;
        this.knownShown = showKnown;
    }

    public FileExtSearchFilter getFilter() {
        return filter;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public boolean isKnownShown() {
        return knownShown;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.filter);
        hash = 23 * hash + Objects.hashCode(this.dataSourceId);
        hash = 23 * hash + (this.knownShown ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileTypeExtensionsSearchParam other = (FileTypeExtensionsSearchParam) obj;
        if (this.knownShown != other.knownShown) {
            return false;
        }
        if (!Objects.equals(this.filter, other.filter)) {
            return false;
        }
        if (!Objects.equals(this.dataSourceId, other.dataSourceId)) {
            return false;
        }
        return true;
    }

}
